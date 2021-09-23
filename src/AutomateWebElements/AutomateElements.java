package AutomateWebElements;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AutomateElements {

	public static void main(String[] args) throws InterruptedException {
		
		
		System.setProperty("webdriver.chrome.driver", "C:\\Automation Workspace\\Softwares\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, 20);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		driver.manage().window().maximize();
		driver.get("https://ultimateqa.com/simple-html-elements-for-automation/");
				
		WebElement gender_female = driver.findElement(By.xpath("//input[@name='gender' and @value='female']"));
		
		js.executeScript("arguments[0].scrollIntoView(true)", gender_female);
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='gender' and @value='female']")));
		gender_female.click();
		System.out.println("female clicked..!");
		
	}

}
