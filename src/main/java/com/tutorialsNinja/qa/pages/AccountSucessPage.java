package com.tutorialsNinja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountSucessPage {
 public WebDriver driver;

//objects
@FindBy(xpath="//div[@id='content']//h1")	
WebElement accountSucessPage;	
	


//create a constructor AccountSucessPage
public  AccountSucessPage(WebDriver driver) {
	this.driver=driver;
	// To avoid Stale Element Exception  pageFactory design pattern provides method;call the method below
		PageFactory.initElements(driver, this);	//this means HomePage.java
			
}

//Actions
public String accountScuessMessage() {
String accountSucessPageHeadingText=	accountSucessPage.getText();
	return accountSucessPageHeadingText;
}















}
