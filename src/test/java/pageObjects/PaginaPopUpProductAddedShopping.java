package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Arrays;
import java.util.List;

/**
 * The type Pagina pop up product added shopping.
 */
public class PaginaPopUpProductAddedShopping {
    private static final String XPATH_ICON_CHECK = "//i[@class='icon-check']";
    private static final String XPATH_BUTTON_CHECKOUT = "//span[contains(text(),'Proceed to checkout')]";

    @FindBy(xpath = "//i[@class='icon-check']" )
    private WebElement moveToCheck;
    @FindBy(xpath = "//span[contains(text(),'Proceed to checkout')]")
    private WebElement ProceedToCheckoutButton;

    /**
     * Move to check list.
     *
     * @return the list
     */
    public List<WebElement> moveToCheck(){
        return Arrays.asList(moveToCheck,ProceedToCheckoutButton);
    }

    /**
     * Instantiates a new Pagina pop up product added shopping.
     *
     * @param driver the driver
     */
    public PaginaPopUpProductAddedShopping(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
