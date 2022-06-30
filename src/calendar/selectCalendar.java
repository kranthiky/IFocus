package calendar;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class selectCalendar {

	public String orangeURL="https://opensource-demo.orangehrmlive.com";
	@Test
	public void selectDate() throws InterruptedException {
	System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\drivers\\chromedriver\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	driver.manage().window().maximize();
	
	driver.get(orangeURL);
	
	WebElement userName =driver.findElement(By.id("txtUsername"));
	WebElement passWord =driver.findElement(By.id("txtPassword"));
	WebElement submitButton =driver.findElement(By.name("Submit"));

	userName.sendKeys("Admin");
	Thread.sleep(2000);	
	passWord.sendKeys("admin123");
	Thread.sleep(2000);	
	submitButton.click();
	Thread.sleep(2000);	
	
	WebElement applyLeave = driver.findElement(By.xpath("(//a[@href='/index.php/leave/applyLeave'])[2]"));
	applyLeave.click();
	Thread.sleep(3000);
	
	WebElement myLeave = driver.findElement(By.xpath("//a[@id='menu_leave_viewMyLeaveList']"));
	myLeave.click();
	Thread.sleep(3000);
	
	WebElement fromCalendar = driver.findElement(By.xpath("//input[@id='calFromDate']"));
	fromCalendar.click();
	
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='ui-datepicker-div']")));
	
	WebElement monthDD = driver.findElement(By.xpath("//select[@class='ui-datepicker-month']"));
	Select month = new Select(monthDD);	
	month.selectByVisibleText("Sep");
	Thread.sleep(2000);
	
	WebElement yearDD = driver.findElement(By.xpath("//select[@class='ui-datepicker-year']"));
	Select year = new Select(yearDD);
	year.selectByVisibleText("1989");
	
	WebElement day  = driver.findElement(By.xpath("//a[text()=28]"));
	day.click();
	Thread.sleep(3000);
	
	
 }
}