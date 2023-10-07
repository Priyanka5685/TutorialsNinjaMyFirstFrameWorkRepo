package com.policyBazar.qa.testcases;

import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.project.qa.Utils.Utilities;
import com.qa.base.BaseClass;
import com.tutorialsNinja.qa.pages.AccountSucessPage;
import com.tutorialsNinja.qa.pages.HomePage;
import com.tutorialsNinja.qa.pages.RegisterPage;

public class RegisterTest extends BaseClass {
 public WebDriver driver; RegisterPage  registerpage ;AccountSucessPage accountsucesspage	;

public RegisterTest() {
	super();// It will call A constructor from BaseClass To read PropertiesFile which has projectUrl
}


@BeforeMethod
public void setUp() throws InterruptedException {
	driver=InitilizeBrowser();
	
	HomePage homepage = new HomePage(driver);
//	homepage.clickOnMyAccount();
	registerpage = homepage.navigateToRegisterPage();//returns the object of RegisterPage; so no need to create an object for RegisterPage 
	Thread.sleep(9000);	
	
	
}
@AfterMethod
public void tearDown() {
	driver.quit();
}

@Test(priority=1,enabled=true)	
public void verifyRegisterWithMandatoryFeilds() throws InterruptedException {

	//create an object for RegisterPage 
	// registerpage = new RegisterPage(driver);
	
	
/*	registerpage.enterFirstName(dataprop.getProperty("firstName"));
	registerpage.enterLastName(dataprop.getProperty("lastName"));	
	registerpage.enterEmailId(Utilities.generateEmailWithTimeStamp());
	registerpage.enterTelephone(dataprop.getProperty("telePhoneNumber"));
	registerpage.enterPassword(prop.getProperty("ValidPassword"));
	registerpage.enterconfirmPassword(prop.getProperty("ValidPassword"));
	registerpage.selectPrivacyPolicyButton();*/
	
accountsucesspage = registerpage.registerWithMandatoryFeilds(dataprop.getProperty("firstName"), dataprop.getProperty("lastName"), Utilities.generateEmailWithTimeStamp(), dataprop.getProperty("telePhoneNumber"), prop.getProperty("ValidPassword"));	
// accountsucesspage	=registerpage.clickOnContinueButton();//return object of accountpage no need to create an object of account page
Thread.sleep(9000);
//AccountSucessPage accountsucesspage =new AccountSucessPage(driver);	
String actualsucessHeading = accountsucesspage.accountScuessMessage();	
Assert.assertEquals(actualsucessHeading,dataprop.getProperty("accountSuccessfullyCreatedHeading") );



		
}
	
@Test(priority=2,enabled=true)

public void verifyRegisterWithAllFeilds() throws InterruptedException {
	
	accountsucesspage =	registerpage.registerWithAllFeilds(dataprop.getProperty("firstName"), dataprop.getProperty("lastName"), Utilities.generateEmailWithTimeStamp(),dataprop.getProperty("telePhoneNumber"), prop.getProperty("ValidPassword"));
	
	// registerpage = new RegisterPage(driver);
/*	registerpage.enterFirstName(dataprop.getProperty("firstName"));
	registerpage.enterLastName(dataprop.getProperty("lastName"));	
	registerpage.enterEmailId(Utilities.generateEmailWithTimeStamp());
	registerpage.enterTelephone(dataprop.getProperty("telePhoneNumber"));
	registerpage.enterPassword(prop.getProperty("ValidPassword"));
	registerpage.enterconfirmPassword(prop.getProperty("ValidPassword"));
	registerpage.selectRadioButton();
	registerpage.selectPrivacyPolicyButton();
	 accountsucesspage	=registerpage.clickOnContinueButton();*/

		Thread.sleep(9000);
	
	
	
	//AccountSucessPage accountsucesspage =new AccountSucessPage(driver);
		
	String actualsucessHeading = accountsucesspage.accountScuessMessage();
	
Assert.assertEquals(actualsucessHeading,dataprop.getProperty("accountSuccessfullyCreatedHeading") );		
System.out.println(" This Testcase is passed");			
}
	

@Test(priority=3,enabled=true)

public void verifyRegisterWithBlankInputs() throws InterruptedException {
	
	
	driver.findElement(By.id("input-firstname")).sendKeys("");
	driver.findElement(By.id("input-lastname")).sendKeys("");
	driver.findElement(By.id("input-email")).sendKeys("");
	driver.findElement(By.id("input-telephone")).sendKeys("");
	driver.findElement(By.id("input-password")).sendKeys("");
	driver.findElement(By.id("input-confirm")).sendKeys("");
	driver.findElement(By.xpath("//label[@class='radio-inline'][2]")).click();
	driver.findElement(By.xpath("//input[@name='agree']")).click();
	driver.findElement(By.xpath("//input[@value='Continue']")).click();
	Thread.sleep(10000);	
	
	/*String PrivacyPolicyWarning= driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText();
Assert.assertTrue(PrivacyPolicyWarning.contains("Warning: You must agree to the Privacy Policy!"),"The Expected And Actual Does Not Match ");	*/

String FirstNameWarning = driver.findElement(By.xpath("//input[@id='input-firstname']/following-sibling::div")).getText();
Assert.assertEquals(FirstNameWarning,  "First Name must be between 1 and 32 characters!" ,"The Expected And Actual Does Not Match ");	


String LastNameWarning = driver.findElement(By.xpath("//input[@id='input-lastname']/following-sibling::div")).getText();
Assert.assertEquals(LastNameWarning ,"Last Name must be between 1 and 32 characters! ","The Expected And Actual Does Not Match ");	


String EmailWarning = driver.findElement(By.xpath("//input[@id='input-email']/following-sibling::div")).getText();
Assert.assertEquals(EmailWarning ,"E-Mail Address does not appear to be valid! ","The Expected And Actual Does Not Match ");	

String TelephoneWarning = driver.findElement(By.xpath("//input[@id='input-telephone']/following-sibling::div")).getText();
Assert.assertEquals(TelephoneWarning ,"Telephone must be between 3 and 32 characters!","The Expected And Actual Does Not Match ");	

String PasswordWarning = driver.findElement(By.xpath("//input[@id='input-password']/following-sibling::div")).getText();
Assert.assertEquals(PasswordWarning ,"Password must be between 4 and 20 characters!","The Expected And Actual Does Not Match ");	


	

}




































}
