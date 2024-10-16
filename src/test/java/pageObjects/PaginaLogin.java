package pageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Clase que modela la página de inicio de sesión del sitio web.
 * <p>Implementa el patrón Page Object Model (POM) para encapsular los elementos
 * de la página y las acciones relacionadas con el inicio de sesión.</p>
 *
 * <h2>Elementos gestionados:</h2>
 * <ul>
 *     <li>Campo de email</li>
 *     <li>Campo de contraseña</li>
 *     <li>Botón de envío del formulario de inicio de sesión</li>
 * </ul>
 *
 * <h2>Métodos:</h2>
 * <ul>
 *     <li>{@link #hacerLogin(String, String)}: Permite al usuario iniciar sesión ingresando email y contraseña.</li>
 *     <li>{@link #PaginaLogin(WebDriver)}: Inicializa los elementos de la página con el WebDriver.</li>
 * </ul>
 *
 * @author trinitron
 * @since 1.0
 */
public class PaginaLogin {

    private static final String CSS_SELECTOR_CAMPO_EMAIL = "#email";
    private static final String CSS_SELECTOR_CAMPO_PASSWORD = "#passwd";
    private static final String XPATH_BOTON_SUBMIT_LOGIN = "//button[@id='SubmitLogin']";

    @FindBy(css = "#email")
    private WebElement inputEmail;

    @FindBy(css = "#passwd")
    private WebElement inputPassword;

    @FindBy(xpath = "//button[@id='SubmitLogin']")
    private WebElement botonSubmitLogin;
    /**
     * Realiza el proceso de inicio de sesión ingresando email y contraseña.
     * <p>Este método verifica si los campos están vacíos antes de ingresar
     * los valores correspondientes. Si ya contienen información, no realiza
     * ninguna acción.</p>
     *
     * @param email    El correo electrónico del usuario.
     * @param password La contraseña del usuario.
     * @return El WebElement correspondiente al botón de envío, para que
     *         se pueda hacer clic en él.
     */
    public WebElement hacerLogin(String email, String password){
        if (inputEmail.getAttribute("value").isEmpty()) {
            inputEmail.sendKeys(email); // Ingresa el email
        }
        if (inputPassword.getAttribute("value").isEmpty()) {
            inputPassword.sendKeys(password); // Ingresa el password
        }
        return botonSubmitLogin; // Hace clic en el botón de login
    }

    /**
     * Inicializa los elementos de la página de inicio de sesión.
     *
     * @param driver El WebDriver usado para controlar el navegador.
     */
    public PaginaLogin(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
