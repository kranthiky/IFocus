package alerts_windowHandles_frames;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MultipleWindowsClass {

	public static WebDriver driver;
	@Test
	public void handleAlert() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\drivers\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();	
		driver.manage().window().maximize();
	
		driver.get("http://demo.guru99.com/popup.php");
		Thread.sleep(2000);
		
		String parentWindow = driver.getWindowHandle();
		String parentWindowTitle = driver.getTitle();
		System.out.println("Parent window title:"+parentWindowTitle);
		
		driver.findElement(By.xpath("//a[text()='Click Here']")).click();
		Thread.sleep(2000);
		
		Set<String> handles = driver.getWindowHandles();
		
		for(String child:handles) {
			if(!(parentWindow.equals(child))) {
				driver.switchTo().window(child);
				System.out.println(driver.getTitle());
				driver.findElement(By.name("emailid")).sendKeys("kky@gmail.com");
				driver.findElement(By.name("btnLogin")).click();
				Thread.sleep(2000);
				WebElement Actual = driver.findElement(By.xpath("//*[text()='User ID :']"));
				String actualText = Actual.getText();
				Assert.assertEquals(actualText, "User ID :");
				driver.close();
			}
		}
		driver.switchTo().window(parentWindow);
		Assert.assertEquals(driver.getTitle(),parentWindowTitle);
	}
}
