package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import utility.ScreenshotUtil;

import static hooks.Hooks.*;

public class LoginPageFunctions {

    public void login(String userName, String password) {
        driver.findElement(By.id(elementReader.get("userNameLocator"))).sendKeys(reader.get(userName));
        driver.findElement(By.id(elementReader.get("passwordLocator"))).sendKeys(reader.get(password));
        driver.findElement(By.id(elementReader.get("loginButtonLocator"))).click();
    }

    public void verifyLoginErrors(String expectedErrorMessage) {
        String actualErrorMessage = driver.findElement(By.xpath(elementReader.get("errorMessageXpath"))).getText();
        ScreenshotUtil.attachScreenshot(driver, "Login page error message");
        Assert.assertEquals("Login error message is not matching when invalid credentials are entered", expectedErrorMessage, actualErrorMessage);

    }
}