package controlflows;
import org.openqa.selenium.WebElement;
/**
 * <p>
 * La clase <b>{@code WhileConditions}</b> proporciona métodos que ejecutan operaciones
 * repetitivas hasta que se cumplan condiciones específicas o se agote un tiempo de espera.
 * Es útil en pruebas automatizadas donde ciertos elementos en la página web pueden ser
 * dinámicos y tardar en ser visibles o habilitados.
 * </p>
 */
public class WhileConditions {
    /**
     * <p>
     * Intenta hacer clic en un elemento web si es visible, habilitado y marcado como "clickeable".
     * Reintenta hasta que se logre hacer clic o se agote el tiempo de espera.
     * </p>
     *
     * <h3>Parámetros:</h3>
     * <ul>
     *   <li><b>elementName</b>: El elemento web sobre el que se intentará hacer clic.</li>
     *   <li><b>expectedText</b>: Texto esperado o nombre descriptivo para fines de <i>logging</i>.</li>
     *   <li><b>isClickable</b>: Bandera que indica si se espera que el elemento sea clickeable.</li>
     *   <li><b>timeoutInSeconds</b>: Tiempo máximo en segundos para intentar hacer clic.</li>
     * </ul>
     *
     * <h3>Funcionamiento:</h3>
     * <ol>
     *   <li>Verifica si el elemento es visible, habilitado y clickeable.</li>
     *   <li>Si lo es, realiza clic e imprime un mensaje en la consola.</li>
     *   <li>Si no, reintenta hasta que se alcance el límite de tiempo especificado.</li>
     * </ol>
     *
     * <h3>Registro en consola:</h3>
     * <p>Los intentos se registran en la consola, con mensajes que indican el estado del elemento
     * y si se logró o no hacer clic en él.</p>
     *
     * <h3>Excepciones:</h3>
     * <ul>
     *   <li><b>InterruptedException</b>: Si ocurre una interrupción durante la espera.</li>
     *   <li><b>Exception</b>: Si ocurre cualquier error al interactuar con el elemento.</li>
     * </ul>
     *
     * @param elementName      El elemento web en el que se intentará hacer clic.
     * @param expectedText     Nombre o texto esperado para fines de <i>logging</i>.
     * @param isClickable      Bandera que indica si se espera que el elemento sea clickeable.
     * @param timeoutInSeconds Tiempo máximo de espera (en segundos) antes de abandonar el intento.
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
