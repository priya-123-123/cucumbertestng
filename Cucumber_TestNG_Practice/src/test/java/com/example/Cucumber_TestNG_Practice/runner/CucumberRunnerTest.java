package com.example.Cucumber_TestNG_Practice.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(tags="", features = {"src/test/resource/features/AddEmploymentSatus.feature"}, 
glue = {"com.example.Cucumber_TestNG_Practice.definitions"},
plugin = {"pretty","html:target/cucumber-reports/report.html"},
monochrome = true )
public class CucumberRunnerTest extends AbstractTestNGCucumberTests{

}
