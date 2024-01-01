package com.example.Cucumber_TestNG_Practice.definitions;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;
//when we have multiple step definition files then we should have a base class in which static webdriver is declared and a method which returns webdriver. This class is
//extended by all step definition and getdriver function is called to return the driver which is static and same for all definitions 
public class BaseClass {
	public  WebDriver driver;
	public WebDriver getDriver() {
		if(driver == null) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--start-maximized");
			driver = new ChromeDriver(options);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		}
		return driver;
	}

}
