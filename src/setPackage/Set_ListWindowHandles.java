package setPackage;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Set_ListWindowHandles {

	@Test
	public void setWindows() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\drivers\\chromedriver\\chromedriver.exe");
		//System.out.println(System.getProperty("user.dir"));
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://naukri.com");

		//Get parent window handle
		String parentWindow = driver.getWindowHandle();
		String parentWindowTitle = driver.getTitle();
		
		//Get all window handles
		Set<String> allWindowHandles = driver.getWindowHandles();
		
		ArrayList<String> listAllWindows = new ArrayList<String>(allWindowHandles);

		//Swtich to 2nd window using List index
		driver.switchTo().window(listAllWindows.get(1));
		System.out.println(driver.getTitle());
	//	driver.close();
		
		//Iterate and switch to child windows and then close all
		for(String childWindow:listAllWindows) {
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
