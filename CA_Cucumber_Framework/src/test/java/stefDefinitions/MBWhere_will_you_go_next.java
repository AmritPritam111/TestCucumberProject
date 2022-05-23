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

public class MBWhere_will_you_go_next {
	public WebDriver driver;

	@When("^User initialize browser$")
	public void initialize_browser() {
		System.setProperty("webdriver.chrome.driver", "./Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.marriott.com/default.mi#");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

	@Then("^User mouse hover on page$")
	public void mouse_hover_on_page() throws InterruptedException {
		// To scrolldown
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1350)", "");
		// Mouse hover on Where will you go next
		Actions ac = new Actions(driver);
		ac.moveToElement(driver.findElement(By.xpath(
				"//h2[@id='horizontalcarouselco_title_desktop']")))
				.clickAndHold();
		Thread.sleep(6000);

	}

	@Then("^User click on the page$")
	public void click_on_the_page() {
		WebElement goNext=driver.findElement(By.xpath(
				"/html[1]/body[1]/main[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[7]/div[1]/div[1]/div[1]/div[1]/section[1]/div[1]/div[2]/a[1]/span[1]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();",goNext);
	}

	@Then("^highlight the page$")
	public void highlight_the_page() throws IOException {
		// highlight the Bonvoy traveller part
		WebElement exploreTxt = driver.findElement(By.xpath("//img[@alt='Marriott Bonvoy Traveler']"));
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].style.border='2px solid red'", exploreTxt);
		// to take screenshot
		File f = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(f, new File("./Screenshots\\Wherewillyougo_explore_screenshot01.png"));
		System.out.println("The Screenshot is captured.");
	}
	@Then("^close the browser$")
	public void close_browser() {
		driver.close();
	}

}
