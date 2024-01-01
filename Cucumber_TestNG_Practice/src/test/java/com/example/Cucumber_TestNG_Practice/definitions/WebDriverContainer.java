package com.example.Cucumber_TestNG_Practice.definitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class WebDriverContainer extends BaseClass {
public WebDriver driver;;

@Before
public void setup() {
 driver=getDriver();
}

@After
public void teardown() {
   driver.quit();
}

}
