package setPackage;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SetWindowHandles {

	@Test
	public void setWindows() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\drivers\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://naukri.com");

		//Get parent window handle
		String parentWindow = driver.getWindowHandle();
		System.out.println("Parent window handle:"+parentWindow);
		String parentWindowTitle = driver.getTitle();
		System.out.println("Parent window title:"+parentWindowTitle);
		
		//Get all window handles
		Set<String> allWindowHandles = driver.getWindowHandles();
		System.out.println("All window handles:"+allWindowHandles);
		
		//Iterate and switch to child windows and then close all
		for(String childWindow:allWindowHandles) {
			if(!(parentWindow.equals(childWindow))){
				driver.switchTo().window(childWindow);
				System.out.println("Child window title:"+driver.getTitle());
				driver.close();
				Thread.sleep(3000);
			}			
		}
		//switch to parent window and continue..
		driver.switchTo().window(parentWindow);
		Assert.assertEquals(parentWindowTitle, driver.getTitle(),"this window is NOT parent window- pls check..!");
	}
}
