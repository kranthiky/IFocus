package dataprovider;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners(dataprovider.MyTestListeners.class)
public class TestParameters   {

//	@Parameters({ "ssss" })
	@Test()
	public void verifyData1() {
		System.out.println("sdf");
	}

}
