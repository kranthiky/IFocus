package testNGpractice;

import org.testng.annotations.Test;

public class ChildOne extends BaseClass {

	@Test
	public void testOne() {
		System.out.println("ChildOne -Test1 method");
	}
	@Test
	public void testTwo() {
		System.out.println("ChildOne -Test2 method");
	}
}
