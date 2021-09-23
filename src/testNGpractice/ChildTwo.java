package testNGpractice;

import org.testng.annotations.Test;

public class ChildTwo extends BaseClass {

	@Test
	public void testOne() {
		System.out.println("ChildTwo -Test1 method");
	}
	@Test
	public void testTwo() {
		System.out.println("ChildTwo -Test2 method");
	}
}
