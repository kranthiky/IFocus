package Dropdown;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class GenericDrodownNonSelect {

	@Test
	public void nonSelectTag() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Automation Workspace\\Softwares\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://getbootstrap.com/docs/4.0/components/dropdowns/");
		Thread.sleep(3000);
		
		WebElement ddButton = driver.findElement(By.xpath("//button[@id='dropdownMenuButton']"));	
		ddButton.click();
		Thread.sleep(2000);
		
		List<WebElement> ddOptions = driver.findElements(By.xpath("//div[@class='dropdown-menu show']//a"));
		String expValue = "Another action";
		selectingDropdown(ddOptions, expValue);
	}
	public static void selectingDropdown(List<WebElement> elms, String value) {
		
		for(WebElement elm: elms) {
			String elmValue = elm.getText();
			if(elmValue.contentEquals("Another action")) {
				elm.click();
				break;
			}
		}
	}
}
