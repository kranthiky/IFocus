package dataprovider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DemoDP {

	@DataProvider(name = "testdata")
	public Object[][] createData1() {
		return new Object[][] { { "Cedric", 36 }, { "Anne", 37 }, { "bbb", 23 }, { "sss", 34 }, };
	}
	
	@Test(dataProvider = "testdata")
	public void verifyData1(String n1, Integer n2) {
	 System.out.println(n1 + " " + n2);
	}
	


}
