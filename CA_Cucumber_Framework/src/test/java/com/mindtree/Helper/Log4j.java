package com.mindtree.Helper;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;


public class Log4j {
	private Logger logger;
	public WebDriver driver;
  @Test
  public void setUp() {
	  logger=Logger.getLogger("Log4j.class");
		PropertyConfigurator.configure("log4j.properties");
		System.setProperty("webdriver.chrome.driver", "./Drivers\\chromedriver.exe");
		logger.info("Browser executable file running");
		driver=new ChromeDriver();
		logger.info("Browser launched");
		driver.get("https://www.marriott.com/default.mi");
		logger.info("Application opened");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//Mousehover on Signup or join
		Actions ac = new Actions(driver);
		ac.moveToElement(driver.findElement(By.xpath("//a[@aria-expanded='true']//span[@class='m-header__top-nav-txt d-lg-block t-font-xs'][normalize-space()='Sign In or Join']"))).perform();
		//To click on sign in link
		driver.findElement(By.xpath("//button[@class='signin-btn t-subtitle-l custom_click_track track-completed']")).click();
	  
  }
  
 
  
  
}
