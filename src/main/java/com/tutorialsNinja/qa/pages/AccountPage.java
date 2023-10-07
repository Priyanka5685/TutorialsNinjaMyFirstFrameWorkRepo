package com.tutorialsNinja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage {
	
public	WebDriver driver;
	
	//Object
	@FindBy(xpath="//a[contains(text(),'Edit your account information')]")
	WebElement editYourAccountInformationOption;
	
	
	//construcor
	public AccountPage(WebDriver driver) {
		this.driver=driver;
		
		// To avoid Stale Element Exception  pageFactory design pattern provides method;call the method below
		PageFactory.initElements(driver, this);	//this means HomePage.java
				
		
	}
	
	
	//Actions
	public boolean getDisplayStatusOfEditYourAccountInformationOption() {
		
		
		boolean displaystatus=editYourAccountInformationOption.isDisplayed();
		return displaystatus;
		
//If this method is displayed it returns true or false		
	}
	
	
	
	
	
	
	

}
