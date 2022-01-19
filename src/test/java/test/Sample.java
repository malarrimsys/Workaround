package test;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


public class Sample {

	@Test
	public void sample()
	
	
	{
		WebDriverManager.chromedriver().setup();
		System.getProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("headless");// headless -> no browser window. needed for jenkins
		options.addArguments("disable-infobars"); // disabling infobars
		options.addArguments("--disable-extensions");// disabling extensions
		options.addArguments("--disable-dev-shm-usage");// overcome limited resource problems
		options.addArguments("--no-sandbox"); // Bypass OS security model

		System.out.println("Jenkins Build Run");
		WebDriver driver =new ChromeDriver(options);
		
		JavascriptExecutor js =(JavascriptExecutor) driver;
	
		driver.get("https://intuitivesurgical.dev-rimsys.com/login");
		System.out.println("*************************** "+driver.getTitle());
		
//		WebElement username =driver.findElement(By.id("username"));
//		WebElement pwd =driver.findElement(By.id("password"));
//		username.sendKeys("surgical@yopmail.com");
//		pwd.sendKeys("Surgical2@123456");
		js.executeScript("document.getElementById('username').value='surgical@yopmail.com';" );
		js.executeScript("document.getElementById('password').value='Surgical2@123456';" );
		
			
		
	}

}
