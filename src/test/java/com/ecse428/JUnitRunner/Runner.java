package com.ecse428.JUnitRunner;

import org.junit.runner.RunWith;        
import cucumber.api.CucumberOptions;        
import cucumber.api.junit.Cucumber;     

@RunWith(Cucumber.class)                
@CucumberOptions(features="src/main/resources",glue={"com.ecse428.StepDefinition"})                       
public class Runner                 
{       

}