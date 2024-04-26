package utilities.actions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static common.ThreadWebDriver.*;
public class CommonActions {

    /*
     * enter the Text on the Field after the clearing the same.
     * @param elemLocator
     * @param inputValue
     */
    public void clearAndSetText(String elemLocator, String inputValue) {
        WebElement elem = null;
        try {
            elem = getDriver().findElement(By.xpath(elemLocator));
            elem.clear();
            elem.sendKeys(inputValue);
        } catch (Exception e) {
            e.getMessage();
        }
    }
    /*
     * enter the Text on the Field after the clearing the same.
     * @param elemLocator
     * @param inputValue
     */
    public void clickElement(String elemLocator) {
        WebElement elem = null;
        try {
            elem = getDriver().findElement(By.xpath(elemLocator));
            elem.click();
        } catch (Exception e) {
            e.getMessage();
        }
    }

    /*
     * enter the Text on the Field.
     * @param elemLocator
     * @param inputValue
     */
    public void setText(String elemLocator, String inputValue) {
        WebElement elem = null;
        try {
            elem = getDriver().findElement(By.xpath(elemLocator));
            elem.sendKeys(inputValue);
        } catch (Exception e) {
            e.getMessage();
        }
    }
    /*
     * enter the Text on the Field.
     * @param elemLocator
     * @param inputValue
     */
    public String getText(String elemLocator) {
        WebElement elem = null;
        String getElemText="";
        try {
            elem = getDriver().findElement(By.xpath(elemLocator));
            getElemText=elem.getText();
        } catch (Exception e) {
            e.getMessage();
        }
        return getElemText;
    }
}
