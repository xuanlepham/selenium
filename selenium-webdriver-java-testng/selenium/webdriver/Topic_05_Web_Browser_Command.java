package webdriver;
import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.ClickAction;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
public class Topic_05_Web_Browser_Command {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//		driver.get("https://www.demo.guru99.com/");
	}
	@Test
	public void TC_01_Browser() {
		// Mở ra page URL.
		driver.get("https://www.demo.guru99.com/");		//*
		
		// Đóng 1 tab đang active.
		driver.close();		//*
		
		// Đóng trình duyệt.
		// Bài Handle window/Tab.
		driver.quit();		//*
		
		// Lấy ra ID hiện tại của Window/tab đang active.
		// Sử dụng dữ liệu thao tác ở 1 step bên dưới -> Lưu trữ nó vào 1 data type.
		// Trả về kiểu dữ liệu gì thì khai báo biến dùng kiểu dữ liệu đó.
		String messengerID = driver.getWindowHandle();
		
		// Lấy ra tất cả các ID của Window/tab đang có ( lấy hết ).
		Set<String> allIDs = driver.getWindowHandles();
		
		// Chuyển đến một Window/Tab nào đó.
		driver.switchTo().window(messengerID);		//*
		
		// Tìm ra một element với locator nào đó.
		WebElement phoneTexbox = driver.findElement(By.id(""));		//*
		
		// Tìm ra tất cả elements với locator nào đó. 
		List<WebElement> phones = driver.findElements(By.id(""));	//*
		
		// Trả về URL page hiện tại.
		// Trong java tên biến,hàm sẽ được khai báo kiểu camelCase.
		// Tên Class được định nghĩa bằng các tiêu chuẩn (Pascal Case).
		String homePageUrl = driver.getCurrentUrl();	//*
		
		// Trả về HTML source của page hiện tại.
		String homePageSource = driver.getPageSource();
		
		// Trả về title của Page hiện tại.
		String homePageTittle = driver.getTitle();
		
		// Get/xóa cookie của page.
		// Build framework:Share state of Class.
		// Get cookie sau khi login xong -> truyền vào các Class khác -> Reduce time login cho từng Class.
		driver.manage().deleteAllCookies();
		
		// Build framework: Get ra log của browser.
		driver.manage().logs().getAvailableLogTypes();
		
		// 1000ms = 1s .
		// Chờ cho tìm element (findElement/findElements).
		// WebDriver Wait.
		driver.manage().timeouts().implicitlyWait(150000,TimeUnit.MICROSECONDS);
		driver.manage().timeouts().implicitlyWait(15000,TimeUnit.MILLISECONDS);
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(1,TimeUnit.MINUTES);
		
		// Chờ cho 1 page được load thành công (Option).
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);	//*
		
		// Chờ cho 1 script được excute thành công (Option).
		// JavascriptExecutor.
		driver.manage().timeouts().setScriptTimeout(15, TimeUnit.SECONDS);
		
		// Mở Browser full màn hình.
		driver.manage().window().fullscreen();
		
		// Mở Browser max màn hình.
		driver.manage().window().maximize();	//*
		
		// Lấy ra vị trí hiển tại của browser.
		driver.manage().window().getPosition();
		
		// Set vào cho Browser tại vị trí nào đó .
		driver.manage().window().setPosition(new Point(0,0));
		
		// Lấy ra kích thước hiện tại của browser(rộng/cao).
		driver.manage().window().getSize();
		driver.manage().window().setSize(new Dimension(1920,1080));
		
		// Back to page.
		driver.navigate().back();
		
		// Forward to page.
		driver.navigate().forward();
		
		// Tải lại page.
		driver.navigate().refresh();
		
		// Keep history.
		driver.navigate().to("https://www.demo.guru99.com/");
		
		// Window/Tab
		// Alert
		// Frame/iframe
		driver.switchTo().window("");	//*
		driver.switchTo().frame("");	//*
		driver.switchTo().alert();	//*
		
		}
}
