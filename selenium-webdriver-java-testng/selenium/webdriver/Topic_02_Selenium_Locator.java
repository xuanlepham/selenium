package webdriver;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.ClickAction;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
public class Topic_02_Selenium_Locator {
	
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get("https://www.demo.guru99.com/");
	}
	@Test
	public void TC_01_xpath() {
		driver.findElement(By.xpath("//input[@name='emailid']")).click();
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//label[contains(text(),'Email ID must not be blank')]")).isDisplayed());
		 
	}
	@Test
	public void TC_04_Name() {
		driver.navigate().refresh();
		driver.findElement(By.name("emailid")).click();
		Assert.assertTrue(driver.findElement(By.name("emailid")).isDisplayed());
	}
	@Test
	public void TC_05_Tagname() {
		driver.navigate().refresh();
	}
	@Test
	public void TC_06_Linktext() {
		
	}
	@Test
	public void TC_07_PartialLinktext() {
		
	}
	@Test
	public void TC_08_CSS() {
		
	}
	@Test
	public void TC_09_xpath() {
		
	}
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
