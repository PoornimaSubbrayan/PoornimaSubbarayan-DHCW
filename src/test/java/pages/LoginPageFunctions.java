package pages;

import org.junit.Assert;
import org.openqa.selenium.By;

import static hooks.Hooks.*;

public class LoginPageFunctions {

    public void login(String userName, String password) {
        driver.findElement(By.xpath(elementReader.get("userNameXpath"))).sendKeys(reader.get(userName));
        driver.findElement(By.xpath(elementReader.get("passwordXpath"))).sendKeys(reader.get(password));
        driver.findElement(By.xpath(elementReader.get("loginButtonXpath"))).click();
    }

    public void verifyLoginErrors(String expectedErrorMessage) {
        String actualErrorMessage = driver.findElement(By.xpath(elementReader.get("errorMessageXpath"))).getText();
        Assert.assertEquals("Login error message is not matching when invalid credentials are entered", expectedErrorMessage, actualErrorMessage);

    }
}