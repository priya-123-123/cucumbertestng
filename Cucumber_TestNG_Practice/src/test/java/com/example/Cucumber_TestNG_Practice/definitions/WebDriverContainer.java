package com.example.Cucumber_TestNG_Practice.definitions;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class WebDriverContainer extends BaseClass {
public WebDriver driver;;

@Before
public void setup() {
 driver=getDriver();
}


@After
public void teardown(Scenario scenario) {
	if(scenario.isFailed()) {
	String screenshotName = scenario.getName().replaceAll(" ", "_");
	try {
	TakesScreenshot ts = (TakesScreenshot) driver;
	File sourcePath = ts.getScreenshotAs(OutputType.FILE);
	File destinationPath = new File(
	System.getProperty("user.dir") + "\\target\\cucumber-reports\\screenshots\\" + screenshotName + ".png");
	FileUtils.copyFile(sourcePath, destinationPath);
	
	} catch (WebDriverException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	} 
	}
   driver.quit();
}

}
