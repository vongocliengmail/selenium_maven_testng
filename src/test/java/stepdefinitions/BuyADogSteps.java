package stepdefinitions;

import static common.ThreadWebDriver.*;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pageobjects.HomePage;
import pageobjects.SignInPage;
import utilities.EnvironmentConfiguration;
import utilities.actions.CommonActions;

public class BuyADogSteps {
    private WebElement elem = null;
    private EnvironmentConfiguration envConfig = new EnvironmentConfiguration(System.getProperty("env"));
    SignInPage signInPage = new SignInPage();
    HomePage homePage =new HomePage();
    CommonActions commonActions =new CommonActions();

    @Given("I am signed in to the Pet Store page site")
    public void iAmSignedInToThePetStorePageSite() {
        System.out.println("I am signed in to the Pet Store page site");
        try {
            getDriver().get(envConfig.getBaseUrl());
            Thread.sleep(1000);
            commonActions.clickElement(signInPage.btnSignIn());
            Thread.sleep(300);
            commonActions.clearAndSetText(signInPage.txtUserName(), envConfig.getUserName());
            commonActions.clearAndSetText(signInPage.txtPassword(), envConfig.getPassword());
            Thread.sleep(300);
            commonActions.clickElement(signInPage.btnLogin());
            Thread.sleep(300);
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    @When("I select the Dog item")
    public void iSelectTheDogItem() {
        System.out.println("I select the Dog item");
        try {
            Thread.sleep(1000);
            commonActions.clickElement(homePage.linkDog());
            Thread.sleep(300);
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    @Then("I see the list of Dogs")
    public void iSeeTheListOfDogs() {
        System.out.println("I see the list of Dogs");
        try {
            Thread.sleep(300);
            elem = getDriver().findElement(By.xpath(System.getProperty("DogPage.ReturnToMainMenu.Link")));
            elem.isDisplayed();

        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    @When("I choose a {string} in the list")
    public void iChooseAInTheList(String vAnimal) {
        System.out.println("I choose a "+vAnimal+" in the list");
        try {
            Thread.sleep(300);
            elem = getDriver().findElement(By.xpath(System.getProperty("DogPage.ReturnToMainMenu.Link")));
            elem.isDisplayed();

        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }

    }

    @And("I choose a {string} dog")
    public void iChooseADog(String vGender) {
        System.out.println("I choose a "+vGender+" dog");
        try {
            Thread.sleep(300);
            elem = getDriver().findElement(By.xpath(System.getProperty("DogPage.ReturnToMainMenu.Link")));
            elem.isDisplayed();

        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }
}
