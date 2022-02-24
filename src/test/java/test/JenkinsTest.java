package test;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


public class JenkinsTest {
	public WebDriver driver;
	
	
	@Test(priority=1)
	public void sample() throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		System.getProperty("webdriver.chrome.driver", "chromedriver");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--no-sandbox"); // Bypass OS security model
		options.setHeadless(true);
//		//options.addArguments("--headless");// headless -> no browser window. needed for jenkins
		options.addArguments("disable-infobars"); // disabling infobars
		options.addArguments("--disable-extensions");// disabling extensions
		options.addArguments("--disable-dev-shm-usage");// overcome limited resource problems
		
		options.addArguments("--disable-features=VizDisplayCompositor");
		System.out.println("Jenkins Build Run");
		 driver =new ChromeDriver(options);
		
		JavascriptExecutor js =(JavascriptExecutor) driver;
		driver.manage().window().maximize();
		driver.get("https://intuitivesurgical.dev-rimsys.com/login");
		Thread.sleep(4000);
		System.out.println("*************************** "+driver.getTitle());
		//TakesScreenshot scrShot =((TakesScreenshot)driver);
	
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(100))
		        .pollingEvery(Duration.ofMillis(600)).ignoring(NoSuchElementException.class);
		WebElement foo= (WebElement) wait.until(new Function<WebDriver,WebElement>() {
			public WebElement apply(WebDriver driver) {
			return driver.findElement(By.id("username"));
			}});

		WebElement pwd =driver.findElement(By.id("password"));
		foo.sendKeys("surgical@yopmail.com");
		pwd.sendKeys("Surgical2@123456");
	
		Thread.sleep(2000);
		WebElement signin = driver.findElement(By.xpath("(//button[normalize-space()='Sign-In'])[1]"));

		signin.click();
		Thread.sleep(2000);
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrFile, new File("Screenshot"+new Timestamp(System.currentTimeMillis()).toString() +".png"));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	//@Test(priority=2)
	public void navigateToStandards()
	{
		WebElement std =driver.findElement((By.xpath("//li[@class='dropdown']//a[contains(@href,'/my-standards')]")));
		std.click();
	}

}

//WebDriverWait web_element = new WebDriverWait(driver,100); 
//web_element.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
//WebElement username =driver.findElement(By.id("username"));
//js.executeScript("document.getElementById('username').value='surgical@yopmail.com';" );
//js.executeScript("document.getElementById('password').value='Surgical2@123456';" );