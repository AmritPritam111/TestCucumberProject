package com.mintree.ObjectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MBLoginPage {
	// Click on email
	@FindBy(css="input[name='userID']")
	WebElement email;

	// Click on password
	@FindBy(xpath = "//input[@id='signin-user-password']")
	WebElement password;
	
	public WebElement email() {
		return(email);
	}
	public WebElement password() {
		return(password);
	}

}
