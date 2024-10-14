package tests;
import controlflows.ForConditions;
import controlflows.IfConditions;
import controlflows.WhileConditions;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

/**
 * The type Compra summer dress con cheque test.
 */
public class CompraSummerDressConChequeTest extends GlobalTestSetup{

    /**
     * The constant URL_TIENDA.
     */
    public static final String URL_TIENDA = "http://www.automationpractice.pl/";
    private static final String JS_SHOW_BUTTON = "arguments[0].style.display='block';";
    private IfConditions ifConditions = new IfConditions();
    private WhileConditions whileConditions = new WhileConditions();
    private ForConditions forConditions = new ForConditions();

    /**
     * The Element names.
     */
    String[] elementNames = {
            "ShoppingCartSummaryButton1",
            "ShoppingCartSummaryButton2",
            "ShoppingCartSummaryButton3",
            "ShoppingCartSummaryButton4",
            "ShoppingCartSummaryButton5",
            "ShoppingCartSummaryButton6",
            "ShoppingCartSummaryButton7"
    };

    /**
     * Hacer una consulta.
     */
    /* Método que contiene el test para realizar una compra en la tienda*/
    @Test
    public void hacerUnaConsulta() {
        wait = new WebDriverWait(firefoxDriver, Duration.ofSeconds(TIMEOUT_IN_SECONDS));
        firefoxDriver.get(URL_TIENDA);
        Dimension newSize = new Dimension(1200, 3000);
        firefoxDriver.manage().window().setSize(newSize);
        paginaPrincipal.irASignIn();
        whileConditions.clickWhenClickable(paginaPrincipal.irASignIn(),"Pagina Principal",true,10);
        paginaLogin.hacerLogin("yarcovisth2@gmail.com","Luzelena1*");
        whileConditions.clickWhenClickable(paginaLogin.hacerLogin("Correo Lleno","Contraseña LLena"),"o Boton de Inicio de Sesion ",true,10);
        paginaSummerDresses.seleccionarSummerDresses();
        Actions accion = new Actions(firefoxDriver);
        forConditions.moveAndClickVisibleElements(paginaSummerDresses.seleccionarSummerDresses(),accion,"Accion Atributo summer Dressess");
        forConditions.clickIfVisibleElements(paginaSummerDresses.seleccionarSummerDresses(),accion,"Atributo Summer Dressess");
        forConditions.clickLocatedElement(paginaSummerDresses.seleccionarSummerDresses(),accion,"Imagen del vestido",10);
        paginaPrintedSummerDress.selectSizeAddToCart();
       ifConditions.selectDropdownAndForceChange(paginaPrintedSummerDress.selectSizeAddToCart(),firefoxDriver,JS_SHOW_BUTTON,10);
       forConditions.clickIfVisibleElements(paginaPrintedSummerDress.selectSizeAddToCart(),accion,"Boton add Carr Button",10);
        paginaPopUpProductAddedShopping.moveToCheck();
       ifConditions.clickLocatedElement(paginaPopUpProductAddedShopping.moveToCheck(),accion,firefoxDriver,"Check y CheckOut",10);
        paginaShoppingCartSummary.shoppingSummary();
        forConditions.clickLocatedElementsSequentially(paginaShoppingCartSummary.shoppingSummary(),accion,elementNames,firefoxDriver,10);
    }
}


