package controlflows;
import org.openqa.selenium.WebElement;

/**
 * The type While conditions.
 */
public class WhileConditions {

    /**
     * Click when clickable.
     *
     * @param elementName      the element name
     * @param expectedText     the expected text
     * @param isClickable      the is clickable
     * @param timeoutInSeconds the timeout in seconds
     */
    public void clickWhenClickable(WebElement elementName, String expectedText, boolean isClickable, int timeoutInSeconds) {
        int attempts = 0;
        boolean elementClicked = false;

        while (attempts < timeoutInSeconds) {
            try {
                // Verificar si el elemento es visible y habilitado
                if (elementName.isDisplayed() && elementName.isEnabled() && isClickable) {
                    elementName.click();
                    System.out.println("El elemento '" + expectedText + "' se muestra y está habilitado. Se ha hecho clic.");
                    elementClicked = true;
                    break; // Salir del ciclo si se pudo hacer clic
                } else {
                    System.out.println("El elemento '" + expectedText + "' no se muestra o no está habilitado. Reintentando...");
                }
            } catch (Exception e) {
                System.out.println("Excepción al intentar interactuar con el elemento: " + e.getMessage());
            }

            attempts++;
            try {
                Thread.sleep(1000); // Espera un segundo antes de volver a intentar
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        if (!elementClicked) {
            System.out.println("El elemento '" + expectedText + "' no se pudo clicar después de " + timeoutInSeconds + " segundos.");
        }
    }
}
