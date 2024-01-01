package com.example.Cucumber_TestNG_Practice.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(tags="", features = {"src/test/resource/features"}, glue = {"com.example.Cucumber_TestNG_Practice.definitions"},
                 plugin = {})
public class CucumberRunnerTest extends AbstractTestNGCucumberTests{

}
