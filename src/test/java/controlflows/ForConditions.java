package controlflows;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;
/**
 * Clase que gestiona flujos de control para condiciones específicas en pruebas automatizadas con Selenium.
 * <p>Proporciona diferentes métodos para interactuar con listas de elementos, incluyendo acciones como mover, hacer clic,
 * y manejar condiciones de visibilidad y clicabilidad.</p>
 *
 * <h2>Métodos principales:</h2>
 * <ul>
 *     <li>{@link #moveAndClickVisibleElements(List, Actions, String)}: Mueve y hace clic en los elementos visibles.</li>
 *     <li>{@link #clickIfVisibleElements(List, Actions, String)}: Hace clic en los elementos si son visibles.</li>
 *     <li>{@link #clickIfVisibleElements(List, Actions, String, int)}: Hace clic con un tiempo límite para cada intento.</li>
 *     <li>{@link #clickLocatedElement(List, Actions, String, int)}: Hace clic si los elementos son visibles y habilitados.</li>
 *     <li>{@link #clickLocatedElementsSequentially(List, Actions, String[], WebDriver, int)}: Interactúa con elementos en orden secuencial.</li>
 * </ul>
 *
 * @author trinitron
 * @since 1.0
 */
public class ForConditions {

    /**
     * Mueve y hace clic en los elementos visibles de la lista proporcionada.
     *
     * @param elements    Lista de elementos Web.
     * @param action      Objeto {@link Actions} para realizar las acciones.
     * @param elementName Nombre descriptivo del elemento.
     */
    public void moveAndClickVisibleElements(List<WebElement> elements, Actions action, String elementName) {
        for (WebElement element : elements) {
            try {
                if (element.isDisplayed()) {
                    action.moveToElement(element).perform();
                    System.out.println("Se movió el ratón sobre el elemento '" + elementName + "' porque es visible.");
                } else {
                    System.out.println("El elemento '" + elementName + "' NO es visible.");
                }
            } catch (Exception e) {
                System.out.println("No se pudo mover el ratón sobre el elemento '" + elementName + "' debido a un error: " + e.getMessage());
            }
        }
    }
    /**
     * Hace clic en los elementos si son visibles.
     *
     * @param elements    Lista de elementos Web.
     * @param action      Objeto {@link Actions} para realizar la acción de clic.
     * @param elementName Nombre del elemento.
     */
    public void clickIfVisibleElements(List<WebElement> elements, Actions action, String elementName) {
        for (WebElement element : elements) {
            try {
                if (element.isDisplayed()) {
                    action.moveToElement(element).click().perform();
                    System.out.println("donaldo"+element);
                    System.out.println("Se movió el ratón sobre el elemento '" + elementName + "' porque es visible.");
                } else {
                    System.out.println("El elemento '" + elementName + "' NO es visible."+elements);
                }
            } catch (Exception e) {
                System.out.println("No se pudo mover el ratón sobre el elemento '" + elementName + "' debido a un error: " + e.getMessage());
            }
        }
    }
    /**
     * Hace clic en los elementos si son visibles, con un tiempo límite para cada intento.
     *
     * @param elements         Lista de elementos Web.
     * @param action           Objeto {@link Actions} para realizar la acción.
     * @param elementName      Nombre del elemento.
     * @param timeoutInSeconds Tiempo límite en segundos para cada intento.
     */
    public void clickIfVisibleElements(List<WebElement> elements, Actions action, String elementName, int timeoutInSeconds) {
        boolean elementClicked = false;

        for (WebElement element : elements) {
            int attempts = 0;
            while (attempts < timeoutInSeconds) {
                try {
                    if (element.isDisplayed()) {
                        action.moveToElement(element).click().perform();
                        System.out.println("Se movió el ratón sobre el elemento '" + elementName + "' porque es visible.");
                        elementClicked = true;
                        break;  // Rompe el ciclo si se hace clic en el elemento
                    } else {
                        System.out.println("El elemento '" + elementName + "' NO es visible. Intentando nuevamente...");
                    }
                } catch (Exception e) {
                    System.out.println("No se pudo mover el ratón sobre el elemento '" + elementName + "' debido a un error: " + e.getMessage());
                }
                attempts++;
                try {
                    Thread.sleep(1000); // Espera 1 segundo antes de intentar nuevamente
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if (!elementClicked) {
                System.out.println("No se pudo hacer clic en el elemento '" + elementName + "' después de " + timeoutInSeconds + " segundos.");
            }
        }
    }
    /**
     * Hace clic en los elementos visibles y habilitados, con reintentos limitados.
     *
     * @param elements         Lista de elementos Web.
     * @param action           Objeto {@link Actions} para realizar la acción.
     * @param elementName      Nombre del elemento.
     * @param timeoutInSeconds Tiempo límite en segundos para cada intento.
     */
    public void clickLocatedElement(List<WebElement> elements, Actions action, String elementName, int timeoutInSeconds) {
        int attempts = 0;
        boolean elementClicked = false;
        for (WebElement element : elements) {
            while (attempts < timeoutInSeconds){
            try {
                if (element.isDisplayed() && element.isEnabled()) {
                    action.moveToElement(element).click().perform();
                    System.out.println("donaldo"+element);
                    System.out.println("Se hizo clic en el elemento '" + elementName + "' porque es visible y está habilitado.");
                    elementClicked = true;
                    break;
                } else {
                    System.out.println("El elemento '" + elementName + "' no es visible o no está habilitado. Reintentando...");
                }
            } catch (Exception e) {
                System.out.println("Error al intentar hacer clic en el elemento '" + elementName + "': " + e.getMessage());
            }
                attempts++;
                try {
                    Thread.sleep(1000); // Espera un segundo antes de volver a intentar
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if (!elementClicked) {
                System.out.println("El elemento '" + elementName + "' no se pudo clicar después de " + timeoutInSeconds + " segundos.");
            }
            attempts = 0;
            elementClicked = false;
        }
    }
    /**
     * Interactúa con los elementos de forma secuencial según los XPaths proporcionados.
     *
     * @param elements         Lista de elementos Web.
     * @param action           Objeto {@link Actions} para realizar la acción.
     * @param elementNames     Nombres de los elementos.
     * @param driver           Objeto {@link WebDriver} para manejar el navegador.
     * @param timeoutInSeconds Tiempo límite para cada intento.
     */
    public void clickLocatedElementsSequentially(List<WebElement> elements, Actions action,
                                                 String[] elementNames, WebDriver driver, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));

        String[] xpaths = {
                "//a[@class='button btn btn-default standard-checkout button-medium']",
                "//button[@type='submit']//span[contains(text(),'Proceed to checkout')]",
                "//input[@id='cgv']",
                "//button[@type='submit']//span[contains(text(),'Proceed to checkout')]",
                "//a[@title='Pay by check.']",
                "//span[contains(text(),'I confirm my order')]",
                "//p[@class='alert alert-success']"
        };

        for (int i = 0; i < elements.size(); i++) {
            String xpath = xpaths[i];
            String elementName = elementNames[i];
            WebElement element;

            try {
                // Esperar y obtener el elemento
                if (xpath.equals("//input[@id='cgv']")) {
                    // Esperar hasta que el div que contiene el checkbox sea visible
                    WebElement checkboxDiv = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='uniform-cgv']")));

                    // Verificar si el checkbox está marcado
                    boolean isChecked = checkboxDiv.getAttribute("class").contains("checked");

                    // Si no está marcado, hacer clic en el checkbox
                    if (!isChecked) {
                        checkboxDiv.click(); // Hacer clic en el div que contiene el checkbox
                        System.out.println("Checkbox 'cgv' estaba desmarcado, se hizo clic en él.");
                    } else {
                        System.out.println("Checkbox 'cgv' ya está marcado.");
                    }
                    // Continuar al siguiente elemento
                    continue;
                } else {
                    element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
                }

                // Desplazarse al elemento
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

                // Asegurarse de que el elemento es clickeable
                wait.until(ExpectedConditions.elementToBeClickable(element));

                // Hacer clic
                action.moveToElement(element).click().perform();
                System.out.println("Se hizo clic en el elemento '" + elementName + "'.");

            } catch (Exception e) {
                System.out.println("Error al intentar hacer clic en el elemento '" + elementName + "': " + e.getMessage());
            }
        }
    }
}
