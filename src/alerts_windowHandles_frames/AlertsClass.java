package alerts_windowHandles_frames;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class AlertsClass {

	public static WebDriver driver;
	@Test
	public void handleAlert() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\drivers\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();	
		driver.manage().window().maximize();
	
		driver.get("http://demo.guru99.com/test/delete_customer.php");
		Thread.sleep(2000);
		driver.findElement(By.name("cusid")).sendKeys("2345");
		Thread.sleep(2000);
		driver.findElement(By.name("submit")).click();
		//launch Alert
		System.out.println("Alert:"+driver.switchTo().alert().getText());
		driver.switchTo().alert().dismiss(); //Dismiss alert
		Thread.sleep(2000);
		driver.findElement(By.name("submit")).click();
		driver.switchTo().alert().accept(); //Accept alert
		Thread.sleep(2000);
		driver.switchTo().alert().accept(); //Accept alert on successful action
	}
}
