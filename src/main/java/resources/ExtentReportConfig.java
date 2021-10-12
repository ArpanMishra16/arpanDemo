package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportConfig {
	
	
	public static ExtentReports getExtentReport() {
		
		String reportPath = System.getProperty("user.dir")+"\\reports\\extent Reports\\index.html";
		ExtentSparkReporter rep = new ExtentSparkReporter(reportPath);
		rep.config().setReportName("Selenium Automation Results");
		rep.config().setDocumentTitle("Arpan Automation");
		
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(rep);
		extent.setSystemInfo("Tester", "Arpan Mishra");
		return extent;
	}

}

