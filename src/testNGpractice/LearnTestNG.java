package testNGpractice;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LearnTestNG {

//	@BeforeGroups("TestsGroups")
//	public void bfrGroups() {
//		System.out.println("Before Groups");
//	}
//	
//	@AfterGroups("TestsGroups")
//	public void aftrGroups() {
//		System.out.println("After Groups");
//	}
	@BeforeSuite
	public void beforeSuit() {
		System.out.println("BeforeSuite");
	}

	@AfterSuite
	public void afterSuit() {
		System.out.println("AfterSuite");
	}

	@BeforeTest
	public void bforeTest() {
		System.out.println("BeforeTest");
	}

	@AfterTest
	public void aftrTest() {
		System.out.println("AfterTest");
	}

	@BeforeClass
	public void bforeClass() {
		System.out.println("BeforeClass");
	}

	@AfterClass
	public void aftrClass() {
		System.out.println("AfterClass");
	}

	@BeforeMethod
	public void bforeMethod() {
		System.out.println("BeforeMethod");
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("AfterMethod");
	}
	@Test(priority=1,groups={"Regression","Smoke"}) 
	public void A() {
		System.out.println("A method");
	}
	@Test(priority=3,groups={"Functional","Regression"}) 
	public void D() {
		System.out.println("D method");
	}
	@Test(groups= {"Smoke"})
	public void C() {
		System.out.println("C method");
	}
	@Test(priority=2, groups= {"Functional"})
	public void B() {
		System.out.println("B method");
	}
}
