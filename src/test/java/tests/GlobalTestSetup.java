package tests;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.*;
import java.time.Duration;

/**
 * The type Global test setup.
 */
public class GlobalTestSetup {

    /**
     * The Wait.
     */
    /*Declaración del WebDriver para Firefox  (Pagina uno)*/
    protected WebDriverWait wait;
    /**
     * The Firefox driver.
     */
    protected WebDriver firefoxDriver;
    /**
     * The constant TIMEOUT_IN_SECONDS.
     */
    protected static final int TIMEOUT_IN_SECONDS = 10;
    /**
     * The Pagina principal.
     */
    PaginaPrincipal paginaPrincipal;
    /**
     * The Pagina login.
     */
    PaginaLogin paginaLogin;
    /**
     * The Pagina summer dresses.
     */
    PaginaSummerDresses paginaSummerDresses;
    /**
     * The Pagina printed summer dress.
     */
    PaginaPrintedSummerDress paginaPrintedSummerDress;
    /**
     * The Pagina pop up product added shopping.
     */
    PaginaPopUpProductAddedShopping paginaPopUpProductAddedShopping;
    /**
     * The Pagina shopping cart summary.
     */
    PaginaShoppingCartSummary paginaShoppingCartSummary;

    private void inicializarPaginas(WebDriver driver){
    paginaPrincipal = new PaginaPrincipal(driver);
    paginaLogin = new PaginaLogin(driver);
    paginaSummerDresses = new PaginaSummerDresses(driver);
    paginaPrintedSummerDress = new PaginaPrintedSummerDress(driver);
    paginaPopUpProductAddedShopping = new PaginaPopUpProductAddedShopping(driver);
    paginaShoppingCartSummary = new PaginaShoppingCartSummary(driver);
    }

    /**
     * Abrir driver.
     */
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
        inicializarPaginas(firefoxDriver);
    }

    /**
     * Cerrar driver.
     */
    /*Cierra el navegador y finaliza la sesión de WebDriver después de que la prueba haya terminado */
  @After
  public void cerrarDriver(){
        firefoxDriver.quit();
  }
}

