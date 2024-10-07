package controlflows;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class IfConditions {

    public void clickIfVisible(WebElement element, String elementName) {
        if (element.isDisplayed()) {
            element.click();
            System.out.println("El elemento '" + elementName + "' es visible y se ha hecho clic.");
        } else {
            System.out.println("El elemento '" + elementName + "' NO es visible.");
        }
    }
    public void selectCheckboxIfNotSelected(WebElement checkbox, String checkboxName) {
        if (!checkbox.isSelected()) {
            checkbox.click();  // Hacer clic en el div envolvente para seleccionar el checkbox
            System.out.println("El checkbox '" + checkboxName + "' fue seleccionado.");
        } else {
            System.out.println("El checkbox '" +checkboxName + "'  no fue seleccionado.");

        }
    }
    public void validateBannerText(WebElement element, String expectedText) {
        if (element.isDisplayed()) {
            String bannerText = element.getText();
            if (bannerText.contains(expectedText)) {
                System.out.println("El mensaje '" + expectedText + "' se muestra correctamente.");
                Assert.assertTrue("El mensaje esperado no se encontró en el banner.", bannerText.contains(expectedText));
            } else {
                System.out.println("El banner está visible, pero el texto esperado no está presente.");
                Assert.fail("El texto esperado '" + expectedText + "' no está en el banner.");
            }
        } else {
            System.out.println("El banner de confirmación no está visible.");
            Assert.fail("El banner de confirmación no se mostró.");
        }
    }

    public void moveToElementIfVisible(WebElement element, Actions action, String elementName) {
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

    public void selectDropdownAndForceChange(WebElement element,int index,String[] tallas,String visibleText, WebDriver driver, String jsScript) {

            // Asegurarse de que el elemento esté visible antes de interactuar
            if ( !element.isSelected() && element.isEnabled()) {
                String tallaSeleccionada = tallas[index];
                // Interactuar con el dropdown
                Select tallaSelect = new Select(element);
                tallaSelect.selectByVisibleText(tallaSeleccionada);
                System.out.println("Se seleccionó la '" + visibleText + "'+'"+ tallaSeleccionada +"' en el desplegable.");
                // Ejecutar el script de JavaScript para forzar el cambio
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript(jsScript, element);
                System.out.println("Se ejecutó el script de cambio de evento en el desplegable.");
            } else {
                System.out.println("El desplegable no está visible o habilitado.");
            }
        }

    public void sendKeysIfVisible(WebElement element, String text, String elementName) {
        try {
            // Verifica si el elemento es visible y está habilitado
            if (element.isDisplayed() && element.isEnabled()) {
                element.sendKeys(text);
                System.out.println("Se ha ingresado '" + text + "' en el elemento '" + elementName + "'.");
            } else {
                System.out.println("El elemento '" + elementName + "' NO está visible o habilitado.");
            }
        } catch (Exception e) {
            System.out.println("No se pudo interactuar con el elemento '" + elementName + "' debido a un error: " + e.getMessage());
        }
    }


    public void validar (WebElement elementName, String expectedText,boolean isClickable) {
        if (elementName.isDisplayed() && elementName.isEnabled() && isClickable) {
            elementName.click();
            System.out.println("El elemento '" + elementName + "' de la "+expectedText+" se muestra y esta habilitado");
        } else {
            System.out.println("El elemento '" + elementName + "' de la "+expectedText+" no se muestra y no esta habilitado");
        }
    }

}
