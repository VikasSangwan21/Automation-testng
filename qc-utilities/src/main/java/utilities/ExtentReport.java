package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReport {
	
	public static ExtentReports setupReport() {
		// directory where output is to be printed
		ExtentSparkReporter reportFile = new ExtentSparkReporter("C:\\Users\\User\\Desktop\\Automation\\Automation-testng\\ui-tests\\reports\\TestResults.html");
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reportFile);
		return extent;
	}
	
	
	
}
