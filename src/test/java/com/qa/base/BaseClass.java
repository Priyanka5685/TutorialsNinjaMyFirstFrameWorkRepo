package com.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass {
WebDriver driver;
  public Properties prop;
  public Properties dataprop;
 //Create a Constructor To read A Properties File ; Instead of name readPropertiesFile() we have created a consturctor to read properties File 
  public BaseClass() {
	  prop = new Properties();
	  File propFile = new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\tutorilasNinja\\qa\\config\\config.properties\\");
	  //To get path Of PropertiesFile system.getproperty("user.dir)+"path"
	  
	 //To read InvalidData from testdata propertiesFile
	  
	  dataprop = new Properties();
	  File datapropFile= new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\tutorialsNinja\\qa\\testdata\\testdata.properties");
	  try {
	  FileInputStream datafis = new FileInputStream(datapropFile);
	  dataprop.load(datafis);
	  }catch(Throwable e) {
		  e.printStackTrace();	  
	  }
	  
	  
	  
	  
	  
	  
	  try {
	  FileInputStream fis = new FileInputStream(propFile);

	  	prop.load(fis);
	  }catch(Throwable e) {
	  e.printStackTrace();	
	  }
	  	
	  	
 }
	  	  
  
  
  
public WebDriver InitilizeBrowser() {
	
	driver = new ChromeDriver();	
	driver.manage().window().maximize();	
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));	
	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));	
	driver.get(prop.getProperty("Projecturl"));	
	return driver;
}
	



	
	
	
	
	
	
	
	
	
	
	
}
