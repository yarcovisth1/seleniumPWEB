import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.concurrent.TimeUnit;


public class PruebaTest {
    /*Declaración del WebDriver para Firefox  (Pagina uno)*/
    private WebDriver firefoxDriver;
    public static final String URL_TIENDA = "http://www.automationpractice.pl/";
    private static final String XPATH_BOTON_INICIO_SESION = "//a[@class='login']";
    private static final String CSS_SELECTOR_CAMPO_EMAIL = "#email";
    private static final String CSS_SELECTOR_CAMPO_PASSWORD = "#passwd";
    private static final String XPATH_BOTON_SUBMIT_LOGIN = "//button[@id='SubmitLogin']";

    /*Pagina dos*/
    private static final int TIMEOUT_IN_SECONDS = 10;
    private static final String XPATH_IMAGEN_DRESSES = "(//a[@title='Dresses'])[2]";
    private static final String XPATH_SUMMER_DRESSES = "(//a[@title='Summer Dresses'])[2]";

    /*Pagina Cuatro*/
    private static final int IMPLICIT_WAIT_TIME = 10;
    private static final TimeUnit TIME_UNIT = TimeUnit.SECONDS;
    private static final String XPATH_VESTIDO_DE_VERANO = "//img[@src='http://www.automationpractice.pl/img/p/1/6/16-home_default.jpg']";
    /*Pagina Quinta*/
    private static final String ID_SELECT_ELEMENT = "group_1";
    private static final String TALLA_M = "M";
    private static final String JS_FORCE_CHANGE_EVENT = "arguments[0].dispatchEvent(new Event('change'));";
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



    /*Método que se ejecuta antes de cada test para inicializar el driver de Firefox*/
    @Before
    public void abrirDriver(){
        /*Encontrar la Ruta del geckodriver*/
        System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver");
        /*Configurar opciones para el navegador Firefox.*/
        FirefoxOptions options = new FirefoxOptions();
        /*Inicializa el WebDriver con las opciones configuradas*/
        firefoxDriver = new FirefoxDriver(options);
        /*Configura un tiempo de espera implícito para encontrar elementos*/
        firefoxDriver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT_TIME, TIME_UNIT);
    }
    /* Método que contiene el test para realizar una compra en la tienda*/
    @Test
    public void hacerUnaConsulta() {
        /*Crea un WebDriverWait para esperar a que ciertos elementos estén visibles o sean clicables*/
        WebDriverWait wait = new WebDriverWait(firefoxDriver, Duration.ofSeconds(TIMEOUT_IN_SECONDS));
        /*Se utiliza para navegar a una URL específica */
        firefoxDriver.get(URL_TIENDA);
        /*Establece un tiempo de espera implícito antes de interactuar con elementos*/
        /*firefoxDriver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT_TIME, TIME_UNIT);*/
        /*Encuentra el botón de inicio de sesión en la página principal*/
        WebElement botonInicioSesion1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(XPATH_BOTON_INICIO_SESION)));
        /*Hace clic en el botón de inicio de sesión*/
        botonInicioSesion1.click();
        /*Encuentra el campo de email e ingresa el correo electrónico*/
        WebElement inputEmail = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(CSS_SELECTOR_CAMPO_EMAIL)));
                inputEmail.sendKeys("yarcovisth2@gmail.com");
        WebElement inputPassword = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(CSS_SELECTOR_CAMPO_PASSWORD)));
                inputPassword.sendKeys("Luzelena1*");
        WebElement botonInicioSesion2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(XPATH_BOTON_SUBMIT_LOGIN)));
        /*Hace clic en el botón de inicio de sesión después de ingresar las credenciales*/
        botonInicioSesion2.click();


        /*Espera hasta que el elemento 'Dresses' sea visible*/
        WebElement imagenDeCompra = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(XPATH_IMAGEN_DRESSES)));
        /*Inicializa la clase Actions para realizar interacciones avanzadas con el ratón*/
        Actions accion = new Actions(firefoxDriver);
        /*Mueve el ratón hacia el elemento 'imagenDeCompra'*/
        accion.moveToElement(imagenDeCompra).perform();
        /*Espera hasta que el submenú 'Summer Dresses' sea visible*/
        WebElement summerDresses = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(XPATH_SUMMER_DRESSES)));
        /*Comprueba si el submenú 'Summer Dresses' es visible y hace clic si es así*/
        if (summerDresses.isDisplayed()) {
            System.out.println("La opción 'Summer Dresses' es visible.");
            /* Si es visible, puedes hacer clic en él si lo deseas*/
            summerDresses.click();
        } else {
            System.out.println("La opción 'Summer Dresses' NO es visible.");
        }
        /*Configura otro tiempo de espera implícito para garantizar la carga de la página*/
        /*firefoxDriver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT_TIME, TIME_UNIT);*/
        /*Encuentra la imagen del vestido de verano y hace clic en ella*/
        WebElement vestidoDeVerano = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(XPATH_VESTIDO_DE_VERANO)));
        vestidoDeVerano.click();
        /*Encuentra el desplegable para seleccionar la talla*/
        WebElement selectElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.id(ID_SELECT_ELEMENT)));
        /*Inicializa el objeto Select para interactuar con el desplegable de la talla*/
        Select tallaSelect = new Select(selectElement);
        /*Selecciona la talla "M" en el desplegable*/
        tallaSelect.selectByVisibleText(TALLA_M);
        /*Ejecuta un script de JavaScript para forzar el cambio en el desplegable*/
        JavascriptExecutor js = (JavascriptExecutor) firefoxDriver;
        js.executeScript(JS_FORCE_CHANGE_EVENT, selectElement);
        /*Encuentra el botón 'Add to Cart' y lo habilita usando JavaScript*/
        WebElement addToCartButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(XPATH_ADD_TO_CART_BUTTON)));
        js.executeScript(JS_SHOW_BUTTON, addToCartButton);
       /*Falta agregar comentario: Espera hasta que el botón 'Add to Cart' esté clicable*/      /*Falta agregar comentario*/
        wait.until(ExpectedConditions.elementToBeClickable(addToCartButton));

        /* Verifica si el botón es visible*/
        if (addToCartButton.isDisplayed()) {
            /* Haz clic en el botón */
           addToCartButton.click();
            System.out.println("El botón es visible.");
       } else {
            System.out.println("El botón no es visible.");
        }
        /*Espera hasta que aparezca el ícono de check de confirmación de compra*/
        WebElement checkCheckout = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(XPATH_ICON_CHECK)));
        /*Mueve el ratón hacia el ícono de check**/
        accion.moveToElement(checkCheckout).perform();
        /*Espera hasta que la opción 'Proceed to checkout' sea visible*/
        WebElement buttonCheckout = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(XPATH_BUTTON_CHECKOUT)));
        /*Comprueba si la opción 'Proceed to checkout' es visible y hace clic si es así*/
        if (buttonCheckout.isDisplayed()) {
            System.out.println("La opción 'Checkout' es visible.");
            buttonCheckout.click();
        } else {
            System.out.println("La opción 'Checkout' NO es visible.");
        }
        /*Encuentra y hace clic en los botones de 'Checkout' en los siguientes pasos del proceso*/
        WebElement buttonCheckout1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(XPATH_BUTTON_CHECKOUT1)));
        buttonCheckout1.click();
        WebElement buttonCheckout2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(XPATH_BUTTON_CHECKOUT2)));
        buttonCheckout2.click();
        WebElement buttonCheckout3 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(XPATH_BUTTON_CHECKOUT3)));
        buttonCheckout3.click();
        WebElement buttonCheckout4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(XPATH_BUTTON_CHECKOUT4)));
        buttonCheckout4.click();
        WebElement buttonCheckout5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(XPATH_BUTTON_CHECKOUT5)));
        buttonCheckout5.click();
        WebElement buttonCheckout6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(XPATH_BUTTON_CHECKOUT6)));
        buttonCheckout6.click();
        /*Verifica si el banner de confirmación de la orden es visible y contiene el texto correcto*/
        WebElement bannerOrdenCompleta = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(XPATH_BANNER_ORDEN_COMPLETA)));
        /*Verifica si el banner de confirmación está visible*/
        if (bannerOrdenCompleta.isDisplayed()) {
            /*Obtén el texto del banner de confirmación*/
            String bannerText = bannerOrdenCompleta.getText(); // Obtén el texto del banner
            /*Verifica si el texto del banner contiene el mensaje esperado.*/
            if (bannerText.contains("Your order on My Shop is complete.")) {
                /*Imprime un mensaje si el texto esperado se muestra correctamente*/
                System.out.println("El mensaje 'Your order on My Shop is complete.' se muestra correctamente.");
                /*Asegura que el texto del banner contenga el mensaje esperado*/
                Assert.assertTrue("El mensaje esperado no se encontró en el banner.", bannerText.contains("Your order on My Shop is complete."));
                /**/
            } else {
                /*Imprime un mensaje si el banner está visible, pero el texto esperado no coincide*/
                System.out.println("El banner está visible, pero el texto esperado no está presente.");
                /*Falla la prueba si el texto esperado no se encuentra en el banner*/
                Assert.fail("El texto esperado 'Your order on My Shop is complete.' no está en el banner.");
            }
            /*Falta agregar comentario*/
        } else {
            /*Imprime un mensaje si el banner no está visible*/
            System.out.println("El banner de confirmación no está visible.");
            /*Falla la prueba si el banner de confirmación no se muestra */
            Assert.fail("El banner de confirmación no se mostró.");
        }


    }

    /*Cierra el navegador y finaliza la sesión de WebDriver después de que la prueba haya terminado */
    @After
    public void cerrarDriver(){
        firefoxDriver.quit();
    }
}


