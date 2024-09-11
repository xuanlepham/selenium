package webdriver;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
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
import org.openqa.selenium.interactions.Action;
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
public class Topic_13_Actions1 {
	WebDriver driver;
	WebDriverWait expliciWait;
	JavascriptExecutor jsExecutor;
	Alert alert;
	Select select;
	String projectPath = System.getProperty("user.dir");
	String jsHelperPath = projectPath +"\\dragAndDrop\\drag_and_drop_helper.js";
	Actions action;
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", projectPath +"\\browserDrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		expliciWait = new WebDriverWait(driver, 15);
		jsExecutor = (JavascriptExecutor) driver;
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	
		action = new Actions(driver);
}
	
	public void TC_01_Hover() throws InterruptedException {
//		action.moveToElement(driver.findElement(By.xpath(""))).perform();
		//excute đoạn lệnh
		// realease
		
		driver.get("https://automationfc.github.io/jquery-tooltip/");
		action.moveToElement(driver.findElement(By.xpath("//input[@id='age']"))).perform();
		Thread.sleep(2000);
		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='ui-tooltip-content']")).getText(), "We ask for your age only for statistical purposes.");
	}
	
	public void TC_02_Hover()throws InterruptedException {
		driver.get("http://www.myntra.com/");
		action.moveToElement(driver.findElement(By.xpath("//nav[@class='desktop-navbar']//a[text()='Kids']"))).perform();
		Thread.sleep(2000);
		action.click(driver.findElement(By.xpath("//nav[@class='desktop-navbar']//a[text()='Home & Bath']"))).perform();
		Thread.sleep(2000);
		Assert.assertTrue(driver.findElement(By.xpath("//span[@class='breadcrumbs-crumb']")).isDisplayed());
		
	}
	
	public void TC_03_Click_And_Hold() throws InterruptedException{
		driver.get("https://automationfc.github.io/jquery-selectable/");
		
		List<WebElement> allNumber= driver.findElements(By.xpath("//ol[@id='selectable']/li"));
//		allNumber.get(0);
		action.clickAndHold(allNumber.get(0))// Click và giữ chuột.
		.moveToElement(allNumber.get(3))// di chuột đến số 4.
		.release()// nhả chuột trái ra.
		.perform(); // thực hiện hành động.
	}
	@Test
	public void TC_07_Drags_And_Drop_HTML5() throws IOException ,InterruptedException {
		driver.get("https://automationfc.github.io/drag-drop-html5/");
		String jsHelperFileContent = getContentFile(jsHelperPath);
		String sourceCss ="#column-a"; // khong lam viec duoc voi xpath , chi lam viec voi css
		String targetCss ="#column-b";
		// A to B
		jsHelperFileContent = jsHelperFileContent + "$(\"" + sourceCss + "\").simulateDragDrop({ dropTarget: \"" + targetCss + "\"});";
		jsExecutor.executeScript(jsHelperFileContent);
		Thread.sleep(3000);
		Assert.assertTrue(driver.findElement(By.xpath("//div[@id='column-a']/header[text()='B']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//div[@id='column-b']/header[text()='A']")).isDisplayed());
		// B to A
		jsExecutor.executeScript(jsHelperFileContent);
		Thread.sleep(3000);
		Assert.assertTrue(driver.findElement(By.xpath("//div[@id='column-a']/header[text()='A']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//div[@id='column-b']/header[text()='B']")).isDisplayed());
	}
		
	
	public String getContentFile(String filePath) throws IOException {
		Charset cs = Charset.forName("UTF-8");
		FileInputStream stream = new FileInputStream(filePath);
		try {
			Reader reader = new BufferedReader(new InputStreamReader(stream, cs));
			StringBuilder builder = new StringBuilder();
			char[] buffer = new char[8192];
			int read;
			while ((read = reader.read(buffer, 0, buffer.length)) > 0) {
				builder.append(buffer, 0, read);
			}
			return builder.toString();
		} finally {
			stream.close();
		}
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
		
	}
}


