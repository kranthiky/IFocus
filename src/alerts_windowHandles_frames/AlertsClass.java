package alerts_windowHandles_frames;

import java.awt.AWTException;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.Test;



public class AlertsClass {

	public static WebDriver driver;
	@Test
	public void handleAlert() throws InterruptedException, IOException {
//		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\drivers\\chromedriver\\chromedriver.exe");
//		driver = new ChromeDriver();	
//		driver.manage().window().maximize();
//	
//		driver.get("http://demo.guru99.com/test/delete_customer.php");
//		Thread.sleep(2000);
//		driver.findElement(By.name("cusid")).sendKeys("2345");
//		Thread.sleep(2000);
//		driver.findElement(By.name("submit")).click();
//		//launch Alert
//		System.out.println("Alert:"+driver.switchTo().alert().getText());
//		driver.switchTo().alert().dismiss(); //Dismiss alert
//		Thread.sleep(2000);
//		driver.findElement(By.name("submit")).click();
//		driver.switchTo().alert().accept(); //Accept alertq
//		Thread.sleep(3000);
////		driver.switchTo().alert().accept(); //Accept alert on successful action
////		Scanner scan = new Scanner(System.in);
////		int var = scan.nextInt();
////		String str = scan.nextLine();
		Runtime.getRuntime().exec("notepad");
		
	
		try {
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_Q); 
		    robot.keyRelease(KeyEvent.VK_Q); 
		} catch (AWTException e) {
			e.printStackTrace();
		} 
	     WebDriver driver = new ChromeDriver();
		Actions act = new Actions(driver);
	//	driver.manage().timeouts().implicitlyWait(Duration.ofHours(10));
		FluentWait wait= new FluentWait(driver);
		wait.withTimeout(Duration.ofSeconds(10))
		    .pollingEvery(Duration.ofSeconds(1))
		    .ignoring(NoSuchElementException.class);
	    
		wait.until(ExpectedConditions.alertIsPresent());
	}
}
