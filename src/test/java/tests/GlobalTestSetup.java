package tests;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.*;
import java.time.Duration;

/**
 * <p>Esta clase configura el entorno de pruebas para Selenium.</p>
 *
 * <h2>Descripción</h2>
 * <p>Inicializa el <b>WebDriver</b> y las páginas de la aplicación necesarias
 * para ejecutar las pruebas. Contiene métodos que se ejecutan antes y después
 * de cada prueba.</p>
 *
 * <h2>Métodos</h2>
 * <ul>
 *   <li><b>abrirDriver</b>: Configura y abre el navegador antes de cada prueba.</li>
 *   <li><b>cerrarDriver</b>: Cierra el navegador después de cada prueba.</li>
 * </ul>
 *
 * @author Trinitron
 */

/**
 * Configura el entorno de pruebas para Selenium.
 *
 * <p>Esta clase se encarga de la inicialización del navegador, las páginas necesarias para las pruebas,
 * y la gestión del ciclo de vida del WebDriver antes y después de cada prueba.</p>
 *
 * <h2>Métodos principales:</h2>
 * <ul>
 *   <li><b>abrirDriver:</b> Configura y abre el navegador antes de cada prueba.</li>
 *   <li><b>cerrarDriver:</b> Cierra el navegador al finalizar cada prueba.</li>
 * </ul>
 *
 * <h2>Atributos:</h2>
 * <ul>
 *   <li><b>firefoxDriver:</b> Instancia del WebDriver para controlar Firefox.</li>
 *   <li><b>wait:</b> Objeto de espera explícita para sincronización en las pruebas.</li>
 *   <li><b>paginaPrincipal:</b> Página de inicio de la tienda online.</li>
 *   <li><b>paginaLogin:</b> Página para realizar el inicio de sesión.</li>
 *   <li><b>paginaSummerDresses:</b> Página de vestidos de verano.</li>
 *   <li><b>paginaPrintedSummerDress:</b> Página de un vestido específico.</li>
 *   <li><b>paginaPopUpProductAddedShopping:</b> Pop-up de confirmación de producto añadido al carrito.</li>
 *   <li><b>paginaShoppingCartSummary:</b> Página de resumen del carrito de compras.</li>
 * </ul>
 *
 * @author Trinintron
 * @see org.openqa.selenium.WebDriver
 * @see pageObjects.PaginaPrincipal
 * @see pageObjects.PaginaLogin
 * @see pageObjects.PaginaSummerDresses
 */
public class GlobalTestSetup {
    protected Actions accion;
    /** Objeto para gestionar las esperas explícitas. */
    protected WebDriverWait wait;
    /** Instancia del WebDriver para el navegador Firefox. */
    protected WebDriver firefoxDriver;
    /** Tiempo máximo de espera en segundos para las condiciones explícitas. */
    protected static final int TIMEOUT_IN_SECONDS = 10;
    /**
     * URL de la tienda en línea donde se realizarán las pruebas.
     *
     * @value "http://www.automationpractice.pl/"
     */
    public static final String URL_TIENDA = "http://www.automationpractice.pl/";
    // Instancias de las diferentes páginas del flujo de la aplicación.
    PaginaPrincipal paginaPrincipal;
    PaginaLogin paginaLogin;
    PaginaSummerDresses paginaSummerDresses;
    PaginaPrintedSummerDress paginaPrintedSummerDress;
    PaginaPopUpProductAddedShopping paginaPopUpProductAddedShopping;
    PaginaShoppingCartSummary paginaShoppingCartSummary;
    /**
     * Inicializa las páginas utilizadas en las pruebas.
     *
     * @param driver El WebDriver usado para controlar el navegador.
     */
    private void inicializarPaginas(WebDriver driver){
    paginaPrincipal = new PaginaPrincipal(driver);
    paginaLogin = new PaginaLogin(driver);
    paginaSummerDresses = new PaginaSummerDresses(driver);
    paginaPrintedSummerDress = new PaginaPrintedSummerDress(driver);
    paginaPopUpProductAddedShopping = new PaginaPopUpProductAddedShopping(driver);
    paginaShoppingCartSummary = new PaginaShoppingCartSummary(driver);
    }
    /**
     * Configura y abre el navegador Firefox antes de cada prueba.
     */
    @Before
    public void abrirDriver(){
        System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
        FirefoxOptions options = new FirefoxOptions();
        firefoxDriver = new FirefoxDriver(options);
        /*Establecer el tiempo de espera y abrir la URL de la tienda */
        wait =  new WebDriverWait(firefoxDriver, Duration.ofSeconds(TIMEOUT_IN_SECONDS));
        firefoxDriver.get(URL_TIENDA);
        /*Configura el tamaño de la ventana del navegador */
        Dimension newSize = new Dimension(1200, 3000);
        firefoxDriver.manage().window().setSize(newSize);
        inicializarPaginas(firefoxDriver);
        accion = new Actions(firefoxDriver);
    }
    /**
     * Cierra el navegador después de cada prueba.
     */
  @After
  public void cerrarDriver(){
        firefoxDriver.quit();
  }
}

