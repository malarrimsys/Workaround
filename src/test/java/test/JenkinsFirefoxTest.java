package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JenkinsFirefoxTest {
	public WebDriver driver ;
	@Test
	public void firefoxTest()
	{
		WebDriverManager.firefoxdriver().setup();
		System.getProperty("webdriver.gecko.driver", "geckodriver");
		driver = new FirefoxDriver();
		driver.get("https://intuitivesurgical.dev-rimsys.com/login");
		
	}

}
