package stepdefinitions;

import pages.ProductsPageFunctions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProductPageSteps {

    ProductsPageFunctions productsPageFunctions = new ProductsPageFunctions();

    @Given("the user is on the products page")
    public void userLandsOnProductsPage() {
        productsPageFunctions.verifyProductsPage();
    }

    @When("the user selects the Price low to high from the sort dropdown")
    public void userSelectsSortDropdown() {
        productsPageFunctions.sortingProducts();
    }

    @Then("the products should be displayed in ascending order by price")
    public void userDisplayedSortedProducts() {
        productsPageFunctions.verifySortedProductsList();
    }

    @Given("the user is on the products page and count the products")
    public void userIsOnTheProductsPageAndCountTheProducts() {
        productsPageFunctions.countProducts();
    }

    @Then("the product count should remain the same")
    public void theProductCountShouldRemainTheSame() {
        productsPageFunctions.verifyProductCount();
    }

}
