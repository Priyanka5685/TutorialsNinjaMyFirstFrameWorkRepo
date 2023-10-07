package com.tutorialsNinja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
public	WebDriver driver;
	
//Objects	
@FindBy(id="input-firstname")	
WebElement firstnameFeild;

@FindBy(id="input-lastname")
WebElement lastnameFeild;

@FindBy(id="input-email")
WebElement emailAddressFeild;

@FindBy(id="input-telephone")
WebElement TelephoneFeild;

@FindBy(id="input-password")
WebElement passwordFeild;

@FindBy(id="input-confirm")
WebElement confirmPasswordFeild;
				
@FindBy(xpath="//input[@name='agree']")
WebElement privacyPolicyFeild;

@FindBy(xpath="//input[@value='Continue']")
WebElement continueButton;

@FindBy(xpath="//label[@class='radio-inline'][2]")
WebElement radiobutton;



	//create a  LoginPage constructor 	
	public RegisterPage(WebDriver driver) {
		
		this.driver= driver;
		
		// To avoid Stale Element Exception  pageFactory design pattern provides method;call the method below
		PageFactory.initElements(driver, this);	//this means HomePage.java
			
	}	
	
//Actions
	
public void enterFirstName(String firstNameText) {
	firstnameFeild.sendKeys(firstNameText);
}

public void enterLastName(String lastNameText) {
	lastnameFeild.sendKeys(lastNameText);
}
	
public void enterEmailId(String email) {
	emailAddressFeild.sendKeys(email);
}
	
public void enterTelephone(String TelePhoneText)	{
	TelephoneFeild.sendKeys(TelePhoneText);
}
	
public void enterPassword(String PasswordText) {
	passwordFeild.sendKeys(PasswordText);
}

public void enterconfirmPassword(String PasswordText) {
	confirmPasswordFeild.sendKeys(PasswordText);
}

public void selectPrivacyPolicyButton() {
	privacyPolicyFeild.click();
	
	
}

public void selectRadioButton() {
	radiobutton.click();
}

/*public void clickOnContinueButton() {
	continueButton.click();
}*/


public AccountSucessPage clickOnContinueButton() {
	continueButton.click();
	return new AccountSucessPage(driver);
}



public AccountSucessPage  registerWithMandatoryFeilds(String firstNameText,String lastNameText, String email,String TelePhoneText, String PasswordText) {
	firstnameFeild.sendKeys(firstNameText);
	lastnameFeild.sendKeys(lastNameText);
	emailAddressFeild.sendKeys(email);
	TelephoneFeild.sendKeys(TelePhoneText);
	passwordFeild.sendKeys(PasswordText);
	confirmPasswordFeild.sendKeys(PasswordText);
	privacyPolicyFeild.click();
	continueButton.click();
	return new AccountSucessPage(driver);
}


public AccountSucessPage registerWithAllFeilds(String firstNameText,String lastNameText, String email,String TelePhoneText, String PasswordText) {
	
	firstnameFeild.sendKeys(firstNameText);
	lastnameFeild.sendKeys(lastNameText);
	emailAddressFeild.sendKeys(email);
	TelephoneFeild.sendKeys(TelePhoneText);
	passwordFeild.sendKeys(PasswordText);
	confirmPasswordFeild.sendKeys(PasswordText);
	radiobutton.click();
	privacyPolicyFeild.click();
	continueButton.click();
	return new AccountSucessPage(driver);	
			
}













	

}
