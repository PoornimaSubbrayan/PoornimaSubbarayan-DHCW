package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(publish = true, features = "src/test/resources/features",
        glue = {"stepdefinitions", "hooks"},
         plugin = {"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"},
        monochrome = true //,
        //tags = "@products"
)
public class RunCucumberTest {

}
