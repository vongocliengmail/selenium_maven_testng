package common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ThreadWebDriver {
    private static final ThreadLocal<WebDriver> threadWebDriver=new InheritableThreadLocal<WebDriver>();
    public static WebDriver getDriver(){
        return threadWebDriver.get();
    }
        public static void setDriver(WebDriver driver){
        threadWebDriver.set(driver);
    }
}
