package utility;

import java.awt.Desktop;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import TestCase.head_page;



public class Extend_Report implements ITestListener{
	
	public ExtentSparkReporter sparkReporter;
	public ExtentReports extent;
	public ExtentTest test;
	
	String repName;
	
	public void onStart(ITestContext Context) {
		
		String timeStamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		repName="Test Report_"+timeStamp+".html";
		
		sparkReporter = new ExtentSparkReporter(".\\Ex_Report\\" + repName);
		
		sparkReporter.config().setDocumentTitle("Automation");
		sparkReporter.config().setReportName("openCart");
		sparkReporter.config().setTheme(Theme.DARK);
		
		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);
		
		
		extent.setSystemInfo("Application","opencart");
		extent.setSystemInfo("Module","Admin");
		extent.setSystemInfo("Sub Module","Customers");
		extent.setSystemInfo("User Name",System.getProperty("user.name"));
		extent.setSystemInfo("Environemnt","QA");
		
		String os =Context.getCurrentXmlTest().getParameter("os");
		extent.setSystemInfo("operating System", os);
		
		String browser =Context.getCurrentXmlTest().getParameter("browser");
		extent.setSystemInfo("Browser", browser);
		
		List<String> includedGroups = Context.getCurrentXmlTest().getIncludedGroups();
		if(!includedGroups.isEmpty()) {
		extent.setSystemInfo("Groups",includedGroups.toString());
		}	
	}
	public void onTestSuccess(ITestResult result) {
		
		test=extent.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.PASS,result.getName()+"Test is Successfull");	
	}
	
	public void onTestFailure(ITestResult result) {
		test=extent.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups());
		
		test.log(Status.FAIL,result.getName()+"Test Fail");
		test.log(Status.INFO,result.getThrowable().getMessage());
		
		try {
			//String imgPath=new head_page().ScreenShot(result.getName());
			String imgPath = ((head_page) result.getInstance()).ScreenShot(result.getName());
			test.addScreenCaptureFromPath(imgPath);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void onTestSkipped(ITestResult result) {
		test=extent.createTest(result.getClass().getName());
		test.assignCategory(result.getMethod().getGroups());
		
		test.log(Status.SKIP,result.getName()+"Test Skip");
		test.log(Status.INFO,result.getThrowable().getMessage());	
	}
	public void onFinish(ITestContext Context) {
		extent.flush();
		
		String pathOfExtenReport=System.getProperty("user.dir")+"\\Ex_Report\\"+repName;
		File extentReport=new File(pathOfExtenReport);
		
		try {
			Desktop.getDesktop().browse(extentReport.toURI());
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	
		
	

}
