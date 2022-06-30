package dataprovider;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FBloginWithUsersFromExcel extends TestDataProviders {

	public static XSSFWorkbook workBook;
	public static XSSFSheet workSheet;
	public static String sheetName = "FB Reg";
	public static WebDriver driver;
	public static String URL ="https://www.facebook.com";
	public TestDataProviders provider; 
	
	@BeforeClass
	public void setUpApplication() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\drivers\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(URL);
	}
	
	@Test(priority=1,dataProvider = "Read from Excel") 
	public void loginToFB(String userName, String passWord) throws InterruptedException {

	//	provider = new FBloginWithUsersFromExcel();
		WebElement uName = driver.findElement(By.id("email"));
		WebElement pWord = driver.findElement(By.id("pass"));
		WebElement loginButton = driver.findElement(By.xpath("//button[contains(@id,'u_0')]"));
		try {
			  uName.sendKeys(userName);
			  pWord.sendKeys(passWord);
			  loginButton.click();
			  Thread.sleep(2000);
			  driver.get(URL);
		} catch (Exception e) {
			System.out.println("Could not read data from excel "+e.getMessage());
		}
	}
}