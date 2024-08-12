package webdriver;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.ClickAction;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
public class Topic_07_Browser_Element4 {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	
	@BeforeClass
	public void beforeClass() {
	System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
	driver = new ChromeDriver();
	 driver.manage().window().maximize();
	 driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	 driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS );
	 
	 
	}
	
	 @Test
	 public void TC_01_Element() {
		 driver.get("https://login.mailchimp.com/signup/");
		 
		 WebElement businessemail = driver.findElement(By.xpath("//input[@id='email']"));
		 businessemail.sendKeys("phamxuanle833@gmail.com");
		 
//		 WebElement username = driver.findElement(By.xpath("//input[@id='new_username']"));
//		 username.sendKeys("phamxuanle");
		 
		 // Lowcase
		 WebElement password = driver.findElement(By.xpath("//input[@id='new_password']"));
		 password.sendKeys("111");
		 
//		 WebElement buttonPassword = driver.findElement(By.xpath("//button[@id='create-account-enabled']"));
//		 buttonPassword.click();
		 // Uppercase
		 Assert.assertFalse(isValidationRulePassed(driver, "//span[contains(text(),'One lowercase character')]"));
		 
		 // Number
		 
		 // Speical
		 
		 // >=8 character
		 
		 // Full valid data
		 
	 }
	 public static boolean isValidationRulePassed (WebDriver driver, String ruleSelector) {
		 WebElement ruleElement =driver.findElement(By.xpath(ruleSelector));
		 String color = ruleElement.getCssValue("color");
		 String hexColor = Color.fromString(color).asHex();
		if(color.equals("#008547")) {
			return true;
		}
		return false;
	 }
	
	 @AfterClass
	 public void afterClass() {
		 try {
			    Thread.sleep(5000); 
			} catch (InterruptedException e) {
			    e.printStackTrace();
			}
		 driver.quit();
	 }
}
