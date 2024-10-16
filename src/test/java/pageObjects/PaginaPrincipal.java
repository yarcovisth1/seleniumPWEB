package pageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * Clase que representa la página principal de la aplicación.
 * <p>Modela el acceso al inicio de sesión mediante el botón de login disponible en la página principal.</p>
 *
 * <h2>Elementos gestionados:</h2>
 * <ul>
 *     <li>Botón de "Sign In" identificado por la clase <code>login</code>.</li>
 * </ul>
 *
 * <h2>Métodos:</h2>
 * <ul>
 *     <li>{@link #irASignIn()}: Retorna el elemento web del botón de inicio de sesión.</li>
 *     <li>{@link #PaginaPrincipal(WebDriver)}: Inicializa los elementos de la página.</li>
 * </ul>
 *
 * @author trinitron
 * @since 1.0
 */
public class PaginaPrincipal {
    /** Nombre de la clase CSS para el botón de login en la página principal. */
    public static final String CLASSNAME_BOTON_PAGINA_PRINCIPAL = "login";

    @FindBy(className = "login")
    private WebElement botonPaginaPrincipal;
    /**
     * Retorna el elemento web que permite navegar al formulario de inicio de sesión.
     * <p>Este botón lleva al usuario a la pantalla de login.</p>
     *
     * @return El {@link WebElement} del botón de "Sign In".
     */
    public WebElement irASignIn(){
        return botonPaginaPrincipal;
    }
    /**
     * Inicializa los elementos web de la página principal con el WebDriver proporcionado.
     *
     * @param driver El WebDriver utilizado para controlar el navegador.
     */
    public PaginaPrincipal(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
