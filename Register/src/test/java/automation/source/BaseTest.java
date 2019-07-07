package automation.source;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BaseTest {

	public WebDriver driver;
	public Properties prop;
	FileInputStream fis;
	public Logger log;
	
	@BeforeMethod
	public void testInvokeBrowser() throws IOException
	{
		PropertyConfigurator.configure(System.getProperty("user.dir")+"/propertiesFile/log4j.properties");
		log = Logger.getLogger("BaseTest");
		log.info("************ startting base test *********************");
		log.debug("opening browser");
		prop = new Properties();
		fis = new FileInputStream(System.getProperty("user.dir")+"/propertiesFile/config.properties");
		prop.load(fis);
		
		String brName = prop.getProperty("browser");
		
		if(brName.equalsIgnoreCase("Chome"))
		{
			System.setProperty("webdriver.chome.driver", "./exes/chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--start-maximized");
			driver = new ChromeDriver(options);
		}
		else
		{
			System.setProperty("webdriver.gecko.driver", "./exes/geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
		log.debug("entreing url");
		driver.get(prop.getProperty("url"));
	}
	
	@Test
	public void testprop()
	{
		log.debug("printing in console");
		System.out.println("print");
	}
	
	@AfterMethod
	public void testCloseBrowser()
	{
		log.debug("closing the browser");
		driver.close();
	}
}
