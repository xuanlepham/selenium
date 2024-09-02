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
public class Topic_10_Custom_Dropdown {
	WebDriver driver;
	WebDriverWait expliciWait;
	JavascriptExecutor jsExecutor;
	String projectPath = System.getProperty("user.dir");
	String loginPage = "";
	String loginPageUrl;
	String fristname,lastname,email,password,confrimpassword,day,month,year,country;
	Select select;
	
	By dropdownSelectNumber = By.xpath("//span[@id='number-button']");
	By childSelectNumber = By.xpath("//ul[@id='number-menu']/li/div");
	
	

	@BeforeClass
	public void beforeClass() {
	System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
	driver = new ChromeDriver();
	// hàm wait để apply cho các trạng thái element (visibale/invisibale/presence/clickable)
	
	expliciWait = new WebDriverWait(driver, 15);
	jsExecutor = (JavascriptExecutor) driver;
	
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS );
	 
	 
	}
	
	@Test
	public void TC_01_Jquery() throws InterruptedException {
		
		driver.get("https://multiple-select.wenzhixin.net.cn/templates/template.html?v=189&url=basic.html");
		String [] fristmonth = {"January","May","November"};
		String [] secondmonth = {"January","May","November"};
//		driver.findElement(By.xpath("(//button[@class='ms-choice'])[1]")).click();
		
		selectMutilitemInDropdown("(//button[@class='ms-choice'])[1]","(//button[@class='ms-choice'])[1]/following-sibling::div/ul//span",fristmonth);
//		// 1.Click vào 1 element cho nó xổ ra các item bên trong
//		// 2.Chờ cho tất cả các item được load lên
//		// 3.Nếu item cần chọn nó nằm trong vùng view thì click vào
//		// 4.Nếu như item mình cần chọn không thấy thì scroll xuống và click vào
//		driver.get("http://jqueryui.com/resources/demos/selectmenu/default.html");
//		// 1.Click vào 1 element cho nó xổ ra các item bên trong
//		driver.findElement(By.xpath("//span[@id='number-button']")).click();
//		// 2.Wait cho tất cả element  được load ra (có trong html/dom)
//		// presence
//		expliciWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("ul#number-menu >li>div")));
////		expliciWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//ul[@id='number-menu']/li/div")));
//		List<WebElement> allelements =	driver.findElements(By.cssSelector("ul#number-menu >li>div"));
//		System.out.println("All item"+allelements.size());
//		
//		for (WebElement item : allelements) {
//			if(item.getText().equals("19")) {
//				if(item.isDisplayed()) { // Nếu item mình chọn nằm trong view thì ấn click 
//					item.click();
//				}else {
//					jsExecutor.executeScript("argument[0].scrollIntoview(true);", item);
//					item.click();
//				}
//				
//			}
//		}
//	
//		
//		// 3.Nếu item cần chọn nó nằm trong vùng view thì click vào
		
		
	}
	
	@Test
	public void TC_02_ReactJs() throws InterruptedException {
		driver.get("http://jqueryui.com/resources/demos/selectmenu/default.html");
		
		selectItemInDropdown(dropdownSelectNumber, childSelectNumber, "10");
		Assert.assertTrue(isdisplayedElement(By.xpath("//span[@id='number-button']/span[@class='ui-selectmenu-text' and text()='10']")));
		Thread.sleep(3000);
		selectItemInDropdown(dropdownSelectNumber, childSelectNumber, "5");
		Assert.assertTrue(isdisplayedElement(By.xpath("//span[@id='number-button']/span[@class='ui-selectmenu-text' and text()='5']")));
		Thread.sleep(3000);
		selectItemInDropdown(dropdownSelectNumber, childSelectNumber, "18");
		Assert.assertTrue(isdisplayedElement(By.xpath("//span[@id='number-button']/span[@class='ui-selectmenu-text' and text()='18']")));
	}
	
	@Test
	public void TC_03_New_Customer() throws InterruptedException {
		driver.get("https://react.semantic-ui.com/maximize/dropdown-example-selection/");
		By parentElement = By.xpath("//i[@class='dropdown icon']");
		By childElement =By.xpath("//div[@role='option']/span");
		
		selectItemInDropdown(parentElement,childElement,"Stevie Feliciano");
		Thread.sleep(3000);
		Assert.assertTrue(isdisplayedElement(By.xpath("//div[@role='alert' and text()='Stevie Feliciano']")));
		
		selectItemInDropdown(parentElement,childElement,"Justen Kitsune");
		Thread.sleep(3000);
		Assert.assertTrue(isdisplayedElement(By.xpath("//div[@role='alert' and text()='Justen Kitsune']")));
		
		
		selectItemInDropdown(parentElement,childElement,"Matt");
		Thread.sleep(3000);
		Assert.assertTrue(isdisplayedElement(By.xpath("//div[@role='alert' and text()='Matt']")));
	}
	
	@Test
	public void TC_04_VueJs() throws InterruptedException{
		driver.get("https://mikerodham.github.io/vue-dropdowns/");
		
		By parentElement = By.xpath("//span[@class='caret']");
		By childElement =By.xpath("//ul[@class='dropdown-menu']/li/a");
		
		selectItemInDropdown(parentElement,childElement,"Stevie Feliciano");
		Thread.sleep(3000);
		Assert.assertTrue(isdisplayedElement(By.xpath("")));
		
		selectItemInDropdown(parentElement,childElement,"Justen Kitsune");
		Thread.sleep(3000);
		Assert.assertTrue(isdisplayedElement(By.xpath("")));
		
		
		selectItemInDropdown(parentElement,childElement,"Matt");
		Thread.sleep(3000);
		Assert.assertTrue(isdisplayedElement(By.xpath("")));
		
		
	}
	
	public void selectItemInDropdown(By parentElement , By childElement, String expectedTextItem) {
		driver.findElement(parentElement).click();// Click vào element cha (Dropdowns)
		expliciWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(childElement)); // đợu cho tất cả các element xuất hiện ( item của dropdown)
		List<WebElement> allelements =	driver.findElements(childElement); // Lấy ra tất cả các element (item của dropdown)
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
	public void sleepInSecond(int i) {
		// TODO Auto-generated method stub
		
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

