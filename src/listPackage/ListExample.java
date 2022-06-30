package listPackage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ListExample {

	@Test
	public void nonSelectTag() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\drivers\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://getbootstrap.com/docs/4.0/components/dropdowns/");
		Thread.sleep(3000);
		
		WebElement ddButton = driver.findElement(By.xpath("//button[@id='dropdownMenuButton']"));
		ddButton.click();
		Thread.sleep(2000);
		// Store list of WebElements
		List<WebElement> ddOptions = driver.findElements(By.xpath("//div[@class='dropdown-menu show']//a"));
		
		//Print list
		System.out.println("Bootstrap dropdown options are: ");
		// Iterate the list
		for(WebElement elm: ddOptions) {
			String Acts = elm.getText();
			System.out.println(Acts);
			if(Acts.contentEquals("Another action")) {
				System.out.println("Condition matched..!");
				elm.click();
				break;
			}
		}
		
	}
}
