package common;

import java.time.Duration;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.EnvironmentConfiguration;
import utilities.PropertyFile;

public class DriverFunction {
    private static WebDriver driver;
    ChromeOptions chromeOptions = new ChromeOptions();
    private EnvironmentConfiguration envConfig = new EnvironmentConfiguration(System.getProperty("env"));
    String browserName;

    @Before
    public void setUp() throws Throwable {
        browserName = envConfig.getBrowserName();
        PropertyFile.loadPropertiesFile("src/test/resources/objects/PageObjects.properties");
        switch (browserName) {
            case "firefox":
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver(firefoxOptions);
                ThreadWebDriver.setDriver(driver);
                DriverFunction.driver = ThreadWebDriver.getDriver();

                break;
            case "chrome":
                chromeOptions = new ChromeOptions();
                System.out.println(System.getProperty("os.name"));
                if (System.getProperty("os.name").toLowerCase().contains("windows")) {
                    Map<String, Object> prefs = new HashMap<String, Object>();
                    prefs.put("credentials_enable_service", false);
                    prefs.put("profile.password_manager_enabled", false);
                    chromeOptions.setExperimentalOption("prefs", prefs);
                    chromeOptions.setExperimentalOption("useAutomationExtension", false);
                    chromeOptions.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
                    chromeOptions.addArguments("chrome.switches", "--disable-extensions");
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver(chromeOptions);
                    ThreadWebDriver.setDriver(driver);
                    DriverFunction.driver = ThreadWebDriver.getDriver();
                }
                break;
        }
        if (driver != null) {
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        }
    }

    public WebDriver getDriver() {
        return driver;
    }

    @After
    public void tearDown() throws InterruptedException {
        try {
            driver.quit();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());

        }

    }
}
