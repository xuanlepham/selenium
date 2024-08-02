package PageLoadHelper;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageLoadHelper {
	public static void waitForPageLoad(WebDriver driver) {
        new WebDriverWait(driver, 30).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver wd) {
                return ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete");
            }
        });
    }
}
