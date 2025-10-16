package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import utility.ScreenshotUtil;
import utility.UiInteractables;

public class LoginPageFunctions extends UiInteractables {

    public void login(String userName, String password) {
        UiInteractables.sendKeysByID(driver, elementReader.get("userNameLocator"), reader.get(userName));
        UiInteractables.sendKeysByID(driver, elementReader.get("passwordLocator"), reader.get(password));
        UiInteractables.clickByID(driver, elementReader.get("loginButtonLocator"));
    }

    public void verifyLoginErrors(String expectedErrorMessage) {
        String actualErrorMessage = UiInteractables.findByXpathElement(driver,elementReader.get("errorMessageXpath")).getText();
        ScreenshotUtil.attachScreenshot(driver, "Login page error message");
        Assert.assertEquals("Login error message is not matching when invalid credentials are entered", expectedErrorMessage, actualErrorMessage);
    }
}