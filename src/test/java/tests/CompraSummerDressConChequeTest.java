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
 * Realiza pruebas automatizadas para la compra de un vestido de verano.
 *
 * === Descripción ===
 * Este método navega a la tienda y agrega un vestido al carrito.
 *
 * === Pasos ===
 * 1. Iniciar sesión.
 * 2. Seleccionar el vestido.
 * 3. Agregar al carrito.
 *
 * @author trinitron
 * @see IfConditions
 * @see WhileConditions
 * @see ForConditions
 */

public class CompraSummerDressConChequeTest extends GlobalTestSetup{

    /**
     * URL de la tienda en línea donde se realizarán las pruebas.
     *
     * @value "http://www.automationpractice.pl/"
     */
    public static final String URL_TIENDA = "http://www.automationpractice.pl/";
    /**
     * Script JavaScript que muestra un botón en la página.
     *
     * @value "arguments[0].style.display='block';"
     */
    private static final String JS_SHOW_BUTTON = "arguments[0].style.display='block';";
    /**
     * Instancia de IfConditions para manejar condiciones de visibilidad en las pruebas.
     *
     * @see IfConditions
     */
    private IfConditions ifConditions = new IfConditions();
    /**
     * Instancia de WhileConditions para manejar comportamientos de espera más complejos.
     *
     * @see WhileConditions
     */
    private WhileConditions whileConditions = new WhileConditions();
    /**
     * Instancia de ForConditions para manejar acciones de interacción con elementos.
     *
     * @see ForConditions
     */
    private ForConditions forConditions = new ForConditions();
    /**
     * Nombres de los elementos que representan los botones de resumen del carrito de compras.
     *
     * Estos nombres se utilizan para interactuar con los elementos en la página de resumen del carrito.
     *
     * @see PaginaShoppingCartSummary  // Ejemplo de uso de la etiqueta @see para referenciar otra clase
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
     * Realiza una consulta en la tienda en línea y agrega un vestido de verano al carrito.
     *
     * Este método navega a la tienda, inicia sesión con un usuario específico,
     * selecciona un vestido de verano y lo agrega al carrito de compras.
     *
     * Se asegura de que el proceso de compra se realice correctamente siguiendo el flujo
     * definido, verificando la visibilidad de los elementos en la página y manejando
     * las interacciones necesarias.
     *
     *  Este método está anotado con {@link org.junit.Test} y se ejecuta como parte
     *  del conjunto de pruebas.
     *
     * @see GlobalTestSetup
     * @see PaginaPrincipal
     * @see PaginaLogin
     * @see PaginaSummerDresses
     * @see PaginaPrintedSummerDress
     * @see PaginaPopUpProductAddedShopping
     * @see PaginaShoppingCartSummary
     */

    @Test
    public void hacerUnaConsulta() {
        /*Establecer el tiempo de espera y abrir la URL de la tienda */
        wait = new WebDriverWait(firefoxDriver, Duration.ofSeconds(TIMEOUT_IN_SECONDS));
        firefoxDriver.get(URL_TIENDA);
        /*Configurar el tamaño de la ventana del navegador */
        Dimension newSize = new Dimension(1200, 3000);
        firefoxDriver.manage().window().setSize(newSize);
        /* Navegar a la página de inicio de sesión */
        paginaPrincipal.irASignIn();
        whileConditions.clickWhenClickable(paginaPrincipal.irASignIn(),"Pagina Principal",true,10);
        /*Iniciar sesión */
        paginaLogin.hacerLogin("yarcovisth2@gmail.com","Luzelena1*");
        whileConditions.clickWhenClickable(paginaLogin.hacerLogin("Correo Lleno","Contraseña LLena"),"o Boton de Inicio de Sesion ",true,10);
        /*Seleccionar vestido de verano */
        paginaSummerDresses.seleccionarSummerDresses();
        Actions accion = new Actions(firefoxDriver);
        forConditions.moveAndClickVisibleElements(paginaSummerDresses.seleccionarSummerDresses(),accion,"Accion Atributo summer Dressess");
        forConditions.clickIfVisibleElements(paginaSummerDresses.seleccionarSummerDresses(),accion,"Atributo Summer Dressess");
        forConditions.clickLocatedElement(paginaSummerDresses.seleccionarSummerDresses(),accion,"Imagen del vestido",10);
        /*Seleccionar talla y agregar al carrito */
        paginaPrintedSummerDress.selectSizeAddToCart();
        ifConditions.selectDropdownAndForceChange(paginaPrintedSummerDress.selectSizeAddToCart(),firefoxDriver,JS_SHOW_BUTTON,10);
        forConditions.clickIfVisibleElements(paginaPrintedSummerDress.selectSizeAddToCart(),accion,"Boton add Carr Button",10);
        /*Verificar el pop-up de producto añadido */
        paginaPopUpProductAddedShopping.moveToCheck();
        ifConditions.clickLocatedElement(paginaPopUpProductAddedShopping.moveToCheck(),accion,firefoxDriver,"Check y CheckOut",10);
        /*Resumen del carrito de compras */
        paginaShoppingCartSummary.shoppingSummary();
        forConditions.clickLocatedElementsSequentially(paginaShoppingCartSummary.shoppingSummary(),accion,elementNames,firefoxDriver,10);
    }
}


