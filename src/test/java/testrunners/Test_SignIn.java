package testrunners;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
//import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = {"src/test/resources/features/SignIn.feature"
        },
        tags = "@SignIn or @BuyADog",
        glue = {
                "stepdefinitions", "common"
        },
        plugin = {
                "pretty",
                "json:target/cucumber-reports/cucumber.json",
                "html:target/cucumber-reports/cucumber-html-reports.html"
        }
)
public class Test_SignIn extends AbstractTestNGCucumberTests{
}
