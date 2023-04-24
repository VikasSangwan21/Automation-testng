package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReport {
	
	public static ExtentReports setupReport() {
		// directory where output is to be printed
		ExtentSparkReporter reportFile = new ExtentSparkReporter(System.getProperty("user.dir")+"/reports/TestResults.html");
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reportFile);
		return extent;
	}
	
	
	
}
