package listenersTestNG;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class myListenersClass extends MyBase implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {

		System.out.println("Test started..");
	}

	@Override
	public void onTestSuccess(ITestResult result) {

		System.out.println("Test Passed..");
		try {
			captureScreenshot(result.getMethod().getMethodName());
		} catch (Exception e) {
			System.out.println("could not capture screenshot:" + e.getMessage());
		}
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("Test Failed..");
		try {
			captureScreenshot(result.getMethod().getMethodName());
		} catch (Exception e) {
			System.out.println("could not capture screenshot:" + e.getMessage());
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {

	}

	@Override
	public void onStart(ITestContext context) {

	}

	@Override
	public void onFinish(ITestContext context) {
		ITestListener.super.onFinish(context);
	}

}
