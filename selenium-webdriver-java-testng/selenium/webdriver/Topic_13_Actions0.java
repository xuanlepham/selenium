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
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
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
public class Topic_13_Actions0 {
	WebDriver driver;
	WebDriverWait expliciWait;
	JavascriptExecutor jsExecutor;
	Alert alert;
	Select select;
	String projectPath = System.getProperty("user.dir");
	String authenChromeAutoIt = projectPath + "\\autoit\\authen_chrome.exe";
	String authenFrieFoxAutoIt = projectPath + "\\autoit\\authen_firefox.exe";
	String osName = System.getProperty("os.name");
	Actions action;
	Keys key;
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
//		ChromeOptions chromeoption = new ChromeOptions();
//		chromeoption.addExtensions(new File(projectPath+""));
		driver = new ChromeDriver();
		
		expliciWait = new WebDriverWait(driver, 15);
		jsExecutor = (JavascriptExecutor) driver;
		action = new Actions(driver);
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS );
		
		if(osName.contains("Windows")) {
			key =Keys.CONTROL;
		}else {
			key =Keys.COMMAND;
		}
	}
	
	
	public void TC_03_Click_And_Hold() throws InterruptedException{
		driver.get("https://automationfc.github.io/jquery-selectable/");
		List<WebElement> allNumber= driver.findElements(By.xpath("//ol[@id='selectable']/li"));
//		allNumber.get(0);
		action.clickAndHold(allNumber.get(0))// Click và giữ chuột.
		.moveToElement(allNumber.get(3))// di chuột đến số 4.
		.release()// nhả chuột trái ra.
		.perform(); // thực hiện hành động.
		
		Assert.assertEquals(driver.findElements(By.xpath("//ol[@id='selectable']/li[@class='ui-state-default ui-selectee ui-selected']")).size(), 4);
	}
	
	public void TC_04_Click_And_Hold_Random() throws InterruptedException{
		driver.get("https://automationfc.github.io/jquery-selectable/");
		List<WebElement> allNumber= driver.findElements(By.xpath("//ol[@id='selectable']/li"));
//		allNumber.get(0);
		action.keyDown(Keys.CONTROL).perform();
		action.click(allNumber.get(0)).click(allNumber.get(3)).click(allNumber.get(4)).perform();
		action.keyUp(key).perform();
		
		Assert.assertEquals(driver.findElements(By.xpath("//ol[@id='selectable']/li[@class='ui-state-default ui-selectee ui-selected']")).size(), 3);
	}
	
	public void TC_05_Double_Click() throws InterruptedException {
		driver.get("https://automationfc.github.io/basic-form/index.html");
		jsExecutor.executeScript("arguments[0].scrollIntoView(true)", driver.findElement(By.xpath("//button[@ondblclick='doubleClickMe()']")));
		action.doubleClick(driver.findElement(By.xpath("//button[@ondblclick='doubleClickMe()']"))).perform();
		Thread.sleep(2000);
		Assert.assertEquals(driver.findElement(By.xpath("//p[@id='demo']")).getText(), "Hello Automation Guys!");
	}
	
	public void TC_05_Click_Right() throws InterruptedException{
		driver.get("http://swisnl.github.io/jQuery-contextMenu/demo.html");
		action.contextClick(driver.findElement(By.xpath("//span[@class='context-menu-one btn btn-neutral']"))).perform();
		Thread.sleep(2000);
		action.moveToElement(driver.findElement(By.xpath("//li[@class='context-menu-item context-menu-icon context-menu-icon-delete']"))).perform();
		Thread.sleep(2000);
		
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='context-menu-item context-menu-icon context-menu-icon-delete context-menu-hover context-menu-visible']")).isDisplayed());
		action.click(driver.findElement(By.xpath("//li[@class='context-menu-item context-menu-icon context-menu-icon-delete context-menu-hover context-menu-visible']"))).perform();
		
		driver.switchTo().alert().accept();
		Thread.sleep(3000);
		action.contextClick(driver.findElement(By.xpath("//span[@class='context-menu-one btn btn-neutral']"))).perform();
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='context-menu-item context-menu-icon context-menu-icon-delete']")).isDisplayed());
	}
	
	public void TC_06_Drags_And_Drop() throws InterruptedException{
		driver.get("https://automationfc.github.io/kendo-drag-drop/");
		WebElement smallCircle = driver.findElement(By.xpath("//div[@id='draggable']"));
		WebElement bigCircle = driver.findElement(By.xpath("//div[@id='droptarget']"));
		Assert.assertEquals(bigCircle.getText(),"Drag the small circle here.");
		action.dragAndDrop(smallCircle, bigCircle).perform();
		Thread.sleep(2000);
		Assert.assertEquals(bigCircle.getText(),"You did great!");
	}
	@Test
	public void TC_07_Drags_And_Drop_HTML5() {
		driver.get("https://automationfc.github.io/drag-drop-html5/");
		WebElement squareA =driver.findElement(By.xpath("//div[@id='column-a']"));
		WebElement squareB =driver.findElement(By.xpath("//div[@id='column-b']"));
		action.dragAndDrop(squareA, squareB).perform();
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
