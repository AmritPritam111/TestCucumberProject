package com.mindtree.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mintree.ObjectRepository.MBHomePage;
import com.mintree.ObjectRepository.MBLoginPage;

public class MBLoginValidation {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "./Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.marriott.com/default.mi#");
		driver.manage().window().maximize();

		Thread.sleep(5000);

		// Mouse hover on Sign in or Join
		Actions ac = new Actions(driver);
		ac.moveToElement(driver.findElement(By.xpath(
				"/html[1]/body[1]/div[3]/div[1]/div[1]/header[1]/div[2]/div[2]/div[1]/div[2]/div[1]/ul[1]/li[6]/a[1]/span[2]")))
				.perform();
		System.out.println("Mouseover Completed on signin or join");

		MBHomePage mbHP = PageFactory.initElements(driver, MBHomePage.class);
		MBLoginPage mbLP = PageFactory.initElements(driver, MBLoginPage.class);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", mbHP.signinObj());
		
		System.out.println("Click completed");
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", mbLP.email());
		//To enter data
		WebElement element = driver.findElement(By.cssSelector("input[name='userID']"));
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].value='bm88@gmail.com';", element);
		
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", mbLP.password());
		//To enter data
		WebElement element1 = driver.findElement(By.xpath("//input[@id='signin-user-password']"));
		JavascriptExecutor jse1 = (JavascriptExecutor) driver;
		jse1.executeScript("arguments[0].value='Banklogin1356';", element1);
		
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", mbHP.signinButton());
		
		System.out.println("Signin successful");

		driver.close();

	}

	

}
