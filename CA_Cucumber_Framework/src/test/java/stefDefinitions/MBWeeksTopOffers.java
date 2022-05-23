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

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MBWeeksTopOffers {
	public static WebDriver driver;

	@When("^Initialize browser$")
	public void initialize_browser() {
		System.setProperty("webdriver.chrome.driver", "./Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.marriott.com/default.mi");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

	@Then("^Go to Week's top offer page$")
	public void go_to_page() {
		// To scrolldown
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,2550)", "");
		// Mouse Hover on This Week's top offers
		Actions ac = new Actions(driver);
		ac.moveToElement(driver.findElement(By.xpath("//h2[@id='cardcarousel_title_desktop']"))).clickAndHold();

	}

	@Then("^Click on link$")
	public void click_on_link() {
		WebElement link = driver.findElement(By.xpath(
				"/html[1]/body[1]/main[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[11]/section[1]/div[1]/div[2]/a[1]/span[1]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", link);
	}

	@Then("^Highlight the text$")
	public void highlight_text() throws IOException {
		// To highlight the Great travel starts
		WebElement exploreHomesTxt = driver.findElement(By.xpath("//h1[@class='t-color-inverse']"));
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].style.border='2px solid red'", exploreHomesTxt);
		// to take screenshot
		File f = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(f, new File("./Screenshots\\ThisWeek_Top_Offers_screenshot01.png"));
		System.out.println("The Screenshot is captured.");
	}
	@Then("^Closes the browser$")
	public void closes_browser() {
		driver.close();
	}

}
