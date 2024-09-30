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
    /*Falta agregar comentario*/
    private WebDriver firefoxDriver;
    /*Falta agregar comentario*/
    @Before
    public void abrirDriver(){
        /*Encontrar la Ruta del geckodriver*/
        System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver");
        /*Configurar opciones para el navegador Firefox.*/
        FirefoxOptions options = new FirefoxOptions();
        /*Falta agregar comentario*/
        firefoxDriver = new FirefoxDriver(options);
        /*Falta agregar comentario*/
        firefoxDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    /*Falta agregar comentario*/
    @Test
    public void hacerUnaConsulta() {

        /*Se utiliza para navegar a una URL específica */
        firefoxDriver.get("http://www.automationpractice.pl/");
        /*Falta agregar comentario*/
        firefoxDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        /*Falta agregar comentario*/
        WebElement botonInicioSesion1 = firefoxDriver.findElement(By.xpath("//a[@class='login']"));
        /*Falta agregar comentario*/
        botonInicioSesion1.click();
        /*Falta agregar comentario*/
        WebElement InputEmail = firefoxDriver.findElement(By.cssSelector("#email"));
                InputEmail.sendKeys("yarcovisth2@gmail.com");
        WebElement InputPassword = firefoxDriver.findElement(By.cssSelector("#passwd"));
                InputPassword.sendKeys("Luzelena1*");
        WebElement botonInicioSesion2 = firefoxDriver.findElement(By.xpath("//button[@id='SubmitLogin']"));
        /*Falta agregar comentario*/
        botonInicioSesion2.click();


        /*Falta agregar comentario*/
        WebDriverWait wait = new WebDriverWait(firefoxDriver, Duration.ofSeconds(10));
        /*Falta agregar comentario*/
        WebElement imagenDeCompra = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[@title='Dresses'])[2]")));
        /*Falta agregar comentario*/
        Actions accion = new Actions(firefoxDriver);
        /*Falta agregar comentario*/
        accion.moveToElement(imagenDeCompra).perform();
        /*Falta agregar comentario*/
        WebElement summerDresses = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[@title='Summer Dresses'])[2]")));
        /*Falta agregar comentario*/
        if (summerDresses.isDisplayed()) {
            System.out.println("La opción 'Summer Dresses' es visible.");
            // Si es visible, puedes hacer clic en él si lo deseas
            summerDresses.click();
        } else {
            System.out.println("La opción 'Summer Dresses' NO es visible.");
        }
        /*Falta agregar comentario*/
        firefoxDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        /*Falta agregar comentario*/
        WebElement VestidoDeVerano = firefoxDriver.findElement(By.xpath("//img[@src='http://www.automationpractice.pl/img/p/1/6/16-home_default.jpg']"));
        /*Falta agregar comentario*/
        VestidoDeVerano.click();
        /*Falta agregar comentario*/
        WebElement selectElement = firefoxDriver.findElement(By.id("group_1"));
        /*Falta agregar comentario*/
        Select tallaSelect = new Select(selectElement);
        /*Falta agregar comentario*/
        tallaSelect.selectByVisibleText("M");
        /*Falta agregar comentario*/
        JavascriptExecutor js = (JavascriptExecutor) firefoxDriver;
        /*Falta agregar comentario*/
        js.executeScript("arguments[0].dispatchEvent(new Event('change'));", selectElement);
        /*Falta agregar comentario*/
        WebElement addToCartButton = firefoxDriver.findElement(By.xpath("//button[@name='Submit' and @class='exclusive']"));
        /*Falta agregar comentario*/
        js.executeScript("arguments[0].style.display='block'; arguments[0].disabled=false;", addToCartButton);
        /*Falta agregar comentario*/
        WebDriverWait wait1 = new WebDriverWait(firefoxDriver, Duration.ofSeconds(10));
        /*Falta agregar comentario*/
        wait1.until(ExpectedConditions.elementToBeClickable(addToCartButton));

               // Verifica si el botón es visible
        if (addToCartButton.isDisplayed()) {
            // Haz clic en el botón
           addToCartButton.click();
            System.out.println("El botón es visible.");
       } else {
            System.out.println("El botón no es visible.");
        }
        /*Falta agregar comentario*/
        WebDriverWait wait2 = new WebDriverWait(firefoxDriver, Duration.ofSeconds(10));
        /*Falta agregar comentario*/
        WebElement checkCheckout = wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//i[@class='icon-check']")));
        /*Falta agregar comentario*/
        Actions accion1 = new Actions(firefoxDriver);
        /*Falta agregar comentario*/
        accion1.moveToElement(checkCheckout).perform();
        /*Falta agregar comentario*/
        WebElement ButtonCheckout = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Proceed to checkout')]")));
        /*Falta agregar comentario*/
        if (ButtonCheckout.isDisplayed()) {
            System.out.println("La opción 'Checkout' es visible.");
            // Si es visible, puedes hacer clic en él si lo deseas
            ButtonCheckout.click();
        } else {
            System.out.println("La opción 'Checkout' NO es visible.");
        }
        /*Falta agregar comentario*/
        WebElement ButtonCheckout1 = firefoxDriver.findElement(By.xpath("//a[@class='button btn btn-default standard-checkout button-medium']"));
        /*Falta agregar comentario*/
        ButtonCheckout1.click();
        /*Falta agregar comentario*/
        WebElement ButtonCheckout2 = firefoxDriver.findElement(By.xpath("//button[@type='submit']//span[contains(text(),'Proceed to checkout')]"));
        /*Falta agregar comentario*/
        ButtonCheckout2.click();
        /*Falta agregar comentario*/
        WebElement ButtonCheckout3 = firefoxDriver.findElement(By.xpath("//input[@id='cgv']"));
        /*Falta agregar comentario*/
        ButtonCheckout3.click();
        /*Falta agregar comentario*/
        WebElement ButtonCheckout4 = firefoxDriver.findElement(By.xpath("//button[@type='submit']//span[contains(text(),'Proceed to checkout')]"));
        /*Falta agregar comentario*/
        ButtonCheckout4.click();
        /*Falta agregar comentario*/
        WebElement ButtonCheckout5 = firefoxDriver.findElement(By.xpath("//a[@title='Pay by check.']"));
        /*Falta agregar comentario*/
        ButtonCheckout5.click();
        /*Falta agregar comentario*/
        WebElement ButtonCheckout6 = firefoxDriver.findElement(By.xpath("//span[contains(text(),'I confirm my order')]"));
        /*Falta agregar comentario*/
        ButtonCheckout6.click();
        /*Falta agregar comentario*/
        WebElement bannerOrdenCompleta = firefoxDriver.findElement(By.xpath("//p[@class='alert alert-success']"));

        /*Falta agregar comentario*/
        if (bannerOrdenCompleta.isDisplayed()) {
            String bannerText = bannerOrdenCompleta.getText(); // Obtén el texto del banner

            if (bannerText.contains("Your order on My Shop is complete.")) {
                System.out.println("El mensaje 'Your order on My Shop is complete.' se muestra correctamente.");
                Assert.assertTrue("El mensaje esperado no se encontró en el banner.", bannerText.contains("Your order on My Shop is complete."));
            } else {
                System.out.println("El banner está visible, pero el texto esperado no está presente.");
                Assert.fail("El texto esperado 'Your order on My Shop is complete.' no está en el banner.");
            }
        } else {
            System.out.println("El banner de confirmación no está visible.");
            Assert.fail("El banner de confirmación no se mostró.");
        }


    }

    /*Falta agregar comentario*/
    @After
    public void cerrarDriver(){
        firefoxDriver.quit();
    }
}


