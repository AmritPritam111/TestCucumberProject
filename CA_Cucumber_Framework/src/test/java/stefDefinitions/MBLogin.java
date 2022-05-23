package stefDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;








public class MBLogin {
	public static WebDriver driver;

	@Given("^initialize browser$")
	public void open_chrome_browser_and_enter_url() throws InterruptedException   {
		System.setProperty("webdriver.chrome.driver", "./Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.marriott.com/default.mi");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		
		
	}
		

	@When("^User go to sign in or join option$")
	public void go_to_sign_in_option() {
		
		// Mouse hover on Sign in or Join
		Actions ac = new Actions(driver);
		ac.moveToElement(driver.findElement(By.xpath(
				"//a[@aria-controls='sign-in-tooltip-id']")))
				.perform();
		System.out.println("Mouseover Completed");

		// Click on join link
		
		WebElement join=driver.findElement(By.xpath(
				"/html[1]/body[1]/div[3]/div[1]/div[1]/header[1]/div[2]/div[2]/div[1]/div[2]/div[1]/ul[1]/li[6]/div[1]/div[1]/a[1]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();",join);

		// To scroll down
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,450)", "");

	}

	@Then("^User click on join option$")
	public void click_on_join_option() {
		

		// To scroll down
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,450)", "");

	}

	@Then("^User fill the require text$")
	public void fill_the_require_textbox() {
		// To enter first name
		driver.findElement(By.xpath(
				"//input[@id='field-first-name']"))
				.sendKeys("Amrit");

		// To enter last name
		driver.findElement(By
				.xpath("//input[@id='field-last-name']"))
				.sendKeys("Pritam");

		// To click on country
		driver.findElement(
				By.xpath("//div[@class='selectric']"))
				.click();

		// To select United Arab Emirates
		driver.findElement(By.xpath("//li[@id='selectric-opt0226']")).click();

		// To scroll down
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("window.scrollBy(0,450)", "");

		// To enter email
		driver.findElement(By.xpath("//input[@id='field-email']")).sendKeys("ab99@gmail.com");

		// To enter password
		driver.findElement(By.xpath("//input[@id='field-password']")).sendKeys("BankLogin13");

		// To enter confirm password
		driver.findElement(By.xpath("//input[@id='field-password-confirmation']")).sendKeys("BankLogin13");

	}

	@Then("^User successfully register$")
	public void click_on_join_button()throws Throwable {
		// To click on Join button
		driver.findElement(By.xpath("//button[@id='enroll-join']")).click();
		System.out.println("Registration Successful");

		// To close the window
		driver.close();
	}

}