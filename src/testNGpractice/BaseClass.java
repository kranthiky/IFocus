package testNGpractice;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class BaseClass {

	@BeforeSuite
	public void b4Suite() {
		System.out.println("BaseClass-BeforeSuite");
	}
	
	@BeforeTest
	public void b4Test() {
		System.out.println("BaseClass-BeforeTest");
	}
	
	@AfterTest
	public void aftrTest() {
		System.out.println("BaseClass-AfterTest");
	}
	
	@AfterSuite
	public void aftrSuite() {
		System.out.println("BaseClass-AfterSuite");
	}
	
	
}

