package pageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.Arrays;
import java.util.List;
/**
 * Clase que modela la página de un producto tipo "Printed Summer Dress".
 * <p>Contiene elementos relacionados con la selección de talla y el botón para agregar al carrito.</p>
 *
 * <h2>Elementos gestionados:</h2>
 * <ul>
 *     <li>Dropdown de selección de talla identificado por <code>group_1</code>.</li>
 *     <li>Botón "Agregar al carrito" identificado por <code>Submit</code> y clase <code>exclusive</code>.</li>
 * </ul>
 *
 * <h2>Métodos:</h2>
 * <ul>
 *     <li>{@link #selectSizeAddToCart()}: Retorna una lista de elementos web relevantes para seleccionar talla y agregar al carrito.</li>
 *     <li>{@link #PaginaPrintedSummerDress(WebDriver)}: Inicializa los elementos de la página.</li>
 * </ul>
 *
 * <h2>Atributos:</h2>
 * <ul>
 *     <li>Constante {@link #ID_SELECT_ELEMENT}: XPath del dropdown de selección de talla.</li>
 *     <li>Constante {@link #XPATH_ADD_TO_CART_BUTTON}: XPath del botón para agregar al carrito.</li>
 *     <li>Arreglo de tallas disponibles: {"S", "M", "L"}.</li>
 * </ul>
 *
 * @author trinitron
 * @since 1.0
 */
public class PaginaPrintedSummerDress {
    /** XPath del dropdown de selección de talla. */
    private static final String ID_SELECT_ELEMENT = "//select[@id='group_1']";
    /** XPath del botón para agregar al carrito. */
    private static final String XPATH_ADD_TO_CART_BUTTON = "//button[@name='Submit' and @class='exclusive']";
    /** Arreglo de tallas disponibles para el producto. */
    String[] tallas = {"S", "M", "L"};

    @FindBy(xpath = "//select[@id='group_1']" )
    private WebElement selectElementSize;
    @FindBy(xpath = "//button[@name='Submit' and @class='exclusive']")
    private WebElement addToCartButton;

    /**
     * Retorna una lista con los elementos necesarios para seleccionar una talla y agregar el producto al carrito.
     *
     * @return Una lista de {@link WebElement} que contiene el dropdown de selección de talla y el botón de "Agregar al carrito".
     */
    public List<WebElement> selectSizeAddToCart(){
        return Arrays.asList(selectElementSize,addToCartButton);
    }

    /**
     * Inicializa los elementos web de la página con el WebDriver proporcionado.
     *
     * @param driver El WebDriver utilizado para controlar el navegador.
     */
    public PaginaPrintedSummerDress(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
