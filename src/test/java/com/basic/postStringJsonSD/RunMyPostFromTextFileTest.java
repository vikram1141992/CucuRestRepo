package com.basic.postStringJsonSD;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;
	
@RunWith(Cucumber.class)
@CucumberOptions(
		
		monochrome=true,
		dryRun=false,
		plugin={"pretty",
				"html:target/cucumber-htmlreport",
				"json:target/cucumber-report7.json"
		}
		
		)

public class RunMyPostFromTextFileTest {


}
