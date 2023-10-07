package com.tutorialsNinja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PhonePage {
public	WebDriver driver;
	
	//Objects
	@FindBy(id="input-name")
	private WebElement name;

	@FindBy(id="input-email")
	private WebElement emailAdd;

	@FindBy(id="input-enquiry")
	private WebElement enquiry;

	@FindBy(xpath="//input[@value='Submit']")
	private WebElement submit;
	
	@FindBy(xpath="//a[contains(text(),'Continue')]")
	private WebElement continueButt;
	
	
	
	
	
	
	
	//create a constructor of phonepage
	public  PhonePage(WebDriver driver) {
		this.driver=driver;
	// To avoid Stale Element Exception  pageFactory design pattern provides method;call the method below
	PageFactory.initElements(driver, this);	//this means HomePage.java
		
		
	}	
	
	
	//Actions 
	
	public void enquiryForValidReason(String nameText, String emailText, String enquiryText) {
		name.sendKeys(nameText);
		emailAdd.sendKeys(emailText);
		enquiry.sendKeys(enquiryText);
		submit.click();
		
	}
	
	public void clickOnPhoneContinueButton() {
		
		continueButt.click();
	}
	
	public void enquiryForBlankInputs(String nameText, String emailText, String enquiryText) {
		
		name.sendKeys(nameText);
		emailAdd.sendKeys(emailText);
		enquiry.sendKeys(enquiryText);
		submit.click();
	
		
	}
	
	
	
	
	
	
	
	
	
	
	

}
