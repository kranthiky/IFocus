package Dropdown;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class NonSelectDD {

	@Test
	public void nonSelectTag() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Automation Workspace\\Softwares\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://getbootstrap.com/docs/4.0/components/dropdowns/");
		Thread.sleep(3000);
		
		WebElement ddButton = driver.findElement(By.xpath("//button[@id='dropdownMenuButton']"));
	//	JavascriptExecutor js = (JavascriptExecutor)driver;
	//	js.executeScript("arguments[0].scrollIntoView();", ddButton);
		ddButton.click();
		Thread.sleep(2000);
		List<WebElement> ddOptions = driver.findElements(By.xpath("//div[@class='dropdown-menu show']//a"));
		
		System.out.println("Bootstrap dropdown options are: ");
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
