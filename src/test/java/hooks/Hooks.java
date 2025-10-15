package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utility.PropertyReader;

public class Hooks {

    public static WebDriver driver;
    public static PropertyReader reader;
    public static PropertyReader elementReader;

    @Before
    public void setUp() {
        reader = new PropertyReader("src/test/resources/properties/testdata.properties");
        elementReader = new PropertyReader("src/test/resources/properties/locators.properties");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() throws InterruptedException {
        driver.close();
    }

}
