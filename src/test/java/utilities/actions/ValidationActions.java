package utilities.actions;

import java.time.Duration;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.logging.log4j.Logger;

import utilities.ExceptionMsg;

import static common.ThreadWebDriver.getDriver;
import static org.apache.logging.log4j.LogManager.getLogger;
import static org.apache.logging.log4j.Logger.*;

public class ValidationActions {
    private static Logger logger = getLogger("UtilityActions.class");
    int timeoutLong = Integer.parseInt(System.getProperty("gSetting.LongLoading"));
    int timeoutShort = Integer.parseInt(System.getProperty("gSetting.ShortLoading"));

    /*
     * Method to check if an elem is present or not.
     * @param driver
     * @param locator
     * @return true - if elem is displayed or False - if elem is not displayed
     */
    public boolean isElementPresent(String elemLocator) {
        WebElement elem = null;
        try {
            elem = getDriver().findElement(By.xpath(elemLocator));
            if (elem != null) {
                return true;
            }
        } catch (Exception e) {
            return false;
        }
        return false;
    }


    /* Wait for presence of elem till the specified time out time
     * @param driver
     * @param elementValue
     * @param timeout
     * @return boolean value whether elem is present or not
     */
    public boolean waitForElementPresent(WebDriver driver, String elemLocator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutShort));
        try {
            WebElement elem =wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(elemLocator)));
            if (elem != null)
                return true;
        } catch (Exception e) {
            logger.info(e);
            return false;
        }
        return false;
    }

    /*
     * An expectation for checking that an elem, known to be present on the page is visible.
     * @param driver
     * @param elemLocator
     * @return elem
    */
    public WebElement waitForElementVisible(WebDriver driver, String elemLocator) throws ExceptionMsg {
        WebElement elem = null;
        try {
            elem = driver.findElement(By.xpath(elemLocator));
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutShort));
            try {
                wait.until(ExpectedConditions.visibilityOf(elem)) ;
            }catch (Exception e) {
                logger.info(e);
            }

        } catch (Exception e) {
            throw new ExceptionMsg(
                    "Element value " + elem + " is not accessible at this moment" + e.getMessage());
        }
        return elem;
    }
    /*
     * An expectation for checking that an elem, known to be present on the page is clickable.
     * @param driver
     * @param elementValue
     * @param timeout
     * @return
     * @throws ExceptionMsg
     */
    public WebElement waitForElementToBeClickable(WebDriver driver, String elemLocator) throws ExceptionMsg {
        WebElement elem = null;
        try {
            elem = driver.findElement(By.xpath(elemLocator));
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutShort));
            try {
                wait.until(ExpectedConditions.elementToBeClickable(elem));
            } catch (Exception e) {
                logger.info("Error for elem to be clickable" + elemLocator + " " + e.getMessage());
            }

        } catch (Exception e) {
            throw new ExceptionMsg("Element value is:" + elem + " so not accessible at this moment");
        }
        return elem;
    }

}
