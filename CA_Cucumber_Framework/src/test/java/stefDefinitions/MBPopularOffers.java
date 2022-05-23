package stefDefinitions;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MBPopularOffers {
	public static WebDriver driver;

	@Given("^First Initialize browser$")
	public void open_chrome_browser_and_enter_url() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.marriott.com/default.mi#");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

	@When("^User goes to popular offers link$")
	public void go_to_link() throws InterruptedException {
		// To scrolldown
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,750)", "");
		Actions ac = new Actions(driver);
		ac.moveToElement(driver.findElement(By.xpath(
				"//a[@class='hide-mobile custom_click_track m-link-tertiary-button track-completed']//span[contains(text(),'See More')]")))
				.clickAndHold();
		Thread.sleep(6000);

	}

	@Then("^User clicks on popular offers link$")
	public void click_on_link() {
		WebElement popularOffers = driver.findElement(By.xpath(
				"/html[1]/body[1]/main[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/section[1]/div[1]/div[2]/a[1]/span[1]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();",popularOffers);
		// To scroll down
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,550)", "");
	}

	@Then("^User verifys the title of the page and highlight it$")
	public void highlight_it() throws IOException {
		WebElement popularOffersTxt = driver
				.findElement(By.xpath("//h2[normalize-space()='Get Inspired: Marriott Picks for You']"));
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].style.border='2px solid red'", popularOffersTxt);
		// To take screenshot
		File f = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(f, new File("./Screenshots\\PopularOffers_seemore_screenshot01.png"));
		System.out.println("The Screenshot is captured.");
	}
	@Then("^Close the browser$")
	public void close_the_app() {
		driver.close();
	}
}
