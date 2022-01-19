package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


public class Sample {

	@Test
	public void sample()
	
	
	{
		WebDriverManager.chromedriver().setup();
		System.getProperty("webdriver.chrome.driver", "chromedriver");
		System.out.println("Jenkins Build Run");
		WebDriver driver =new ChromeDriver();
		driver.get("https://www.google.com/");
		System.out.println(driver.getTitle());
	}

}
