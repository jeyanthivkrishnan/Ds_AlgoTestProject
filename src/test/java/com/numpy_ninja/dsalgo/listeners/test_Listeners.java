package com.numpy_ninja.dsalgo.listeners;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


public class test_Listeners extends com.numpy_ninja.dsalgo.pages.base implements ITestListener {

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub

	}

	// Method called to take screenshot when the test fails
	// failed method(where screenshot is captured) from base class is invoked test
	// fails
	public void onTestFailure(ITestResult result) {

		failed(result.getMethod().getMethodName());
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub

	}

}
