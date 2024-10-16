package pageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.Arrays;
import java.util.List;
/**
 * Clase que modela el pop-up que aparece al agregar un producto al carrito.
 * <p>Utiliza el patrón Page Object Model (POM) para encapsular los elementos
 * del pop-up y sus acciones correspondientes.</p>
 *
 * <h2>Elementos gestionados:</h2>
 * <ul>
 *     <li>Icono de verificación (<i class="icon-check"></i>).</li>
 *     <li>Botón de "Proceed to checkout".</li>
 * </ul>
 *
 * <h2>Métodos:</h2>
 * <ul>
 *     <li>{@link #moveToCheck()}: Retorna una lista con los elementos relevantes del pop-up.</li>
 *     <li>{@link #PaginaPopUpProductAddedShopping(WebDriver)}: Inicializa los elementos del pop-up con el WebDriver.</li>
 * </ul>
 *
 * @author trinitron
 * @since 1.0
 */
public class PaginaPopUpProductAddedShopping {
    private static final String XPATH_ICON_CHECK = "//i[@class='icon-check']";
    private static final String XPATH_BUTTON_CHECKOUT = "//span[contains(text(),'Proceed to checkout')]";

    @FindBy(xpath = "//i[@class='icon-check']" )
    private WebElement moveToCheck;
    @FindBy(xpath = "//span[contains(text(),'Proceed to checkout')]")
    private WebElement ProceedToCheckoutButton;
    /**
     * Retorna una lista con los elementos principales del pop-up.
     * <p>Esta lista incluye el icono de verificación y el botón de "Proceed to checkout".</p>
     *
     * @return Una lista de {@link WebElement} con los elementos relevantes del pop-up.
     */
    public List<WebElement> moveToCheck(){
        return Arrays.asList(moveToCheck,ProceedToCheckoutButton);
    }
    /**
     * Inicializa los elementos del pop-up con el WebDriver proporcionado.
     *
     * @param driver El WebDriver usado para controlar el navegador.
     */
    public PaginaPopUpProductAddedShopping(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
