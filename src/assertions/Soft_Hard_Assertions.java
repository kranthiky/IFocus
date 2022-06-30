package assertions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Soft_Hard_Assertions {
	
	@Test(enabled = true)
	public void Asserts() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\drivers\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/reg/");
				
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
		softAsrt.assertEquals(monthList.size(), 13,"Month count does not match - Raise a bug");
		System.out.println("Months in the DD are:");
		for(WebElement months: monthList) {
		     System.out.println(months.getText());
		}
		
		//Hard Assert
		Assert.assertEquals(monthCount, 12,"Month count does not match - Raise a bug");
		Assert.assertEquals(monthList.get(9).getText(), "Oct","Oct month index is not 9 - get right index");
		Assert.assertTrue(monthList.get(9).getText().contains("Oc"), "index 9 not of Oct month?");
		System.out.println("this statement would not be executed if hardAssert fails");
		
		softAsrt.assertAll();
	}
}
