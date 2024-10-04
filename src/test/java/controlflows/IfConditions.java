package controlflows;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

public class IfConditions {

    public void clickIfVisible(WebElement element, String elementName) {
        if (element.isDisplayed()) {
            element.click();
            System.out.println("El elemento '" + elementName + "' es visible y se ha hecho clic.");
        } else {
            System.out.println("El elemento '" + elementName + "' NO es visible.");
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

}
