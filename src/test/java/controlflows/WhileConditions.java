package controlflows;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import org.openqa.selenium.WebDriver;

public class WhileConditions {

    private WebDriver driver;

    // Constructor para recibir WebDriver
    public WhileConditions(WebDriver driver) {
        this.driver = driver;
    }

    public void clickWhenClickable(WebElement elementName, String expectedText, boolean isClickable, int timeoutInSeconds) {
        int attempts = 0;
        boolean elementClicked = false;

        while (attempts < timeoutInSeconds) {
            try {
                // Verificar si el elemento es visible y habilitado
                if (elementName.isDisplayed() && elementName.isEnabled() && isClickable) {
                    // Usar WebDriverWait para esperar que el elemento sea clickeable
                    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
                    wait.until(ExpectedConditions.elementToBeClickable(elementName));

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

            // Ya no se usa Thread.sleep(), sino una espera explícita
            try {
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
                wait.until(ExpectedConditions.visibilityOf(elementName));
            } catch (Exception e) {
                System.out.println("Error en la espera explícita: " + e.getMessage());
            }
        }

        if (!elementClicked) {
            System.out.println("El elemento '" + expectedText + "' no se pudo clicar después de " + timeoutInSeconds + " segundos.");
        }
    }
}
