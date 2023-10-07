package com.policyBazar.qa.testcases;

import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.project.qa.Utils.Utilities;
import com.qa.base.BaseClass;
import com.tutorialsNinja.qa.pages.AccountPage;
import com.tutorialsNinja.qa.pages.HomePage;
import com.tutorialsNinja.qa.pages.LoginPage;

public class LoginTest extends BaseClass {
public	WebDriver driver; LoginPage loginpage;
	HomePage homepage;
	
public LoginTest() {
	super();// It will call A constructor from BaseClass To read PropertiesFile which has projectUrl
}
	
	//code is optimized inthis class	
	
@BeforeMethod	
	
public void setUp() throws InterruptedException {
driver=InitilizeBrowser();	
//create an Object HomePage To call Locatiors 
 homepage = new HomePage(driver);

//call the action methods
 //homepage.clickOnMyAccount();
 //homepage.selectLoginOption();//redirect to Login Page
 
 loginpage = homepage.navigateToLoginPage();//redirect to Login Page
	
	
}
	
	
	
	
@AfterMethod	
public void tearDown() {
driver.quit();	
}
	
	
	
	
	
@Test(enabled=true,priority=1,dataProvider="ValidCredentialSupplier" )
public void verifyLoginWithValidCredentials( String email, String password  ) throws InterruptedException {
 
//create an Object For LoginPage to get The Locators from that 
// loginpage = new LoginPage(driver);//No need becz loginoption Method Returns LoginPage and Alrdey in setUp()
//methods which excutes before each TC
	
	/*loginpage.enterEmailAddress(email);
	loginpage.enterPassword(password);
	loginpage.clickOnLogin();*///redict to login Page
	
	loginpage.login(email, password);//redict to login Page
Thread.sleep(8000);

//create an object for AccountPage 

/*AccountPage accountpage = new AccountPage(driver);
Assert.assertTrue(accountpage.getDisplayStatusOfEditYourAccountInformationOption());*/

System.out.println("Testcase is passed");

//amotooricap9@gmail.com
}


//This Method is To Call The Data From Excel ; Here We have Called the method from Utilities as  getTestDataFromExcel(sheetName); 
@DataProvider(name="ValidCredentialSupplier")
public Object [][] supplyTestData() {
	
Object [][]	data= Utilities.getTestDataFromExcel("Login");
	
return data;
	
}



@Test(enabled=true,priority=2)

public void verifyLoginWithInvalidCredentils() throws InterruptedException {
//create LoginPage Object 	
	// LoginPage LoginPage = homepage.selectLoginOption();//redirect to Login Page
		
	/*loginpage.enterEmailAddress(Utilities.generateEmailWithTimeStamp());
	loginpage.enterPassword(dataprop.getProperty("InvalidPassword"));
	loginpage.clickOnLogin();
Thread.sleep(9000)*/
	
	loginpage.login(Utilities.generateEmailWithTimeStamp(), dataprop.getProperty("InvalidPassword"));
	Thread.sleep(9000);

	String actualWarningMessage=loginpage.invalidCredentialsWarningMessage() ;
	String expectedWarningMessage= dataprop.getProperty("emailPasswordNoMatchWarning");
Assert.assertTrue(actualWarningMessage.contains(expectedWarningMessage),"Expected and Actual Does Not Match");	

	//After 5Th time of running	it got failed, after 5th the warning message is different as "Warning: Your account has exceeded allowed 
	//number of login attempts. Please try again in 1 hour." The solution of this problem is evrytime we have to give new Invalid Email address
	// in this, invalid EmailAddress keeps on changing by the time. 

}


@Test(enabled=true,priority=3)
public void verifyLoginWithBlankCredentils() throws InterruptedException {
//create LoginPage Object 	
//loginpage = new LoginPage(driver);
	
	/*loginpage.enterEmailAddress("");
	loginpage.enterPassword("");
	loginpage.clickOnLogin();*/

loginpage.login("","");
Thread.sleep(9000);

	String actualWarningMessage= loginpage.blankInputWarningMessage();
	String expectedWarningMessage= dataprop.getProperty("emailPasswordNoMatchWarning");
	Assert.assertTrue(actualWarningMessage.contains(expectedWarningMessage),"Expected and Actual Does Not Match");	
	
}
		
@Test(enabled=true ,priority=4)	
public void verifyLoginWithValidEmailIdandInvalidPassword() throws InterruptedException	{
	
//create LoginPage Object 	 
//loginpage = new LoginPage(driver);
	
	/*loginpage.enterEmailAddress(prop.getProperty("ValidEmail"));
	loginpage.enterPassword(dataprop.getProperty("InvalidPassword"));
	loginpage.clickOnLogin();*/
	
	loginpage.login(prop.getProperty("ValidEmail"), dataprop.getProperty("InvalidPassword"));
Thread.sleep(9000);
	
	String actualWarningMessage= loginpage.invalidCredentialsWarningMessage() ;
	String expectedWarningMessage= dataprop.getProperty("emailPasswordNoMatchWarning");
	Assert.assertTrue(actualWarningMessage.contains(expectedWarningMessage),"Expected and Actual Does Not Match");	
	
	
}
	
	
@Test(enabled=true,priority=5)	
public void verifyLoginWithINValidEmailIdandValidPassword() throws InterruptedException	{
//create LoginPage Object 	
//loginpage = new LoginPage(driver);
	
	/*loginpage.enterEmailAddress(Utilities.generateEmailWithTimeStamp());
	loginpage.enterPassword(prop.getProperty("ValidPassword"));
	loginpage.clickOnLogin();
Thread.sleep(9000);*/
	
	loginpage.login(Utilities.generateEmailWithTimeStamp(), prop.getProperty("ValidPassword"));

String actualWarningMessage=loginpage.invalidCredentialsWarningMessage() ;
String expectedWarningMessage= dataprop.getProperty("emailPasswordNoMatchWarning");
Assert.assertTrue(actualWarningMessage.contains(expectedWarningMessage),"Expected and Actual Does Not Match");	

}	
	












}
