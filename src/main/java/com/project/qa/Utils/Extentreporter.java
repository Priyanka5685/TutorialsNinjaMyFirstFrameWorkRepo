package com.project.qa.Utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Extentreporter {
public static ExtentReports generateExtentReport() {
ExtentReports extentreport = new ExtentReports();	
	
File extentReportFile = new File(System.getProperty("user.dir")+"\\test-output\\ExtentReports\\extentReport.html");	
	
ExtentSparkReporter spark = new ExtentSparkReporter(extentReportFile);
spark.config()	.setTheme(Theme.DARK);
spark.config().setReportName("TutorialsNinja Test Automation Results Report");
spark.config().setDocumentTitle("TN Automation Report ");	
spark.config().setTimeStampFormat("dd/mm/yyyy hh:mm:ss");	
	
extentreport.attachReporter(spark);	

Properties Configprop = new Properties();
File configpropFile = new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\tutorilasNinja\\qa\\config\\config.properties");
try {
FileInputStream fisConfigProp =new FileInputStream(configpropFile);

Configprop.load(fisConfigProp);
}catch(Throwable e) {
	e.printStackTrace();
}


extentreport.setSystemInfo("Application Url", Configprop.getProperty("Projecturl") );	
extentreport.setSystemInfo("Browser Name", Configprop.getProperty("browserName"))	;
extentreport.setSystemInfo("Email", Configprop.getProperty("ValidEmail"));	
extentreport.setSystemInfo("Email", Configprop.getProperty("ValidPassword"));		
extentreport.setSystemInfo("Operating syatem", System.getProperty("os.name"));	
extentreport.setSystemInfo("User Name", System.getProperty("user.name"));	
extentreport.setSystemInfo("Java Version", System.getProperty("java .version"));	
	
	
return 	extentreport;
	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
