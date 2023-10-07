package com.policyBazar.qa.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.BaseClass;
import com.tutorialsNinja.qa.pages.HomePage;
import com.tutorialsNinja.qa.pages.PhonePage;
import com.tutorialsNinja.qa.pages.PhoneSucessPage;

public class PhoneTest extends BaseClass {
	
 public WebDriver driver;

//create a constructor of PhoneTest ; it calls the constructor from BaseClass
public PhoneTest() {
	super();
}
	
@BeforeMethod
public void setUp() {
driver=InitilizeBrowser() ;//To launch the Browser 
HomePage homepage = new HomePage(driver);//create an object of Homepage 
homepage.clickOnPhone();	
}

@AfterMethod
public void tearDown() {
	driver.quit();// quit the browser
}

@Test(priority=1)
public void verifyThePhoneForValidEnquiry() throws InterruptedException {
//create an object for PhonePage
PhonePage phonepage = new PhonePage(driver);	
phonepage.enquiryForValidReason(dataprop.getProperty("YourName"), dataprop.getProperty("E-Mail"), dataprop.getProperty("Enquiry"));
Thread.sleep(9000);
phonepage.clickOnPhoneContinueButton();
//craete an object Of PhoneSucessPage 
Thread.sleep(9000);
PhoneSucessPage  PhoneSucessPage  = new PhoneSucessPage (driver);
Assert.assertTrue(PhoneSucessPage.getDisplayStatusOfEnquiredData(),"customer is satisfied with answer");


}

@Test(priority=2)
public void verifyThePhoneForBlankEnquiry() throws InterruptedException {
	//create an object for PhonePage
	PhonePage phonepage = new PhonePage(driver);	
	phonepage.enquiryForValidReason("", "", "");
	Thread.sleep(9000);
	//craete an object Of PhoneSucessPage 
	Thread.sleep(9000);
	PhoneSucessPage  PhoneSucessPage  = new PhoneSucessPage (driver);

System.out.println("Phone Enquiry For Blank Inputs is passed");
String nameHeadingWarning=  PhoneSucessPage.retriveYournamewarning();
Assert.assertEquals(nameHeadingWarning, dataprop.getProperty("YourNameWarning"));	
String emailHeadingWarning=  PhoneSucessPage.retriveemailwarning();
Assert.assertEquals(emailHeadingWarning, dataprop.getProperty("EmailWarning"));	
		
String enquiryHeadingWarning=  PhoneSucessPage.retriveEnquirywarning();
Assert.assertEquals(enquiryHeadingWarning, dataprop.getProperty("EnquiryWarning"));	
		
}




	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
