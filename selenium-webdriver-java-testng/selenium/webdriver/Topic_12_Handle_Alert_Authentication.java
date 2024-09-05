package webdriver;
import java.io.File;
import java.io.IOException;
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
	String authenChromeAutoIt = projectPath + "\\autoit\\authen_chrome.exe";
	String authenFrieFoxAutoIt = projectPath + "\\autoit\\authen_firefox.exe";
	
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
		Assert.assertEquals(driver.findElement(By.xpath("//p[@id='result']")).getText(), "You clicked an alert successfully");
	}
	
	public void TC_02_Alert_Accepct() throws InterruptedException{
		driver.get("https://automationfc.github.io/basic-form/");
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.xpath("//button[contains(text(),'Click for JS Alert')]")));
		clicktoElement("//button[contains(text(),'Click for JS Alert')]");
		Thread.sleep(2000);
		alert = expliciWait.until(ExpectedConditions.alertIsPresent());
		System.out.println(alert.getText());
		Assert.assertEquals(alert.getText(), "I am a JS Alert");
		alert.accept();
		Assert.assertEquals(driver.findElement(By.xpath("//p[@id='result']")).getText(), "You clicked an alert successfully");
		
	}
	
	public void TC_03_Alert_Confirm() throws InterruptedException{
		driver.get("https://automationfc.github.io/basic-form/");
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.xpath("//legend[contains(.,'JavaScript Alerts')]")));
		clicktoElement("//button[contains(text(),'Click for JS Confirm')]");
		Thread.sleep(2000);
		alert = expliciWait.until(ExpectedConditions.alertIsPresent());
		System.out.println(alert.getText());
		Assert.assertEquals(alert.getText(), "I am a JS Confirm");
		alert.accept();
		Assert.assertEquals(driver.findElement(By.xpath("//p[@id='result']")).getText(), "You clicked: Ok");
		
		clicktoElement("//button[contains(text(),'I am a JS Confirm')]");
		Thread.sleep(2000);
		alert = expliciWait.until(ExpectedConditions.alertIsPresent());
		System.out.println(alert.getText());
		Assert.assertEquals(alert.getText(), "I am a JS Confirm");
		alert.dismiss();
		Assert.assertEquals(driver.findElement(By.xpath("//p[@id='result']")).getText(), "You clicked: Cancel");
	}
	
	public void TC_04_Alert_Prompt() throws InterruptedException{
		driver.get("https://automationfc.github.io/basic-form/");
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.xpath("//legend[contains(.,'JavaScript Alerts')]")));
		clicktoElement("//button[contains(text(),'Click for JS Prompt')]");
		Thread.sleep(2000);
		alert = expliciWait.until(ExpectedConditions.alertIsPresent());
		System.out.println(alert.getText());
		Assert.assertEquals(alert.getText(), "I am a JS prompt");
		String hovaten ="Pham Xuan Le";
		alert.sendKeys(hovaten);
		Thread.sleep(5000);
		alert.accept();
	
		Assert.assertEquals(driver.findElement(By.xpath("//p[@id='result']")).getText(), "You entered: " +hovaten);
		clicktoElement("//button[contains(text(),'Click for JS Prompt')]");
		Thread.sleep(2000);
		alert = expliciWait.until(ExpectedConditions.alertIsPresent());
		System.out.println(alert.getText());
		Assert.assertEquals(alert.getText(), "I am a JS prompt");
	
		alert.sendKeys(hovaten);
		Thread.sleep(5000);
		alert.dismiss();
	
		Assert.assertEquals(driver.findElement(By.xpath("//p[@id='result']")).getText(), "You entered: null" );
	
	}
	
	public void TC_04_Alert_Authentication() throws InterruptedException{
		String username ="admin";
		String password ="admin";
		String url ="https://"+ username +":"+ password + "@" + "the-internet.herokuapp.com/basic_auth";
		driver.get(url);
		Thread.sleep(2000);
		Assert.assertEquals(driver.findElement(By.xpath("//p[contains(.,'Congratulations! You must have the proper credentials.')]")).getText(),"Congratulations! You must have the proper credentials." );
		Assert.assertTrue(driver.findElement(By.xpath("//p[contains(.,'Congratulations! You must have the proper credentials.')]")).isDisplayed());
	
	}
	
	public void TC_05_Alert_Authentication_AutoIt() throws InterruptedException, IOException{
		String username ="admin";
		String password ="admin";
		String url ="https://the-internet.herokuapp.com/basic_auth";
		if(driver.toString().contains("chrome")) {
			Runtime.getRuntime().exec(new String[]{ authenChromeAutoIt, username,password});
		}else {
			Runtime.getRuntime().exec(new String[]{ authenFrieFoxAutoIt, username,password});
		}
		
		driver.get(url);
		Thread.sleep(2000);
		
		Assert.assertEquals(driver.findElement(By.xpath("//p[contains(.,'Congratulations! You must have the proper credentials.')]")).getText(),"Congratulations! You must have the proper credentials." );
		Assert.assertTrue(driver.findElement(By.xpath("//p[contains(.,'Congratulations! You must have the proper credentials.')]")).isDisplayed());
	
	}
	@Test
	public void TC_06_Alert_Authentication_AutoIt() throws InterruptedException{
		String username ="admin";
		String password ="admin";
		driver.get("https://the-internet.herokuapp.com");
		String basicAuthenLink = driver.findElement(By.xpath("//a[text()='Basic Auth']")).getAttribute("href");
		driver.get(getLinkByUserPass(basicAuthenLink,username,password));
		Assert.assertEquals(driver.findElement(By.xpath("//p[contains(.,'Congratulations! You must have the proper credentials.')]")).getText(),"Congratulations! You must have the proper credentials." );
		Assert.assertTrue(driver.findElement(By.xpath("//p[contains(.,'Congratulations! You must have the proper credentials.')]")).isDisplayed());
	}
	
	
	private String getLinkByUserPass(String link, String username, String password) {
		String [] links = link.split("//");
		return links[0] + "//" + username + ":" + password + "@" + links[1];
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
