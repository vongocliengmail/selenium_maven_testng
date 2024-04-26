package testrunners;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/resources/features/BuyAFish.feature",
        },
         glue = {
                "stepdefinitions", "common"
        },
        plugin = {
                "pretty",
                "json:target/cucumber-reports/cucumber2.json",
                "html:target/cucumber-reports/cucumber-html-reports2.html"
        }
)

public class Test_BuyAFish extends AbstractTestNGCucumberTests{
}
