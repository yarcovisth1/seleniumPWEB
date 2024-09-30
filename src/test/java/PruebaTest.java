import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

import java.util.concurrent.TimeUnit;


public class PruebaTest {
    /*Declaración del WebDriver para Firefox*/
    private WebDriver firefoxDriver;
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
        firefoxDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    /* Método que contiene el test para realizar una compra en la tienda*/
    @Test
    public void hacerUnaConsulta() {

        /*Se utiliza para navegar a una URL específica */
        firefoxDriver.get("http://www.automationpractice.pl/");
        /*Establece un tiempo de espera implícito antes de interactuar con elementos*/
        firefoxDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        /*Encuentra el botón de inicio de sesión en la página principal*/
        WebElement botonInicioSesion1 = firefoxDriver.findElement(By.xpath("//a[@class='login']"));
        /*Hace clic en el botón de inicio de sesión*/
        botonInicioSesion1.click();
        /*Encuentra el campo de email e ingresa el correo electrónico*/
        WebElement InputEmail = firefoxDriver.findElement(By.cssSelector("#email"));
                InputEmail.sendKeys("yarcovisth2@gmail.com");
        WebElement InputPassword = firefoxDriver.findElement(By.cssSelector("#passwd"));
                InputPassword.sendKeys("Luzelena1*");
        WebElement botonInicioSesion2 = firefoxDriver.findElement(By.xpath("//button[@id='SubmitLogin']"));
        /*Hace clic en el botón de inicio de sesión después de ingresar las credenciales*/
        botonInicioSesion2.click();

        /*Crea un WebDriverWait para esperar a que ciertos elementos estén visibles o sean clicables*/
        WebDriverWait wait = new WebDriverWait(firefoxDriver, Duration.ofSeconds(10));
        /*Espera hasta que el elemento 'Dresses' sea visible*/
        WebElement imagenDeCompra = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[@title='Dresses'])[2]")));
        /*Inicializa la clase Actions para realizar interacciones avanzadas con el ratón*/
        Actions accion = new Actions(firefoxDriver);
        /*Mueve el ratón hacia el elemento 'imagenDeCompra'*/
        accion.moveToElement(imagenDeCompra).perform();
        /*Espera hasta que el submenú 'Summer Dresses' sea visible*/
        WebElement summerDresses = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[@title='Summer Dresses'])[2]")));
        /*Comprueba si el submenú 'Summer Dresses' es visible y hace clic si es así*/
        if (summerDresses.isDisplayed()) {
            System.out.println("La opción 'Summer Dresses' es visible.");
            /* Si es visible, puedes hacer clic en él si lo deseas*/
            summerDresses.click();
        } else {
            System.out.println("La opción 'Summer Dresses' NO es visible.");
        }
        /*Configura otro tiempo de espera implícito para garantizar la carga de la página*/
        firefoxDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        /*Encuentra la imagen del vestido de verano y hace clic en ella*/
        WebElement VestidoDeVerano = firefoxDriver.findElement(By.xpath("//img[@src='http://www.automationpractice.pl/img/p/1/6/16-home_default.jpg']"));
        VestidoDeVerano.click();
        /*Encuentra el desplegable para seleccionar la talla*/
        WebElement selectElement = firefoxDriver.findElement(By.id("group_1"));
        /*Inicializa el objeto Select para interactuar con el desplegable de la talla*/
        Select tallaSelect = new Select(selectElement);
        /*Selecciona la talla "M" en el desplegable*/
        tallaSelect.selectByVisibleText("M");
        /*Ejecuta un script de JavaScript para forzar el cambio en el desplegable*/
        JavascriptExecutor js = (JavascriptExecutor) firefoxDriver;
        js.executeScript("arguments[0].dispatchEvent(new Event('change'));", selectElement);
        /*Encuentra el botón 'Add to Cart' y lo habilita usando JavaScript*/
        WebElement addToCartButton = firefoxDriver.findElement(By.xpath("//button[@name='Submit' and @class='exclusive']"));
        js.executeScript("arguments[0].style.display='block'; arguments[0].disabled=false;", addToCartButton);
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
        WebElement checkCheckout = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//i[@class='icon-check']")));
        /*Mueve el ratón hacia el ícono de check**/
        Actions accion1 = new Actions(firefoxDriver);
        accion1.moveToElement(checkCheckout).perform();
        /*Espera hasta que la opción 'Proceed to checkout' sea visible*/
        WebElement ButtonCheckout = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Proceed to checkout')]")));
        /*Comprueba si la opción 'Proceed to checkout' es visible y hace clic si es así*/
        if (ButtonCheckout.isDisplayed()) {
            System.out.println("La opción 'Checkout' es visible.");
            ButtonCheckout.click();
        } else {
            System.out.println("La opción 'Checkout' NO es visible.");
        }
        /*Encuentra y hace clic en los botones de 'Checkout' en los siguientes pasos del proceso*/
        WebElement ButtonCheckout1 = firefoxDriver.findElement(By.xpath("//a[@class='button btn btn-default standard-checkout button-medium']"));
        ButtonCheckout1.click();
        WebElement ButtonCheckout2 = firefoxDriver.findElement(By.xpath("//button[@type='submit']//span[contains(text(),'Proceed to checkout')]"));
        ButtonCheckout2.click();
        WebElement ButtonCheckout3 = firefoxDriver.findElement(By.xpath("//input[@id='cgv']"));
        ButtonCheckout3.click();
        WebElement ButtonCheckout4 = firefoxDriver.findElement(By.xpath("//button[@type='submit']//span[contains(text(),'Proceed to checkout')]"));
        ButtonCheckout4.click();
        WebElement ButtonCheckout5 = firefoxDriver.findElement(By.xpath("//a[@title='Pay by check.']"));
        ButtonCheckout5.click();
        WebElement ButtonCheckout6 = firefoxDriver.findElement(By.xpath("//span[contains(text(),'I confirm my order')]"));
        ButtonCheckout6.click();
        /*Verifica si el banner de confirmación de la orden es visible y contiene el texto correcto*/
        WebElement bannerOrdenCompleta = firefoxDriver.findElement(By.xpath("//p[@class='alert alert-success']"));
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


