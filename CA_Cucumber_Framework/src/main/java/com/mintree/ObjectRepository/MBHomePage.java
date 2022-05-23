package com.mintree.ObjectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MBHomePage {
	// Assign locator value
	// Click on Sign in or join
	@FindBy(xpath = "/html[1]/body[1]/div[3]/div[1]/div[1]/header[1]/div[2]/div[2]/div[1]/div[2]/div[1]/ul[1]/li[6]/a[1]/span[2]")
	WebElement signin;

	// Click on sign in button
	@FindBy(xpath = "/html[1]/body[1]/div[3]/div[1]/div[1]/header[1]/div[2]/div[2]/div[1]/div[2]/div[1]/ul[1]/li[6]/div[1]/div[2]/form[1]/div[3]/button[1]")

	WebElement signinButton;

	// to return obj
	public WebElement signinObj() {
		return (signin);
	}

	public WebElement signinButton() {
		return (signinButton);
	}

}
