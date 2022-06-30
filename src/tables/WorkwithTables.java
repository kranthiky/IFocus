package tables;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class WorkwithTables {

	public static WebDriver driver;
	public static List<WebElement> headers;
	public static List<WebElement> rows;
	public static List<WebElement> allData;
	
	@BeforeClass
	public void tables() throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\drivers\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://seleniumpractise.blogspot.com/2021/08/webtable-in-html.html");
		Thread.sleep(3000);
		
		// table header locator
		headers = driver.findElements(By.xpath("//table[@id='customers']//th"));
		// table rows locator
		rows = driver.findElements(By.xpath("//table[@id='customers']//tr"));
		//table data locator
		allData = driver.findElements(By.xpath("//table[@id='customers']//td"));		
	}
	
	@Test(enabled = false, priority =1)
	public void testHeaders() {
		System.out.println("Count of Headers:" +headers.size());
		boolean headerStatus = false;
	//	System.out.println("Headers are: ");
		for(WebElement hdr: headers)
		{
			String hdrActual = hdr.getText();
		//	System.out.println(hdr.getText());
			if(hdrActual.contains("Country")) {
				headerStatus = true;
				break;
			}
		}
		Assert.assertTrue(headerStatus, "Expected header was not found..!");
	}
	
	@Test(enabled = false, priority =2)
	public void testRows() {
		System.out.println("Count of rows in the table:"+rows.size());
		System.out.println("rows");
		for(WebElement rowData:rows) {
			System.out.println(rowData.getText());
		}
	}
	
	@Test(enabled = false, priority =3)
	public void allData() {
		//match specific data
	//	System.out.println("Data in the table: ");
		boolean dataStatus = false;
		for(WebElement alData: allData) {
		//	System.out.println(alData.getText());
			if(alData.getText().contains("Java")) {
				dataStatus = true;
				String rowData = driver.findElement(By.xpath("//td[text()='"+alData.getText()+"']/..")).getText();
				System.out.println("corresponding row: "+rowData);
				break;
			}
		}
		Assert.assertTrue(dataStatus,"Data not found..!");
	}
	
	@Test(enabled = false, priority =3)
	public void onlyColumn() {
		 int column =2;
		
		List<WebElement> elementsOfColumn = driver.findElements(By.xpath("//table[@id='customers']//tr//td["+column+"]"));
		System.out.println("Data of 2nd Column is: ");
		for(WebElement colData:elementsOfColumn ) {
			System.out.println(colData.getText());
		}
		
	}
	
	@Test(enabled = true, priority =4)
	public void selectCorrespondingItem() throws InterruptedException {
		
		String expdt ="Jenkins";
		// Generilized locator with passing data
	//	WebElement actualDt = driver.findElement(By.xpath("//table[@id='customers']//td[text()='"+expdt+"']"));
		//select checkbox
		driver.findElement(By.xpath("//td[text()='"+expdt+"']//preceding-sibling::td[1]//input")).click();
		Thread.sleep(3000);

		//click links
		driver.findElement(By.xpath("//td[text()='"+expdt+"']//following-sibling::td[3]"));
		Thread.sleep(3000);
	//	driver.navigate().back();		
		
	}
}
