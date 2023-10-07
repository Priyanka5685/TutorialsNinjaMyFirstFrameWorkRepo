package com.tutorialsNinja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
 public WebDriver driver;	
	
//Objects

@FindBy(xpath="//a[@title='My Account']")
 private WebElement myAccount;
@FindBy(xpath="//a[contains(text(),'Login')]")//Login
 private WebElement LoginOption;	
@FindBy(xpath="//a[text()='Register']")	//Register
private WebElement RegisterOption;

@FindBy(xpath="//input[@name='search']")//search
 private WebElement SearchBoxFeild;	

@FindBy(xpath="//span[@class='input-group-btn']")//search	
 private WebElement SearchButton;	

@FindBy(xpath="//ul[@class='list-inline']//li[1]//a//i")	//phone
private WebElement phone;
	
@FindBy(xpath="//a[@title='Shopping Cart']")
private WebElement cart;








//create a constructor 
public HomePage(WebDriver driver) {
	this.driver=driver;
// To avoid Stale Element Exception  pageFactory design pattern provides method;call the method below
PageFactory.initElements(driver, this);	//this means HomePage.java
	
	
}




//Actions

/*public void selectLoginOption() {
	LoginOption.click();
}*/

public LoginPage navigateToLoginPage() {
	myAccount.click();LoginOption.click();
	return new LoginPage(driver);
}

/*public void selectRegisterOption() {
	RegisterOption.click();
	
}*/

public RegisterPage navigateToRegisterPage() {
	myAccount.click();	
	RegisterOption.click();
	return new RegisterPage(driver);
	
}


public void enterValidProducts(String searchText) {//search
	SearchBoxFeild.sendKeys(searchText);
}

public SarchPageResults clickOnSearchButton() {//search
	SearchButton.click();
	
	return new SarchPageResults(driver);
}

/*public void clickOnSearchButton() {//search
	SearchButton.click();
}*/

public void clickOnMyAccount() {
	myAccount.click();
}

public void clickOnPhone() {
	 phone.click();
}

public void clickToCartButton() {
	cart.click();	
	
}






}
