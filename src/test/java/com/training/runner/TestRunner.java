package com.training.runner;




import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;



@CucumberOptions(features= {"C:\\Users\\vasuk\\eclipse-workspace\\CucumberSalesForce\\resources\\features\\SalesforceLogin.feature"},
glue= {"com.training.steps"})

public class TestRunner extends AbstractTestNGCucumberTests {

}
