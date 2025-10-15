package stepdefinitions;

import pages.LoginPageFunctions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.time.Duration;

import static hooks.Hooks.driver;
import static hooks.Hooks.reader;

public class LoginPageSteps {
    LoginPageFunctions loginPageFunctions = new LoginPageFunctions();

    @Given("the user is on the login page")
    public void navigateToLoginPage() {
        driver.get(reader.get("application_url"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @When("the user logs in with {string} and {string}")
    public void enterUserCredentials(String userName, String password) {
        System.out.println("User is on login page");
        loginPageFunctions.login(userName, password);
    }

    @Then("the user should land on the list of products page")
    public void verifyUserLandsOnProductsPage() {
        Assert.assertEquals("User is not on Products page", "Swag Labs", driver.getTitle());
    }

    @Then("the user should see the {string}")
    public void verifyErrorMessagesDuringLogin(String expectedErrorMessage) {
        loginPageFunctions.verifyLoginErrors(expectedErrorMessage);

    }
}