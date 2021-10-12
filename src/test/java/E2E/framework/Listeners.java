package E2E.framework;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.model.Test;

import resources.Base;
import resources.ExtentReportConfig;

public class Listeners  extends Base implements ITestListener {
	ExtentTest test;	
ExtentReports extent =	ExtentReportConfig.getExtentReport();
ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();

	@Override
	public void onTestStart(ITestResult result) {
 test =		extent.createTest(result.getMethod().getMethodName());
 extentTest.set(test);
		
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		extentTest.get().log(Status.PASS, "Test Passed");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		extentTest.get().log(Status.FAIL, result.getThrowable());
		
		WebDriver driver = null;
String	testCaseName =	result.getMethod().getMethodName();
System.out.println(testCaseName);
try {
driver =	(WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
} catch (Exception e) {
	
	e.printStackTrace();
}
		try {
			//to add ScreenShot on extent report
			//extentTest.get().addScreenCaptureFromPath(getScreenShot(testCaseName, driver), result.getMethod().getMethodName());
			getScreenShot(testCaseName, driver);
			
			
		} catch (Exception e1) {
			
			e1.printStackTrace();
		}
		
		
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
		
	}

}
