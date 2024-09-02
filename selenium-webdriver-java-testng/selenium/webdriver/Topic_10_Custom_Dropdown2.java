package webdriver;
import java.sql.DriverManager;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.ClickAction;
import org.openqa.selenium.remote.server.handler.FindElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
public class Topic_10_Custom_Dropdown2 {
	WebDriver driver;
	WebDriverWait expliciWait;
	JavascriptExecutor jsExecutor;
	String projectPath = System.getProperty("user.dir");
	String loginPageUrl;
	Select select;
	
	By dropdownparentCategories = By.xpath("//span[@aria-labelledby='categories_label']");
	By dropdownchildCategories= By.xpath("//ul[@id='categories_listbox']/li/span");
	By dropdownparentProducts = By.xpath("//span[@aria-labelledby='products_label']");
	By dropdownchildProducts= By.xpath("//ul[@id='products_listbox']/li/span");
	By dropdownparentOrders = By.xpath("//span[@aria-labelledby='orders_label']");
	By dropdownchildOrders= By.xpath("//ul[@id='orders_listbox']/li/span");

	@BeforeClass
	public void beforeClass() {
	System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
	driver = new ChromeDriver();
	// hàm wait để apply cho các trạng thái element (visibale/invisibale/presence/clickable)
	
	expliciWait = new WebDriverWait(driver, 15);
	jsExecutor = (JavascriptExecutor) driver;
	
	driver.manage().window().maximize();
//	driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//	driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS );
	 
	 
	}
	
	@Test
	public void TC_01_Jquery() throws InterruptedException {
		driver.get("https://demos.telerik.com/kendo-ui/dropdownlist/cascadingdropdownlist");
	

		
		// Chờ cho icon loading biến mất trong vòng 15s
		expliciWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//span[@class='kd-loader']")));
		expliciWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//span[@class='k-icon k-svg-icon k-svg-i-caret-alt-down k-button-icon k-i-loading k-input-loading-icon']")));
		selectItemInDropdown(By.xpath("//span[@aria-labelledby='categories_label']"),By.xpath("//ul[@id='categories_listbox']/li/span"),"Confections");
		
		expliciWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//span[@class='k-icon k-svg-icon k-svg-i-caret-alt-down k-button-icon k-i-loading k-input-loading-icon']")));
		selectItemInDropdown(dropdownparentProducts,dropdownchildProducts,"Chocolade");
	
		expliciWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//span[@class='k-icon k-svg-icon k-svg-i-caret-alt-down k-button-icon k-i-loading k-input-loading-icon']")));
		selectItemInDropdown(dropdownparentOrders,dropdownchildOrders,"Lyon");
	}
	
	@Test
	public void TC_02_ReactJs() throws InterruptedException {
		
		
		
	}
	
	@Test
	public void TC_03_New_Customer() throws InterruptedException {
		
	}
	
	@Test
	public void TC_04_VueJs() throws InterruptedException{
			
		
		
	}
	
	public void selectItemInDropdown(By parentElement , By childElement, String expectedTextItem) {
		expliciWait.until(ExpectedConditions.elementToBeClickable(parentElement)).click();// chờ cho element này được phép click
//		driver.findElement(parentElement).click();// Click vào element cha (Dropdowns)
//		expliciWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(childElement)); // đợu cho tất cả các element xuất hiện ( item của dropdown)
		List<WebElement> allelements =	expliciWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(childElement)); // Lấy ra tất cả các element (item của dropdown)
		System.out.println("All item"+allelements.size());//option
		for (WebElement item : allelements) {
			if(item.getText().equals(expectedTextItem)) {
				if(item.isDisplayed()) { // Nếu item mình chọn nằm trong view thì ấn click 
					item.click();
				}else {
					jsExecutor.executeScript("argument[0].scrollIntoview(true);", item);
					item.click();
					
					
				}
				
			}
		}
		
		
	}
	
	public void senkeytoElement (By by, String value) {
		WebElement element = driver.findElement(by);
		element.clear();
		element.sendKeys(value);
	}
	
	public void clicktoElement (By by) {
		WebElement element = driver.findElement(by);
		element.click();
	}
	
	public boolean isdisplayedElement (By by) {
		WebElement element = driver.findElement(by);
		if(element.isDisplayed()) {
			System.out.println("Text dang duoc hien thi");
			return true;
		}else {
			System.out.println("Text chua duoc hien thi");
			return false;
		}
	}
	public int getRandomNumber() {
		Random rand =new Random();
		return rand.nextInt(999999);
		
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

