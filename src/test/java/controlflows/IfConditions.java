package controlflows;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

/**
 * The type If conditions.
 */
public class IfConditions {

    /**
     * Select dropdown and force change.
     *
     * @param elements         the elements
     * @param driver           the driver
     * @param jsScript         the js script
     * @param timeoutInSeconds the timeout in seconds
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
     * Click located element.
     *
     * @param elements         the elements
     * @param action           the action
     * @param driver           the driver
     * @param elementName      the element name
     * @param timeoutInSeconds the timeout in seconds
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
