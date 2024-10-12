package Rahullshetty.FrameWork.Utils;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import io.appium.java_client.AppiumDriver;
public class Listeners extends ApiumUtils implements ITestListener {
	
	ExtentReports extent= ExtentReportNG.getRepoterObject();
	ExtentTest test;
	AppiumDriver driver;
	
	@Override
	public void  onTestStart(ITestResult result) {
		 test= extent.createTest(result.getMethod().getMethodName());
	  }
	
	@Override 
	 public void onTestSuccess(ITestResult result) {
		    // not implemented
		 test.log(Status.PASS, "TestPassed");
		  }
	
	 @Override
	  public void onTestFailure(ITestResult result) {
	    // not implemented
	 test.fail(result.getThrowable());
	 try {
		driver= (AppiumDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
	
	 
	 }catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
	 
	 try {
	 test.addScreenCaptureFromPath(getScreenshotpath(result.getMethod().getMethodName(),driver), result.getMethod().getMethodName());
	  }catch(IOException e) {
		  
	  }
	 }

	 @Override
	  public  void onFinish(ITestContext context) {
	    // not implemented
		  extent.flush();
	  }
	 

}
