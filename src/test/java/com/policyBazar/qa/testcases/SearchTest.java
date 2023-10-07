package com.policyBazar.qa.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.BaseClass;
import com.tutorialsNinja.qa.pages.HomePage;
import com.tutorialsNinja.qa.pages.SarchPageResults;

public class SearchTest  extends BaseClass{
	
	 public WebDriver driver;SarchPageResults searchpageresult;
	
	public SearchTest() {
		super();// It will call A constructor from BaseClass To read PropertiesFile which has projectUrl
	}
			
	
	
	@BeforeMethod	
	public void setUp() throws InterruptedException {
	driver=InitilizeBrowser();	
		
	}
	
	@AfterMethod	
	public void tearDown() {
	driver.quit();	
	}
	
	@Test(priority=1, enabled=true)
	public void verifySearchWithValidProducts() throws InterruptedException {
		//Create an Object For HomePage
		HomePage homepage = new HomePage(driver);
		homepage .enterValidProducts(dataprop.getProperty("ValidProduct"));
	 searchpageresult	=	homepage.clickOnSearchButton();//returns SearchPageResults object; so no need to crate an object for SearchPageResults seperately 
		Thread.sleep(9000);
//create an Object For search Page Results 
		//SarchPageResults searchpageresult = new SarchPageResults(driver);		
		
Assert.assertTrue(searchpageresult.dispalyStatusOfValidHPProduct(),"Valid Product Is Not Displayed");	

		
	}
	
	
	@Test(priority=2, enabled=true)
	
	public void verifySearchWithInValidProducts() throws InterruptedException {
		//Create an Object For HomePage
		HomePage homepage = new HomePage(driver);
		homepage .enterValidProducts(dataprop.getProperty("InvalidProduct"));
		searchpageresult	=	homepage.clickOnSearchButton();
		Thread.sleep(9000);
		
		//create an Object For search Page Results 
				//SarchPageResults searchpageresult = new SarchPageResults(driver);		
					
		
	String actualInvalidSearch=searchpageresult.enterInvalidProductHondaintoSearchFeild();	
Assert.assertEquals(actualInvalidSearch, dataprop.getProperty("NoProductTextInSearchResult"));	

	}
	
	
@Test(priority=3, enabled=true)	
	
public void verifySearchWithBlankInputs() throws InterruptedException {
	
	//Create an Object For HomePage
			HomePage homepage = new HomePage(driver);
			homepage .enterValidProducts("");
			searchpageresult	=	homepage.clickOnSearchButton();
			Thread.sleep(9000);
			
			//create an Object For search Page Results 
			//SarchPageResults searchpageresult = new SarchPageResults(driver);		
						
	String actualInvalidSearch=  searchpageresult.enternoInputInSearchFeild();		
	Assert.assertEquals(actualInvalidSearch, dataprop.getProperty("NoProductTextInSearchResult"));
	
	
}

}
