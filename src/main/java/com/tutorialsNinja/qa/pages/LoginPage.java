package com.tutorialsNinja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
public	WebDriver driver;
	
@FindBy(xpath="//input[@id='input-email']")	
 private WebElement EmailAddressFeild;

@FindBy(xpath="//input[@id='input-password']")	
 private WebElement PasswordFeild;	

@FindBy(xpath="//input[@type='submit']")	
 private WebElement LoginButton;	

@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")
 private WebElement emailPasswordNotMatching;

@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")
private WebElement blankinputWarningMessage;


		
//create a  LoginPage constructor 	
public LoginPage(WebDriver driver) {
	
	this.driver= driver;
	
	// To avoid Stale Element Exception  pageFactory design pattern provides method;call the method below
	PageFactory.initElements(driver, this);	//this means HomePage.java
		
}

//actions
public void enterEmailAddress(String emailText) {//dont call this insted call login()
	EmailAddressFeild.sendKeys(emailText);
}

public void enterPassword(String passwordText) {//dont call this insted call login()
	PasswordFeild.sendKeys(passwordText);
}

public void clickOnLogin() {//dont call this insted call login()
	LoginButton.click();
}
public void login(String emailText,String passwordText  ) {
	EmailAddressFeild.sendKeys(emailText);
	PasswordFeild.sendKeys(passwordText);
	LoginButton.click();
}


public String invalidCredentialsWarningMessage() {
String warningText =	emailPasswordNotMatching.getText();
return warningText;
}

public String  blankInputWarningMessage() {
String blankWarningText=	blankinputWarningMessage.getText();
	return blankWarningText;
}



}
