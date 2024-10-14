package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * The type Pagina printed summer dress.
 */
public class PaginaPrintedSummerDress {
    private static final String ID_SELECT_ELEMENT = "//select[@id='group_1']";
    private static final String XPATH_ADD_TO_CART_BUTTON = "//button[@name='Submit' and @class='exclusive']";
    /**
     * The Tallas.
     */
    String[] tallas = {"S", "M", "L"};

    @FindBy(xpath = "//select[@id='group_1']" )
    private WebElement selectElementSize;
    @FindBy(xpath = "//button[@name='Submit' and @class='exclusive']")
    private WebElement addToCartButton;

    /**
     * Select size add to cart list.
     *
     * @return the list
     */
    public List<WebElement> selectSizeAddToCart(){
        return Arrays.asList(selectElementSize,addToCartButton);
    }

    /**
     * Instantiates a new Pagina printed summer dress.
     *
     * @param driver the driver
     */
    public PaginaPrintedSummerDress(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
