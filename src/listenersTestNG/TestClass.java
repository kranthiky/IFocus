package listenersTestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

//@Listeners(myListenersClass.class)
public class TestClass extends MyBase {

	
	@BeforeClass
	public void setupBrowser() {
		browserInitialization();
	}
	
	@Test(priority =1)
	public void TestLoginToApp() throws InterruptedException {
		WebElement uName = driver.findElement(By.id("txtUsername"));
		WebElement pWord = driver.findElement(By.id("txtPassword"));
		WebElement loginButton = driver.findElement(By.name("Submit"));
		
		uName.sendKeys("Admin");
		Thread.sleep(1000);
		pWord.sendKeys("admin123");
		Thread.sleep(1000);
		loginButton.click();
		Thread.sleep(2000);
		Assert.assertEquals(driver.getCurrentUrl(), "https://opensource-demo.orangehrmlive.com/index.php/dashboard");

	}
	@Test(priority =2, enabled=true)
	public void logoutFromOrange() throws InterruptedException {
		WebElement logOutDropdown = driver.findElement(By.xpath("//a[text()='Welcome osama']"));
		WebElement logoutLink = driver.findElement(By.xpath("//a[text()='Logout']"));
		
		logOutDropdown.click();
		Thread.sleep(2000);
	//	logoutLink.click();
		Thread.sleep(2000);
		Assert.assertEquals(driver.getCurrentUrl(), "https://opensource-demo.orangehrmlive.com/index.php/auth/login");
	}
	@AfterClass
	public void tearDown() {
		driver.close();
		driver.quit();
	}
	
}
