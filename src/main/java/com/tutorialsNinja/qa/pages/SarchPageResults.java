package com.tutorialsNinja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SarchPageResults {
 public WebDriver driver;
	
	
//Objects	
@FindBy(xpath=" //a[contains(text(),'HP LP3065')]")	
private WebElement validHPProduct;

@FindBy(xpath="//div[@id='content']/h2/following-sibling::p")
private WebElement inValidproductHonda;


@FindBy(xpath="//div[@id='content']/h2/following-sibling::p")
private WebElement blankSearchResult;
//create a constructor 
public SarchPageResults(WebDriver driver) {
	this.driver=driver;
//To avoid Stale Element Exception  pageFactory design pattern provides method;call the method below
PageFactory.initElements(driver, this);	//this means HomePage.java
	
	
}


//Actions
public boolean dispalyStatusOfValidHPProduct() {
	 boolean displayStatus= validHPProduct.isDisplayed();
	 return displayStatus;
}

public String enterInvalidProductHondaintoSearchFeild() {
 String nosuchproductText =	inValidproductHonda.getText();
 return nosuchproductText;
}

public String enternoInputInSearchFeild() {
String blankInput=	  blankSearchResult.getText();
return  blankInput; 
}
























}
