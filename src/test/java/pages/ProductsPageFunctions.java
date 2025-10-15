package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static hooks.Hooks.driver;
import static hooks.Hooks.elementReader;

public class ProductsPageFunctions {

    public int previousProductsCount;
    public int currentProductsCount;

    public void verifyProductsPage() {
        Assert.assertTrue("User is not on Products page", driver.findElements(By.xpath(elementReader.get("productPageTitle"))).size() > 0);
    }

    public void sortingProducts() {
        driver.findElement(By.xpath(elementReader.get("sortingDropdown"))).click();
        WebElement dropdown = driver.findElement(By.xpath(elementReader.get("sortingDropdown")));
        Select select = new Select(dropdown);
        select.selectByValue("lohi");
        String selectedDropDownValue = driver.findElement(By.xpath(elementReader.get("selectedDropdownOption"))).getText().trim();
        Assert.assertTrue("Selected dropdown value is not Low to high price", selectedDropDownValue.contains("low to high"));
        System.out.println("User has selected the sorting dropdown value as low to high price");
    }

    public void verifySortedProductsList() {
        List<WebElement> productsPriceList = driver.findElements(By.xpath(elementReader.get("productsPriceXpath")));

        for (int i = 1; i < productsPriceList.size(); i++) {
            double previousProductPrice = Double.parseDouble(productsPriceList.get(i - 1).getText().trim().replace("$", ""));
            double currentProductPrice = Double.parseDouble(productsPriceList.get(i).getText().trim().replace("$", ""));
            Assert.assertTrue("Price of product number " + (i + 1) + " is greater than the previous product", previousProductPrice <= currentProductPrice);
        }
    }

    public void countProducts() {
        List<WebElement> productsPriceList = driver.findElements(By.xpath(elementReader.get("productsPriceXpath")));
        previousProductsCount = productsPriceList.size();
        System.out.println("Number of products counted is :" + previousProductsCount);
    }

    public void verifyProductCount() {
        List<WebElement> productsPriceList = driver.findElements(By.xpath(elementReader.get("productsPriceXpath")));
        currentProductsCount = productsPriceList.size();
        System.out.println("Number of products counted after sorting low to high price is :" + currentProductsCount);
        Assert.assertEquals("Product count has changed after sorting", previousProductsCount, currentProductsCount);
    }
}
