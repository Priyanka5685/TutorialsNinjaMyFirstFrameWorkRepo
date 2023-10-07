package com.tutorialsNinja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PhoneSucessPage {
public	WebDriver driver;
//Objects
@FindBy(linkText="MacBook")	
WebElement macBook;	

@FindBy(xpath="//input[@id='input-name']//following::div[1]")
private WebElement nameWarning;


@FindBy(xpath="//input[@id='input-email']//following::div[1]")
private WebElement emailWarning;


@FindBy(xpath="//textarea[@id='input-enquiry']//following::div[1]")
private WebElement enquiryWarning;


//constructor 
public	PhoneSucessPage(WebDriver driver) {
	this.driver=driver;
	
	// To avoid Stale Element Exception  pageFactory design pattern provides method;call the method below
	PageFactory.initElements(driver, this);	//this means HomePage.java
			
	
		
	}
	
//actions	
public boolean  getDisplayStatusOfEnquiredData() {
	
boolean displayStatus=	macBook.isDisplayed();	
	return displayStatus;
	
}

public String retriveYournamewarning() {
String acutalYourNameWarning 	=nameWarning.getText();
return acutalYourNameWarning ;
}

public String retriveemailwarning() {
String acutalemailWarning 	=emailWarning.getText();
return acutalemailWarning ;
}

public String retriveEnquirywarning() {
String acutalEnquiryfeildWarning 	=enquiryWarning.getText();
return acutalEnquiryfeildWarning ;
}









	
	
	

}
