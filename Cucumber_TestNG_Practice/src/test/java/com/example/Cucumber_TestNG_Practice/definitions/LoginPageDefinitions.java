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

import pageclasses.HomePage;
import pageclasses.LoginPage;


public class LoginPageDefinitions extends BaseClass{
	
	LoginPage lp;
	HomePage hp;
	public  WebDriver driver;
	public final static int TIMEOUT = 5;
	
	
		
	
@Before
public void setup() {
	driver=getDriver();
}

@Given("User is on HRMLogin page {string}")
public void user_is_on_hrm_login_page(String url) {
	
    driver.get(url);
    
}

@When("User enters username as {string} and password as {string}")
public void user_enters_username_as_and_password_as(String userName, String password) {
	lp=new LoginPage(driver);
    lp.enterUsername(userName);
    lp.enterpassword(password);
    lp.clickOnLoginButton();
    try {
		Thread.sleep(6000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	/*
	 * driver.findElement(By.name("username")).sendKeys(userName);
	 * driver.findElement(By.name("password")).sendKeys(password);
	 * driver.findElement(By.xpath("//button[@type='submit']")).click();
	 */
   //go to next page
}

@Then("User should be able to login successfully and new page open")
public void user_should_be_able_to_login_successfully_and_new_page_open() {
   hp=new HomePage(driver);
   String homePageHeading=hp.getHeadingtext();
   Assert.assertEquals(homePageHeading, "Dashboard");
   
}


@Then("User should be able to see error message {string}")
public void user_should_be_able_to_see_error_message(String expectedErrorMessage) {
	String actualErrorMessage = lp.getErrorMessage();
    Assert.assertEquals(actualErrorMessage, expectedErrorMessage);
}
@After
public void teardown() {
	driver.quit();
}


}
