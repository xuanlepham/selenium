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
public class Topic_10_Custom_Dropdown3 {
	WebDriver driver;
	WebDriverWait expliciWait;
	JavascriptExecutor jsExecutor;
	String projectPath = System.getProperty("user.dir");
	String loginPageUrl;
	Select select;
	
	

	@BeforeClass
	public void beforeClass() {
	System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
	driver = new ChromeDriver();
	// hàm wait để apply cho các trạng thái element (visibale/invisibale/presence/clickable)
	
	expliciWait = new WebDriverWait(driver, 15);
	jsExecutor = (JavascriptExecutor) driver;
	
	driver.manage().window().maximize();
//	driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS );
	

	 
	 
	}
	
	@Test
	public void TC_01_Jquery() throws InterruptedException {
		
		
		driver.get("https://multiple-select.wenzhixin.net.cn/templates/template.html?v=189&url=basic.html");
		String [] fristmonth = {"January","May","November"};
		String [] secondmonth = {"January","May","November"};
//		driver.findElement(By.xpath("(//button[@class='ms-choice'])[1]")).click();
		
		selectMutilitemInDropdown("(//button[@class='ms-choice'])[1]","(//button[@class='ms-choice'])[1]/following-sibling::div/ul//span",fristmonth);
		
		
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
	
	public void selectItemEditableInDropdown(By parentElement , By childElement, String expectedTextItem) {// hàm dành cho dropdown có input
		driver.findElement(parentElement).clear();
		driver.findElement(parentElement).sendKeys(expectedTextItem);
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
				break;
			}
		}
		
		
	}
	public void selectMutilitemInDropdown(String parentElementX,String childElementX,String[] expectedValueItem ) {
		driver.findElement(By.xpath(parentElementX)).click();
		expliciWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(childElementX)));
		List <WebElement> allitems =driver.findElements(By.xpath(childElementX));
		
		for (WebElement childElement : allitems) { // Duyệt qua tất cả phần tử khi thỏa mãn điều kiện
			for(String item : expectedValueItem ) {
			if(childElement.getText().equals(item)) {
				jsExecutor.executeScript("arguments[0].scrollIntoView(true);", childElement);
				sleepInSecond(1);
				childElement.click();
				sleepInSecond(1);
				
				List <WebElement> itemSelected =driver.findElements(By.xpath("//li[@class='selected']"));
				System.out.println("item Selected="+itemSelected.size());
				if(expectedValueItem.length==itemSelected.size()) {
					break;
				}
				
				
		}
			}
			}
		
		
		
	}
	
	
	
	private void sleepInSecond(int i) {
		// TODO Auto-generated method stub
		
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
//			System.out.println("Text dang duoc hien thi");
			return true;
		}else {
//			System.out.println("Text chua duoc hien thi");
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
//		driver.quit();
	}
	
}

