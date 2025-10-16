package utility;

import java.util.List;

import hooks.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class UiInteractables extends Hooks {

    // This class contains all the reusable methods for interacting with UI elements
    // This reusable method is used to clear and enter text details in a textbox
    public static void sendKeysByID(WebDriver driver, String id, String text) {
        WebElement element = driver.findElement(By.id(id));
        element.clear();
        element.sendKeys(new CharSequence[]{text});
    }

    // This reusable method is used to click the button
    public static void clickByID(WebDriver driver, String id) {
        WebElement element = driver.findElement(By.id(id));
        element.click();
    }

    // This reusable method is used to click the element by xpath
    public static void clickByXpath(WebDriver driver, String xpath) {
        WebElement element = driver.findElement(By.xpath(xpath));
        element.click();
    }

    // This reusable method is used to find the element by xpath and return the element
    public static WebElement findByXpathElement(WebDriver driver, String xpath) {
        WebElement element = driver.findElement(By.xpath(xpath));
        return element;
    }

    // This reusable method is used to find the elements by xpath and return the list of elements
    public static List<WebElement> findByXpathElements(WebDriver driver, String xpath) {
        List<WebElement> elements = driver.findElements(By.xpath(elementReader.get("productsPriceXpath")));
        return elements;
    }

    // This reusable method is used to select the element using web element and visible text from dropdown
    public static void SelectByVText(WebDriver driver, WebElement DDName, String DDoption) {
        Select select = new Select(DDName);
        select.selectByVisibleText(DDoption);
    }

}
