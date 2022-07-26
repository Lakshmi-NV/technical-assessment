package resources;



import com.aventstack.extentreports.ExtentReports;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;




@SuppressWarnings("deprecation")
public class ExtentReporterNG {
	
	  static ExtentReports extent;
	  
	  public static ExtentReports getReportObject() {
	  
	  String path = System.getProperty("user.dir")+"\\reports\\index.html";
	  System.out.println("Im here");
	  ExtentSparkReporter reporter = new ExtentSparkReporter(path);
	  reporter.config().setReportName("Web Automation Results");
	  reporter.config().setDocumentTitle("Test Results");
	  
	  extent =new ExtentReports(); 
	  extent.attachReporter(reporter);
	  extent.setSystemInfo("Tester", "Lakshmi");
	  return extent;
	  
	  }
	 
	
}