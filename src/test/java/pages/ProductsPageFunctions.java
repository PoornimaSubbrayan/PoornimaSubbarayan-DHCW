package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utility.ScreenshotUtil;
import utility.UiInteractables;

import java.util.List;

public class ProductsPageFunctions extends UiInteractables {

    public int previousProductsCount;
    public int currentProductsCount;

    public void verifyProductsPage() {
        Assert.assertTrue("User is not on Products page", driver.findElements(By.xpath(elementReader.get("productPageTitle"))).size() > 0);
    }

    public void sortingProducts() {
        UiInteractables.clickByXpath(driver, elementReader.get("sortingDropdown"));
        UiInteractables.SelectByVText(findByXpathElement(driver, elementReader.get("sortingDropdown")), "Price (low to high)");
        String selectedDropDownValue = UiInteractables.findByXpathElement(driver, elementReader.get("selectedDropdownOption")).getText().trim();
        ScreenshotUtil.attachScreenshot(driver, "Sorting Dropdown Selection");
        Assert.assertTrue("Selected dropdown value is not Low to high price", selectedDropDownValue.contains("low to high"));
        System.out.println("User has selected the sorting dropdown value as low to high price");
    }

    public void verifySortedProductsList() {
        List<WebElement> productsPriceList = UiInteractables.findByXpathElements(driver, elementReader.get("productsPriceXpath"));
        ScreenshotUtil.attachScreenshot(driver, "Sorted Products list");
        for (int i = 1; i < productsPriceList.size(); i++) {
            double previousProductPrice = Double.parseDouble(productsPriceList.get(i - 1).getText().trim().replace("$", ""));
            double currentProductPrice = Double.parseDouble(productsPriceList.get(i).getText().trim().replace("$", ""));
            Assert.assertTrue("Price of product number " + (i + 1) + " is greater than the previous product", previousProductPrice <= currentProductPrice);
        }
    }

    public void countProducts() {
        List<WebElement> productsPriceList = UiInteractables.findByXpathElements(driver, elementReader.get("productsPriceXpath"));
        previousProductsCount = productsPriceList.size();
        System.out.println("Number of products counted is :" + previousProductsCount);
        ScreenshotUtil.attachScreenshot(driver, "Products list before sorting");
    }

    public void verifyProductCount() {
        List<WebElement> productsPriceList = UiInteractables.findByXpathElements(driver, elementReader.get("productsPriceXpath"));
        currentProductsCount = productsPriceList.size();
        System.out.println("Number of products counted after sorting low to high price is :" + currentProductsCount);
        ScreenshotUtil.attachScreenshot(driver, "Products list after sorting");
        Assert.assertEquals("Product count has changed after sorting", previousProductsCount, currentProductsCount);
    }
}
