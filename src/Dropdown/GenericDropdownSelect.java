package Dropdown;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class GenericDropdownSelect {

	@Test
	public void SelectTag() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Automation Workspace\\Softwares\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/reg/");
		//find web element
		WebElement DayDD = driver.findElement(By.id("day"));
		WebElement monthDD = driver.findElement(By.id("month"));
		WebElement yearDD = driver.findElement(By.id("year"));
		selectDropdown(DayDD,"28");
		selectDropdown(monthDD,"Oct");
		selectDropdown(yearDD,"1989");
	}
	public static void selectDropdown(WebElement elm, String value) {
		Select DD = new Select(elm);
		DD.selectByVisibleText(value);
	}
}
