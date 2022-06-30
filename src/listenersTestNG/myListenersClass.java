package listenersTestNG;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class myListenersClass extends MyBase implements ITestListener {

	public void onTestStart(ITestResult result) {

		System.out.println("Test started..");
	}

	public void onTestSuccess(ITestResult result) {

		System.out.println("Test Passed..");
		try {
			captureScreenshot(result.getMethod().getMethodName());
		} catch (Exception e) {
			System.out.println("could not capture screenshot:" + e.getMessage());
		}
	}

	public void onTestFailure(ITestResult result) {
		System.out.println("Test Failed..");
		try {
			captureScreenshot(result.getMethod().getMethodName());
		} catch (Exception e) {
			System.out.println("could not capture screenshot:" + e.getMessage());
		}
	}

	public void onTestSkipped(ITestResult result) {

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	public void onTestFailedWithTimeout(ITestResult result) {

	}

	public void onStart(ITestContext context) {

	}

	public void onFinish(ITestContext context) {
	
	}

}
