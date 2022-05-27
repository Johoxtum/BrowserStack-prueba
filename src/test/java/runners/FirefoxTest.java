package runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;
import utils.BrowserStackSerenityTest;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features="src/test/resources/features/Browser1.feature", glue = "stepdefinitions")
public class FirefoxTest extends BrowserStackSerenityTest {

}
