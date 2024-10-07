package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaginaPrincipal {

   public static final String CLASSNAME_BOTON_PAGINA_PRINCIPAL = "login";

    @FindBy(className = CLASSNAME_BOTON_PAGINA_PRINCIPAL)
    private WebElement botonPaginaPrincipal;

    public WebElement irASignIn(){
        return botonPaginaPrincipal;
    }

    public PaginaPrincipal(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
