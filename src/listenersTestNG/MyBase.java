package listenersTestNG;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class MyBase {

	public static WebDriver driver;
	
	public static void browserInitialization() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/");			
	}
	
	public static void captureScreenshot(String testName) throws IOException {
		
		TakesScreenshot scrShot = (TakesScreenshot)driver;
		File src = scrShot.getScreenshotAs(OutputType.FILE);
		String destPath = "./Screenshots/"+testName+dateFormat()+".png";
		File destn = new File(destPath);
		FileHandler.copy(src, destn);
	}

	public static String dateFormat() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd_MM_yyyy HH_mm_ss");
		LocalDateTime now = LocalDateTime.now();
		return dtf.format(now);
	}	
}
