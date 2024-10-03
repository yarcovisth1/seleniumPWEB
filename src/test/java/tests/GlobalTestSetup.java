package tests;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class GlobalTestSetup {

    /*Declaración del WebDriver para Firefox  (Pagina uno)*/
    protected WebDriverWait wait;
    protected WebDriver firefoxDriver;
    protected static final int TIMEOUT_IN_SECONDS = 10;

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
        wait =  new WebDriverWait(firefoxDriver, Duration.ofSeconds(TIMEOUT_IN_SECONDS));
    }

    /*Cierra el navegador y finaliza la sesión de WebDriver después de que la prueba haya terminado */
    @After
    public void cerrarDriver(){
        firefoxDriver.quit();
    }
}

