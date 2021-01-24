package com.basic.GoogleTest;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(
		
		features = {"src/test/resources/com/basic/GoogleTest/FirstGoogleTestFF.feature"},
		glue ={"com.basic.GoogleTest"},
		plugin={"pretty",
				"html:target/cucumber-htmlreport",
				"json:target/cucumber-report5.json"
		}
		
		)

public class RunnerFirstGoogleTest {
	
}
