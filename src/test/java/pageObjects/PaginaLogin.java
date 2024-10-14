package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * The type Pagina login.
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
     * Hacer login web element.
     *
     * @param email    the email
     * @param password the password
     * @return the web element
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
     * Instantiates a new Pagina login.
     *
     * @param driver the driver
     */
    public PaginaLogin(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
