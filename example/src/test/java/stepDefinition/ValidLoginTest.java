package stepDefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ValidLoginTest {
	
	public WebDriver driver;
	
	@Given("user should be in login page")
	public void user_should_be_in_login_page() {
	    System.setProperty("webdriver.chrome.driver", "./exes/chromedriver.exe");
	    driver = new ChromeDriver();
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	    driver.get("http://localhost:8888");
	}

	@When("login with valid credentials")
	public void login_with_valid_credentials() {
	    driver.findElement(By.name("username")).sendKeys("admin");
	    driver.findElement(By.name("pwd")).sendKeys("manager");
	    driver.findElement(By.xpath("//input[@type='submit']")).click();
	}

	@Then("verify the home page")
	public void verify_the_home_page() {
	    System.out.println(driver.getTitle());
	}

}
