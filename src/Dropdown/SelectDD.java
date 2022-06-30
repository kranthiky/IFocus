package Dropdown;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class SelectDD {

	@Test
	public void SelectTag() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\drivers\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/reg/");
		//find web element
		WebElement monthDD = driver.findElement(By.id("month"));
		
		// Drop down list	
		Select sel = new Select(monthDD);
		//default
		WebElement preSelected = sel.getFirstSelectedOption();
		System.out.println("Pre selected month: "+preSelected.getText());
		
		//select Drop down
		sel.selectByVisibleText("Dec");
		Thread.sleep(2000);
		sel.selectByValue("11");
		Thread.sleep(2000);
	//	sel.selectByIndex(10);
		Thread.sleep(2000);
	//select first option in dropdown
	//	sel.selectByIndex(0);
		
		//sel.isMultiple();
		//List - getOptions
		List<WebElement> monthList = sel.getOptions();
		// Month count
		System.out.println("Month DD size:"+monthList.size());
		// print Month list
		System.out.println("Print Months:");
		for(WebElement monList: monthList) {
		System.out.println(monList.getText());
		}
		Thread.sleep(2000);
	//	sel.selectByVisibleText("Nov");
		Thread.sleep(3000);
	}
}
