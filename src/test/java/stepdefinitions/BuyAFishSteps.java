package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import static common.ThreadWebDriver.getDriver;
import static org.testng.AssertJUnit.assertTrue;


public class BuyAFishSteps {
    private WebElement elem = null;

    @When("I select the Fish item")
    public void i_select_the_fish_item() {
        System.out.println("I select the Fish item");
        try {
            Thread.sleep(1000);
            elem = getDriver().findElement(By.xpath(System.getProperty("HomePage.Fish.Link")));
            elem.click();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @Then("I see the list of Fish")
    public void iSeeTheListOfFish() {
        System.out.println("I see the list of Fish");
        try {
            Thread.sleep(1000);
            elem = getDriver().findElement(By.xpath(System.getProperty("DogPage.ReturnToMainMenu.Link")));
            elem.isDisplayed();
            assertTrue(elem.isDisplayed());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
