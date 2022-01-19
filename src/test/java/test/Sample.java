package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


public class Sample {

	@Test
	public void sample()
	
	
	{
		WebDriverManager.chromedriver().setup();
		System.getProperty("webdriver.chrome.driver", "chromedriver");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("headless");
		options.addArguments("disable-infobars"); 
		options.addArguments("--disable-extensions");
		options.addArguments("--disable-dev-shm-usage");
		options.addArguments("--no-sandbox"); 

		System.out.println("Jenkins Build Run");
		WebDriver driver =new ChromeDriver(options);
		driver.get("https://www.google.com/");
		System.out.println(driver.getTitle());
	}

}
