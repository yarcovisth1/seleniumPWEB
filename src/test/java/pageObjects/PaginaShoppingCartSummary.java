package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Arrays;
import java.util.List;

/**
 * The type Pagina shopping cart summary.
 */
public class PaginaShoppingCartSummary {
    private static final String XPATH_BUTTON_CHECKOUT1 = "//a[@class='button btn btn-default standard-checkout button-medium']";

    private static final String XPATH_BUTTON_CHECKOUT2 = "//button[@type='submit']//span[contains(text(),'Proceed to checkout')]";

    private static final String XPATH_BUTTON_CHECKOUT3 = "//input[@id='cgv']";
    private static final String XPATH_BUTTON_CHECKOUT4 = "//button[@type='submit']//span[contains(text(),'Proceed to checkout')]";

    private static final String XPATH_BUTTON_CHECKOUT5 = "//a[@title='Pay by check.']";
    private static final String XPATH_BUTTON_CHECKOUT6 = "//span[contains(text(),'I confirm my order')]";
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
     * Shopping summary list.
     *
     * @return the list
     */
    public List<WebElement> shoppingSummary(){
        return Arrays.asList(ShoppingCartSummaryButton1,ShoppingCartSummaryButton2,ShoppingCartSummaryButton3,
                ShoppingCartSummaryButton4,ShoppingCartSummaryButton5,ShoppingCartSummaryButton6,ShoppingCartSummaryButton7);
    }

    /**
     * Instantiates a new Pagina shopping cart summary.
     *
     * @param driver the driver
     */
    public PaginaShoppingCartSummary(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }
}
