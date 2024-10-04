package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//import static tests.CompraSummerDressConChequeTest.XPATH_BOTON_PAGINA_PRINCIPAL;

public class PaginaPrincipal {
    @FindBy(xpath = "//a[@class='login']")
    private WebElement botonPaginaPrincipal;

    public void irASignIn(){
        botonPaginaPrincipal.click();
    }

    public PaginaPrincipal(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
