package practice.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SamplExample {
	public WebDriver driver;
	
	@BeforeTest
	public void beforeTestCase1()
	{
		System.setProperty("webdriver.chrome.driver", "./exes/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://demo.automationtesting.in/Register.html");
	}

	@Test
	public void testCase1()
	{
		String title = driver.getTitle();
		System.out.println("Title is: "+title);
	}
	
	@AfterTest
	public void afterTestCase1()
	{
		driver.close();
	}

}
