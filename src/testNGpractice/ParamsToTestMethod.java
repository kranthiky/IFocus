package testNGpractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParamsToTestMethod {

	public WebDriver driver;
//	public String URL ="https://www.facebook.com";
	
	@BeforeSuite
	public void bforeSuit() {
		System.out.println("Before suite");
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\drivers\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();		
	}
	@BeforeTest
	public void bforeTest() {
		System.out.println("Before Test");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}	
	
	@Parameters({"URL"})
	@BeforeClass
	public void bforeClass(String url) {
		System.out.println("Before Class");
		driver.get(url);
	}
	@BeforeMethod
	public void bfrEveryMethod() {
		System.out.println("Before Method");
		String expHomeTitle ="Facebook � log in or sign up";
		try {
			Assert.assertEquals(driver.getTitle(), expHomeTitle);
		} catch(Exception e) {
			e.getMessage();
		}
		
	}
	@Parameters({"userName","password"})
	@Test(priority=1,description = "Login to Application") 
	public void loginToApp(String userName,String password) throws InterruptedException {
		System.out.println("Test1: login");
		WebElement uName = driver.findElement(By.id("email"));
		WebElement pWord = driver.findElement(By.id("pass"));
		WebElement loginButton = driver.findElement(By.xpath("//button[contains(@id,'u_0')]"));
		
		uName.sendKeys(userName);
		Thread.sleep(2000);
		pWord.sendKeys(password);
		Thread.sleep(2000);
		loginButton.click();
		Thread.sleep(2000);
	}
	@Test(priority=2, description = "Navigate to forgotten password") 
	public void navigatoToForgot() throws InterruptedException {
		System.out.println("Test2: forgot password");
		WebElement forgotLink = driver.findElement(By.xpath("//a[text()='Forgotten password?']"));
		forgotLink.click();
		Thread.sleep(2000);
	}
	@Parameters({"URL"})
	@AfterMethod
	public void aftrMethod(String url) throws InterruptedException {
		System.out.println("After Method");
		driver.navigate().to(url);
		Thread.sleep(2000);
	}
	@AfterClass
	public void aftrClass() {
		System.out.println("After Class");
		driver.close();
	}
	@AfterTest
	public void aftrTest() {
		System.out.println("After Test");
		driver.quit();
	}
	@AfterSuite
	public void aftrSuit() {
		System.out.println("After Suite");
		System.out.println("Test suite is executed..!");
	}
}
