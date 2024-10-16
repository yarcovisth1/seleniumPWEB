package controlflows;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;
/**
 * <p>
 * La clase <b>{@code IfConditions}</b> contiene métodos para realizar acciones
 * condicionales en elementos web, como seleccionar opciones de un dropdown y
 * hacer clic en botones de manera dinámica. Se usa para manejar condiciones complejas
 * de elementos que pueden ser clickeables o habilitados solo en ciertos escenarios.
 * </p>
 */
public class IfConditions {
    /**
     * <p>
     * Selecciona una talla de un <i>dropdown</i> y fuerza el cambio de evento mediante
     * JavaScript. Reintenta hasta que el botón "Agregar al carrito" esté habilitado
     * o se agoten las opciones disponibles.
     * </p>
     *
     * <h3>Parámetros:</h3>
     * <ul>
     *   <li><b>elements</b>: Lista de elementos web donde el primer elemento es el
     *   <i>dropdown</i> y el segundo es el botón "Agregar al carrito".</li>
     *   <li><b>driver</b>: El controlador de Selenium.</li>
     *   <li><b>jsScript</b>: Código JavaScript a ejecutar para forzar un cambio.</li>
     *   <li><b>timeoutInSeconds</b>: Tiempo máximo en segundos para esperar los elementos.</li>
     * </ul>
     *
     * <h3>Funcionamiento:</h3>
     * <ol>
     *   <li>Intenta seleccionar una talla disponible (S, M o L).</li>
     *   <li>Fuerza la actualización del <i>dropdown</i> usando JavaScript.</li>
     *   <li>Verifica si el botón "Agregar al carrito" se habilitó tras cada intento.</li>
     * </ol>
     *
     * <h3>Excepciones:</h3>
     * <ul>
     *   <li><b>TimeoutException</b>: Si los elementos no están disponibles en el tiempo límite.</li>
     *   <li><b>Exception</b>: Si ocurre un error durante la interacción.</li>
     * </ul>
     *
     * @param elements         Lista con el <i>dropdown</i> y el botón.
     * @param driver           Controlador de Selenium.
     * @param jsScript         Código JavaScript para forzar eventos.
     * @param timeoutInSeconds Tiempo máximo de espera.
     */
    public void selectDropdownAndForceChange(
            List<WebElement> elements, WebDriver driver, String jsScript, int timeoutInSeconds) {

        String[] tallas = {"S", "M", "L"};
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));

        try {
            WebElement dropdownElement = wait.until(ExpectedConditions.elementToBeClickable(elements.get(0)));
            Select tallaSelect = new Select(dropdownElement);
            WebElement addToCartButton = elements.get(1);

            if (!dropdownElement.isEnabled()) {
                System.out.println("El dropdown no está habilitado.");
                return;
            }

            boolean botonHabilitado = false;
            int intentos = 0;

            // Bucle para intentar habilitar el botón
            while (!botonHabilitado && intentos < tallas.length) { // Solo intenta una vez por talla
                String tallaActual = tallas[intentos];
                System.out.println("Intentando seleccionar talla: " + tallaActual);

                seleccionarTalla(tallaSelect, tallaActual, dropdownElement, driver);

                // Esperar un tiempo antes de verificar el botón
                Thread.sleep(1000); // Espera 1 segundo para que el UI se actualice

                // Verificar si el botón "Agregar al carrito" está habilitado
                try {
                    wait.until(ExpectedConditions.elementToBeClickable(addToCartButton));
                    botonHabilitado = true;
                    System.out.println("El botón 'Agregar al carrito' está habilitado.");
                } catch (TimeoutException e) {
                    System.out.println("El botón 'Agregar al carrito' aún no está habilitado.");
                }

                intentos++;
            }

            if (!botonHabilitado) {
                System.out.println("No se pudo habilitar el botón 'Agregar al carrito' tras los intentos.");
            }

        } catch (Exception e) {
            System.out.println("Ocurrió un error: " + e.getMessage());
        }
    }
    /**
     * <p>Selecciona una talla específica en el <i>dropdown</i> y simula eventos de cambio e input
     * usando JavaScript.</p>
     *
     * @param tallaSelect      Objeto <b>Select</b> que representa el <i>dropdown</i>.
     * @param talla            La talla a seleccionar (S, M o L).
     * @param dropdownElement  Elemento <i>dropdown</i> en la interfaz.
     * @param driver           Controlador de Selenium.
     */
    private void seleccionarTalla(
            Select tallaSelect, String talla, WebElement dropdownElement, WebDriver driver) {
        try {
            // Verificar si la opción existe
            boolean optionExists = tallaSelect.getOptions().stream()
                    .anyMatch(option -> option.getText().equals(talla));

            if (!optionExists) {
                System.out.println("La opción '" + talla + "' no está disponible.");
                return;
            }

            // Seleccionar la talla
            tallaSelect.selectByVisibleText(talla);
            System.out.println("Se seleccionó la talla: " + talla);

            // Enviar eventos con JavaScript y simular clic y Enter
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript(
                    "arguments[0].dispatchEvent(new Event('change', { bubbles: true }));",
                    dropdownElement
            );
            js.executeScript(
                    "arguments[0].dispatchEvent(new Event('input', { bubbles: true }));",
                    dropdownElement
            );

            // Simular clic y Enter
            dropdownElement.click();
            dropdownElement.sendKeys(Keys.ENTER);
            System.out.println("Interacción forzada sobre la talla '" + talla + "'.");

        } catch (Exception e) {
            System.out.println("Error al seleccionar la talla '" + talla + "': " + e.getMessage());
        }
    }
    /**
     * <p>
     * Hace clic en un botón tras verificar que un ícono de verificación sea visible.
     * </p>
     *
     * <h3>Parámetros:</h3>
     * <ul>
     *   <li><b>elements</b>: Lista de elementos, donde el primero es un ícono de verificación
     *   y el segundo es un botón de "Proceed to checkout".</li>
     *   <li><b>action</b>: Objeto <b>Actions</b> para realizar la interacción.</li>
     *   <li><b>driver</b>: Controlador de Selenium.</li>
     *   <li><b>elementName</b>: Nombre del elemento para <i>logging</i>.</li>
     *   <li><b>timeoutInSeconds</b>: Tiempo máximo de espera.</li>
     * </ul>
     *
     * <h3>Funcionamiento:</h3>
     * <ol>
     *   <li>Espera a que el ícono de verificación sea visible.</li>
     *   <li>Hace clic en el botón "Proceed to checkout".</li>
     * </ol>
     *
     * @param elements         Lista de elementos web.
     * @param action           Objeto <b>Actions</b> de Selenium.
     * @param driver           Controlador de Selenium.
     * @param elementName      Nombre del elemento para <i>logging</i>.
     * @param timeoutInSeconds Tiempo máximo de espera.
     */
    public void clickLocatedElement(List<WebElement> elements, Actions action,WebDriver driver ,String elementName, int timeoutInSeconds) {
        if (elements.size() >= 2) {
            WebElement iconElement = elements.get(0); // El ícono de verificación
            WebElement buttonElement = elements.get(1); // El botón "Proceed to checkout"

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));

            // Paso 1: Asegurarse de que el ícono esté visible (ubicar el ícono)
            try {
                wait.until(ExpectedConditions.visibilityOf(iconElement));
                System.out.println("El ícono de verificación está visible.");
            } catch (Exception e) {
                System.out.println("No se pudo ubicar el ícono de verificación: " + e.getMessage());
                return;
            }

            // Paso 2: Hacer clic en el botón "Proceed to checkout"
            try {
                wait.until(ExpectedConditions.elementToBeClickable(buttonElement));
                action.moveToElement(buttonElement).click().perform();
                System.out.println("Se hizo clic en el botón '" + elementName + "' (Proceed to checkout).");
            } catch (Exception e) {
                System.out.println("Error al intentar hacer clic en el botón '" + elementName + "': " + e.getMessage());
            }
        } else {
            System.out.println("La lista de elementos es insuficiente para la operación.");
        }
    }
}
