package pageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.Arrays;
import java.util.List;
/**
 * Clase que representa la página de resumen del carrito de compras.
 * <p>Esta clase contiene los elementos y pasos necesarios para completar el proceso de checkout,
 * desde la verificación del carrito hasta la confirmación de la orden.</p>
 *
 * <h2>Elementos gestionados:</h2>
 * <ul>
 *     <li>Botones para avanzar en el flujo de checkout (botones 1 a 6).</li>
 *     <li>Elemento para aceptar términos y condiciones.</li>
 *     <li>Banner que confirma la finalización del pedido.</li>
 * </ul>
 *
 * <h2>Métodos:</h2>
 * <ul>
 *     <li>{@link #shoppingSummary()}: Devuelve una lista de elementos Web relevantes en el flujo de checkout.</li>
 *     <li>{@link #PaginaShoppingCartSummary(WebDriver)}: Inicializa los elementos de la página.</li>
 * </ul>
 *
 * <h2>Atributos:</h2>
 * <ul>
 *     <li>XPath para cada botón de checkout, identificados del 1 al 6.</li>
 *     <li>XPath del banner de orden completada.</li>
 * </ul>
 *
 * @author trinitron
 * @since 1.0
 */
public class PaginaShoppingCartSummary {
    /** XPath del primer botón de checkout. */
    private static final String XPATH_BUTTON_CHECKOUT1 = "//a[@class='button btn btn-default standard-checkout button-medium']";
    /** XPath del segundo botón de checkout. */
    private static final String XPATH_BUTTON_CHECKOUT2 = "//button[@type='submit']//span[contains(text(),'Proceed to checkout')]";
    /** XPath del checkbox para aceptar términos y condiciones. */
    private static final String XPATH_BUTTON_CHECKOUT3 = "//input[@id='cgv']";
    /** XPath del tercer botón de checkout. */
    private static final String XPATH_BUTTON_CHECKOUT4 = "//button[@type='submit']//span[contains(text(),'Proceed to checkout')]";
    /** XPath del botón para seleccionar pago por cheque. */
    private static final String XPATH_BUTTON_CHECKOUT5 = "//a[@title='Pay by check.']";
    /** XPath del botón para confirmar la orden. */
    private static final String XPATH_BUTTON_CHECKOUT6 = "//span[contains(text(),'I confirm my order')]";
    /** XPath del banner que confirma la orden completa. */
    private static final String XPATH_BANNER_ORDEN_COMPLETA = "//p[@class='alert alert-success']";

    @FindBy(xpath = "//a[@class='button btn btn-default standard-checkout button-medium']//span[contains(text(),'Proceed to checkout')]//i[@class='icon-chevron-right right']")
    private WebElement ShoppingCartSummaryButton1;
    @FindBy(xpath = "//button[@type='submit']//span[contains(text(),'Proceed to checkout')]")
    private WebElement ShoppingCartSummaryButton2;
   @FindBy(xpath = "//input[@id='cgv']")
   private WebElement ShoppingCartSummaryButton3;
   @FindBy(xpath = "//button[@type='submit']//span[contains(text(),'Proceed to checkout')]")
   private WebElement ShoppingCartSummaryButton4;
   @FindBy(xpath = "//a[@title='Pay by check.']")
   private WebElement ShoppingCartSummaryButton5;
   @FindBy(xpath = "//span[contains(text(),'I confirm my order')]")
   private WebElement ShoppingCartSummaryButton6;
   @FindBy(xpath = "//p[@class='alert alert-success']")
   private WebElement ShoppingCartSummaryButton7;
    /**
     * Devuelve una lista con todos los elementos Web relevantes en el flujo de checkout.
     *
     * @return Lista de {@link WebElement} que incluye botones y el banner de confirmación.
     */
    public List<WebElement> shoppingSummary(){
        return Arrays.asList(ShoppingCartSummaryButton1,ShoppingCartSummaryButton2,ShoppingCartSummaryButton3,
                ShoppingCartSummaryButton4,ShoppingCartSummaryButton5,ShoppingCartSummaryButton6,ShoppingCartSummaryButton7);
    }
    /**
     * Inicializa los elementos Web de la página utilizando el WebDriver proporcionado.
     *
     * @param driver El WebDriver utilizado para controlar el navegador.
     */
    public PaginaShoppingCartSummary(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }
}
