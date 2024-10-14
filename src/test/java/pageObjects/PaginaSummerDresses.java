package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.Arrays;
import java.util.List;

/**
 * The type Pagina summer dresses.
 */
public class PaginaSummerDresses {
    private static final String XPATH_ATRIBUTO_DRESSES = "(//a[@title='Dresses'])[2]";
    private static final String XPATH_ATRIBUTO_SUMMER_DRESSES = "(//a[@title='Summer Dresses'])[2]";
    private static final String XPATH_ATRIBUTO_IMAGEN_SUMMER_DRESSES = "//img[@src='http://www.automationpractice.pl/img/p/1/6/16-home_default.jpg']";


    @FindBy(xpath = "(//a[@title='Dresses'])[2]" )
    private WebElement atributoDresses;

    @FindBy(xpath = "(//a[@title='Summer Dresses'])[2]")
    private WebElement atributoSummerDresses;

    @FindBy(xpath = "//img[@src='http://www.automationpractice.pl/img/p/1/6/16-home_default.jpg']")
    private WebElement atributoImageSummerDresses;

    /**
     * Seleccionar summer dresses list.
     *
     * @return the list
     */
    public List<WebElement> seleccionarSummerDresses(){
        return Arrays.asList(atributoDresses, atributoSummerDresses, atributoImageSummerDresses);
    }

    /**
     * Instantiates a new Pagina summer dresses.
     *
     * @param driver the driver
     */
    public PaginaSummerDresses(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
