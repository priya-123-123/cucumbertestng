package com.example.Cucumber_TestNG_Practice.definitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginPageDefinitions {
	private static WebDriver driver;
	public final static int TIMEOUT = 5;
	@Before
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TIMEOUT));
	}

@Given("User is on HRMLogin page {string}")
public void user_is_on_hrm_login_page(String url) {
    driver.get(url);
    
}

@When("User enters username as {string} and password as {string}")
public void user_enters_username_as_and_password_as(String userName, String password) {
    
   driver.findElement(By.name("username")).sendKeys(userName);
   driver.findElement(By.name("password")).sendKeys(password);
   driver.findElement(By.xpath("//button[@type='submit']")).click();
   //go to next page
}

@Then("User should be able to login successfully and new page open")
public void user_should_be_able_to_login_successfully_and_new_page_open() {
   String homePageHeading=driver.findElement(By.xpath("//h6[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']")).getText();
   Assert.assertEquals(homePageHeading, "Dashboard");
   
}


@Then("User should be able to see error message {string}")
public void user_should_be_able_to_see_error_message(String expectedErrorMessage) {
	String actualErrorMessage = driver.findElement(By.xpath("//p[@class='oxd-text oxd-text--p oxd-alert-content-text']")).getText();
    Assert.assertEquals(actualErrorMessage, expectedErrorMessage);
}

@After
public void teardown() {
	driver.quit();
}

}
