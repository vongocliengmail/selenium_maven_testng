package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pageobjects.HomePage;
import pageobjects.SignInPage;
import utilities.EnvironmentConfiguration;
import utilities.actions.CommonActions;
import utilities.actions.ValidationActions;
import static common.ThreadWebDriver.*;

public class SignInSteps {
    private static WebDriver driver;
    WebDriverWait wait;
    private WebElement elem = null;
    private EnvironmentConfiguration envConfig = new EnvironmentConfiguration(System.getProperty("env"));
    CommonActions commonActions =new CommonActions();
    ValidationActions validationActions = new ValidationActions();
    SignInPage signInPage = new SignInPage();
    HomePage homePage =new HomePage();

    @Given("I am accessed in to the Pet Store page site")
    public void iAmAccessedInToThePetStorePageSite() {
        System.out.println("I am accessed in to the Pet Store page site");
        try {
            getDriver().get(envConfig.getBaseUrl());
            Thread.sleep(300);
            commonActions.clickElement(signInPage.btnSignIn());
            Thread.sleep(300);
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }
    @When("I enter user name and password")
    public void i_enter_user_name_and_password() {
        System.out.println("I enter user name and password");
        try {
            Thread.sleep(300);
            commonActions.clearAndSetText(signInPage.txtUserName(),envConfig.getUserName());
            commonActions.clearAndSetText(signInPage.txtPassword(),envConfig.getPassword());
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @And("I click Login In button")
    public void i_click_login_in_button() {
        System.out.println("I click Login In button");
        try {
            Thread.sleep(300);
            commonActions.clickElement(signInPage.btnLogin());
            Thread.sleep(300);
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    @Then("I see user signed in the home page")
    public void i_see_user_signed_in_the_home_page() {
        System.out.println("I see user signed in the home page");
        try {
            Thread.sleep(300);
            validationActions.isElementPresent(homePage.linkSignOut());
            System.out.println(validationActions.isElementPresent(homePage.linkSignOut()));
            Thread.sleep(300);
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }


}
