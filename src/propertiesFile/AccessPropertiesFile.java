package propertiesFile;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AccessPropertiesFile {

	public static Properties prop;
	public static WebDriver driver;
	@BeforeClass
	public void readPropertiesFile() {
		try{
			 prop = new Properties();
			 FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+"//src//propertiesFile//config.properties");
			 prop.load(ip);
			 
			 if(prop.getProperty("browser").equalsIgnoreCase("chrome")) {
				 
			//	 System.setProperty("webdriver.chrome.driver", "C:\\Automation Workspace\\Softwares\\chromedriver_win32\\chromedriver.exe");
				 System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//drivers//chromedriver//chromedriver.exe");
				 driver = new ChromeDriver();
				 
			 }else if(prop.getProperty("browser").equalsIgnoreCase("firefox")) {
				 System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\drivers\\firefoxdriver\\geckodriver.exe");
				 driver = new FirefoxDriver();
			}
			}catch(FileNotFoundException e) {
			       System.out.println("File not found in given location..!");
		    }catch(Exception e) {
		    	   System.out.println(e.getMessage());
			       e.getStackTrace();
		    }
		driver.manage().window().maximize();
		
	}
	@Test
	//Read
	public void accessingConfig() {
		driver.get(prop.getProperty("URL"));
	}
	
	@Test
	// Write
	public void writeToPropertiesFile() {
		
		try {
			FileOutputStream op = new FileOutputStream(System.getProperty("user.dir")+"/src/propertiesFile/config.properties");
			prop.setProperty("TestResult", "PASS");
			prop.store(op, null);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch(Exception e) {
	    	   System.out.println(e.getMessage());
		       e.getStackTrace();
	    }
	}
}
