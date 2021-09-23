package assertions;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Assertions2 {
	
	public static WebDriver driver;
	
	@BeforeClass
	public void launchAppl() {
		System.setProperty("webdriver.chrome.driver", "C:\\Automation Workspace\\Softwares\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/reg/");
		System.out.println("App launched..!");
	}
	
	@Test(enabled = true, priority =1)
	public void softAsserts() throws InterruptedException {
				
		WebElement monthDD = driver.findElement(By.id("month"));
		Thread.sleep(2000);
		// Drop down list	
		Select sel = new Select(monthDD);
		sel.selectByVisibleText("Dec");
				
		List<WebElement> monthList = sel.getOptions();	
		int monthCount= monthList.size();
		System.out.println("Month DD size:"+monthCount);
		
		//softAssertion
		SoftAssert softAsrt = new SoftAssert();
		softAsrt.assertEquals(monthList.size(), 14,"Month count does not match - Raise a bug");
		System.out.println("Months in the DD are:");
		for(WebElement months: monthList) {
		     System.out.println(months.getText());
		}
		softAsrt.assertAll();
	}
	@Test(enabled = true, priority =2)
	public void hardAsserts() throws InterruptedException {

				
		WebElement monthDD = driver.findElement(By.id("month"));
		Thread.sleep(2000);
		// Drop down list	
		Select sel = new Select(monthDD);
		sel.selectByVisibleText("Feb");
				
		List<WebElement> monthList = sel.getOptions();	
		int monthCount= monthList.size();
		System.out.println("Month DD size:"+monthCount);
		
		//Hard Assert
		Assert.assertEquals(monthCount, 13,"Month count does not match - Raise a bug");
		Assert.assertEquals(monthList.get(8).getText(), "Oct","Oct month index is not 9 - get right index");
		Assert.assertTrue(monthList.get(9).getText().contains("Oc"), "index 9 not of Oct month?");
		System.out.println("this statement would not be executed if hardAssert fails");
		
	}
}
