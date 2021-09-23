package alerts_windowHandles_frames;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


public class FramesClass {
	
	public static WebDriver driver;
	
	@Test 
	public void testFrames() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\drivers\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();	
		driver.manage().window().maximize();
		driver.get("https://ui.vision/demo/iframes");
		
		int countOfFrames = driver.findElements(By.tagName("iFrame")).size();
		System.out.println(countOfFrames);
		
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//div//span[text()='I am a human']")).click();
		Thread.sleep(3000);
		
		driver.switchTo().parentFrame();// for moving back to Parent frame
		driver.switchTo().frame(0);  //switch to first frame
		int size = driver.findElements(By.tagName("iFrame")).size(); // once moving inside frame, get no.of frames inside(nested)
		//find element and click desired element or any action.
		driver.switchTo().defaultContent();// to move back to most Parent frame
		
	}
	
	
}
