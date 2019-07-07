package in.automationtesting.demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestRegister {
	
	WebDriver driver;
	
	@BeforeMethod
	public void testInvokeBrowser()
	{
		System.setProperty("webdriver.gecko.driver", "./exes/geckodriver.exe");
		driver = new FirefoxDriver();
	}
	@Test
	public void testApplication()
	{
		driver.get("http://demo.automationtesting.in/Register.html");
	}
	@AfterMethod
	public void testCloseBrowser()
	{
		driver.close();
	}

}
