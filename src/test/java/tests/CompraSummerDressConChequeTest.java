package tests;

import controlflows.IfConditions;
import controlflows.WhileConditions;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


public class CompraSummerDressConChequeTest extends GlobalTestSetup{

    public static final String URL_TIENDA = "http://www.automationpractice.pl/";
    private static final String CSS_SELECTOR_CAMPO_EMAIL = "#email";
    private static final String CSS_SELECTOR_CAMPO_PASSWORD = "#passwd";
    private static final String XPATH_BOTON_SUBMIT_LOGIN = "//button[@id='SubmitLogin']";

    /*Pagina dos*/
    private static final String XPATH_IMAGEN_DRESSES = "(//a[@title='Dresses'])[2]";
    private static final String XPATH_SUMMER_DRESSES = "(//a[@title='Summer Dresses'])[2]";

    /*Pagina Cuatro*/
    private static final String XPATH_VESTIDO_DE_VERANO = "//img[@src='http://www.automationpractice.pl/img/p/1/6/16-home_default.jpg']";
    /*Pagina Quinta*/
    private static final String ID_SELECT_ELEMENT = "group_1";
    String[] tallas = {"S", "M", "L"};
    private static final String XPATH_ADD_TO_CART_BUTTON = "//button[@name='Submit' and @class='exclusive']";
    private static final String JS_SHOW_BUTTON = "arguments[0].style.display='block'; arguments[0].disabled=false;";

    private static final String XPATH_ICON_CHECK = "//i[@class='icon-check']";
    private static final String XPATH_BUTTON_CHECKOUT = "//span[contains(text(),'Proceed to checkout')]";

    /*Pagina Sexta*/
    private static final String XPATH_BUTTON_CHECKOUT1 = "//a[@class='button btn btn-default standard-checkout button-medium']";
    private static final String XPATH_BUTTON_CHECKOUT2 = "//button[@type='submit']//span[contains(text(),'Proceed to checkout')]";
    private static final String XPATH_BUTTON_CHECKOUT3 = "//input[@id='cgv']";
    private static final String XPATH_BUTTON_CHECKOUT4 = "//button[@type='submit']//span[contains(text(),'Proceed to checkout')]";
    private static final String XPATH_BUTTON_CHECKOUT5 = "//a[@title='Pay by check.']";
    private static final String XPATH_BUTTON_CHECKOUT6 = "//span[contains(text(),'I confirm my order')]";
    private static final String XPATH_BANNER_ORDEN_COMPLETA = "//p[@class='alert alert-success']";
    private IfConditions ifConditions = new IfConditions();
    private WhileConditions whileConditions = new WhileConditions();

    /* Método que contiene el test para realizar una compra en la tienda*/
    @Test
    public void hacerUnaConsulta() {
        /*Crea un WebDriverWait para esperar a que ciertos elementos estén visibles o sean clicables*/
        wait = new WebDriverWait(firefoxDriver, Duration.ofSeconds(TIMEOUT_IN_SECONDS));
        /*Se utiliza para navegar a una URL específica */
        firefoxDriver.get(URL_TIENDA);
        /*Establece un tiempo de espera implícito antes de interactuar con elementos*/
        /*Encuentra el botón de inicio de sesión en la página principal*/
        paginaPrincipal.irASignIn();
        /*agregar comentario*/
        whileConditions.clickWhenClickable(paginaPrincipal.irASignIn(),"Pagina Principal",true,10);
        /*Encuentra el campo de email e ingresa el correo electrónico*/
        WebElement inputEmail = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(CSS_SELECTOR_CAMPO_EMAIL)));
        ifConditions.sendKeysIfVisible(inputEmail,"yarcovisth2@gmail.com","Input del Email");
        WebElement inputPassword = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(CSS_SELECTOR_CAMPO_PASSWORD)));
        ifConditions.sendKeysIfVisible(inputPassword,"Luzelena1*","Input del Password");
        WebElement botonInicioSesion2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(XPATH_BOTON_SUBMIT_LOGIN)));
        /*Hace clic en el botón de inicio de sesión después de ingresar las credenciales*/
        whileConditions.clickWhenClickable(botonInicioSesion2,"o Boton de Inicio de Sesion ",true,10);
        /*Espera hasta que el elemento 'Dresses' sea visible*/
        WebElement imagenDeCompra = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(XPATH_IMAGEN_DRESSES)));
        /*Inicializa la clase Actions para realizar interacciones avanzadas con el ratón*/
        Actions accion = new Actions(firefoxDriver);
        /*Mueve el ratón hacia el elemento 'imagenDeCompra'*/
        ifConditions.moveToElementIfVisible(imagenDeCompra,accion,"Imagen de compra");
        /*Espera hasta que el submenú 'Summer Dresses' sea visible*/
        WebElement summerDresses = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(XPATH_SUMMER_DRESSES)));
        /*Comprueba si el submenú 'Summer Dresses' es visible y hace clic si es así*/
        ifConditions.clickIfVisible(summerDresses, "Submenu Summer Dresses");
        /*Encuentra la imagen del vestido de verano y hace clic en ella*/
        WebElement vestidoDeVerano = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(XPATH_VESTIDO_DE_VERANO)));
        ifConditions.clickIfVisible(vestidoDeVerano, "Imagen del vestido");
        /*Encuentra el desplegable para seleccionar la talla*/
        WebElement selectElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.id(ID_SELECT_ELEMENT)));
        ifConditions.selectDropdownAndForceChange(selectElement,1,tallas,"talla", firefoxDriver,JS_SHOW_BUTTON);
        /*Encuentra el botón 'Add to Cart' y lo habilita usando JavaScript*/
        WebElement addToCartButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(XPATH_ADD_TO_CART_BUTTON)));
       /*Espera hasta que el botón 'Add to Cart' esté clicable*/      /*Falta agregar comentario*/
        wait.until(ExpectedConditions.elementToBeClickable(addToCartButton));
        ifConditions.clickIfVisible(addToCartButton, "Boton add Carr Button " );
        /* Verifica si el botón es visible*/
        /*Espera hasta que aparezca el ícono de check de confirmación de compra*/
        WebElement checkCheckout = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(XPATH_ICON_CHECK)));
        /*Mueve el ratón hacia el ícono de check**/
        ifConditions.moveToElementIfVisible(checkCheckout, accion,"Check" );
        /*Espera hasta que la opción 'Proceed to checkout' sea visible*/
        WebElement buttonCheckout = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(XPATH_BUTTON_CHECKOUT)));
        /*Comprueba si la opción 'Proceed to checkout' es visible y hace clic si es así*/
        ifConditions.clickIfVisible(buttonCheckout, "CheckOut");
        /*Encuentra y hace clic en los botones de 'Checkout' en los siguientes pasos del proceso*/
        WebElement buttonCheckout1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(XPATH_BUTTON_CHECKOUT1)));
        ifConditions.clickIfVisible(buttonCheckout1, "Boton CheckOut Summary y Sign In");
        WebElement buttonCheckout2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(XPATH_BUTTON_CHECKOUT2)));
        ifConditions.clickIfVisible(buttonCheckout2, "Boton CheckOut Address");
        WebElement buttonCheckout3 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(XPATH_BUTTON_CHECKOUT3)));
        ifConditions.selectCheckboxIfNotSelected(buttonCheckout3, "cgv");
        WebElement buttonCheckout4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(XPATH_BUTTON_CHECKOUT4)));
        ifConditions.clickIfVisible(buttonCheckout4, "Boton CheckOut Shipping");
        WebElement buttonCheckout5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(XPATH_BUTTON_CHECKOUT5)));
        ifConditions.clickIfVisible(buttonCheckout5, "Boton CheckOut Payment (pay by check)");
        WebElement buttonCheckout6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(XPATH_BUTTON_CHECKOUT6)));
        ifConditions.clickIfVisible(buttonCheckout6, "Boton I confirm my order");
        /*Verifica si el banner de confirmación de la orden es visible y contiene el texto correcto*/
         WebElement bannerOrdenCompleta = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(XPATH_BANNER_ORDEN_COMPLETA)));
        /*Verifica si el banner de confirmación está visible*/
        ifConditions.validateBannerText(bannerOrdenCompleta, "Your order on My Shop is complete.");

    }
}


