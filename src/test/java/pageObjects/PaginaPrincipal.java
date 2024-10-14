package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * The type Pagina principal.
 */
public class PaginaPrincipal {


    /**
     * The constant CLASSNAME_BOTON_PAGINA_PRINCIPAL.
     */
    public static final String CLASSNAME_BOTON_PAGINA_PRINCIPAL = "login";

    @FindBy(className = "login")
    private WebElement botonPaginaPrincipal;

    /**
     * Ir a sign in web element.
     *
     * @return the web element
     */
    public WebElement irASignIn(){
        return botonPaginaPrincipal;
    }

    /**
     * Instantiates a new Pagina principal.
     *
     * @param driver the driver
     */
    public PaginaPrincipal(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
