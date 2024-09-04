package webdriver;
import java.io.File;
import java.sql.DriverManager;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.ClickAction;
import org.openqa.selenium.remote.server.handler.FindElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
public class Topic_12_Handle_Alert_Authentication {
	WebDriver driver;
	WebDriverWait expliciWait;
	JavascriptExecutor jsExecutor;
	Alert alert;
	Select select;
	String projectPath = System.getProperty("user.dir");
	
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
//		ChromeOptions chromeoption = new ChromeOptions();
//		chromeoption.addExtensions(new File(projectPath+""));
		driver = new ChromeDriver();
		
		expliciWait = new WebDriverWait(driver, 15);
		jsExecutor = (JavascriptExecutor) driver;
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS );
	}
	@Test
	public void TC_01_Alert_Acept() throws InterruptedException {
		driver.get("https://demo.guru99.com/v4/index.php");
		clicktoElement("//input[@name='btnLogin']");
		Thread.sleep(2000);
		//swtichto; Alert/ Windows / Tab/ Frame/
		alert = expliciWait.until(ExpectedConditions.alertIsPresent());
		
//		alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		Assert.assertEquals(alert.getText(), "User or Password is not valid");
		
		alert.accept();
		
	
	
	}
	
	
	
	
	public void clicktoElement (String xpath) {
		WebElement element = driver.findElement(By.xpath(xpath));
		element.click();
	}
	
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
