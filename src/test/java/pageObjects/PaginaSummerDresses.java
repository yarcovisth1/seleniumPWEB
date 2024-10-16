package pageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.Arrays;
import java.util.List;
/**
 * Clase que representa la página de vestidos de verano en la tienda online.
 * <p>Esta clase gestiona los elementos necesarios para navegar hacia la sección
 * de vestidos de verano y seleccionar un producto de esta categoría.</p>
 *
 * <h2>Elementos gestionados:</h2>
 * <ul>
 *     <li>Enlace a la sección de "Dresses" (Vestidos).</li>
 *     <li>Enlace a la subsección "Summer Dresses" (Vestidos de Verano).</li>
 *     <li>Imagen representativa del producto en la categoría de vestidos de verano.</li>
 * </ul>
 *
 * <h2>Métodos:</h2>
 * <ul>
 *     <li>{@link #seleccionarSummerDresses()}: Devuelve una lista con los elementos web relevantes para seleccionar vestidos de verano.</li>
 *     <li>{@link #PaginaSummerDresses(WebDriver)}: Inicializa los elementos de la página usando el WebDriver.</li>
 * </ul>
 *
 * @author trinitron
 * @since 1.0
 */
public class PaginaSummerDresses {
    /** XPath del enlace hacia la sección de "Dresses". */
    private static final String XPATH_ATRIBUTO_DRESSES = "(//a[@title='Dresses'])[2]";
    /** XPath del enlace hacia la sección de "Summer Dresses". */
    private static final String XPATH_ATRIBUTO_SUMMER_DRESSES = "(//a[@title='Summer Dresses'])[2]";
    /** XPath del enlace hacia la sección de "Summer Dresses". */
    private static final String XPATH_ATRIBUTO_IMAGEN_SUMMER_DRESSES = "//img[@src='http://www.automationpractice.pl/img/p/1/6/16-home_default.jpg']";

    @FindBy(xpath = "(//a[@title='Dresses'])[2]" )
    private WebElement atributoDresses;
    @FindBy(xpath = "(//a[@title='Summer Dresses'])[2]")
    private WebElement atributoSummerDresses;
    @FindBy(xpath = "//img[@src='http://www.automationpractice.pl/img/p/1/6/16-home_default.jpg']")
    private WebElement atributoImageSummerDresses;

    /**
     * Devuelve una lista con los elementos relevantes para seleccionar la sección de "Summer Dresses".
     * <p>Incluye el enlace a la sección principal de "Dresses", el enlace a "Summer Dresses", y la imagen representativa.</p>
     *
     * @return Lista de {@link WebElement} que permite navegar a la sección de vestidos de verano.
     */
    public List<WebElement> seleccionarSummerDresses(){
        return Arrays.asList(atributoDresses, atributoSummerDresses, atributoImageSummerDresses);
    }

    /**
     * Inicializa los elementos de la página utilizando el WebDriver proporcionado.
     *
     * @param driver El WebDriver utilizado para controlar el navegador.
     */
    public PaginaSummerDresses(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
