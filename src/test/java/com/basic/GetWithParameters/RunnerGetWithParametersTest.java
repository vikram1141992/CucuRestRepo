package com.basic.GetWithParameters;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		
		monochrome=true,
		dryRun=false,
		features = {"src/test/resources/com/basic/GetWithParameters/GetRequestWithParameters.feature"},
		glue ={"com.basic.GetWithParameters"},
		plugin={"pretty",
				"html:target/cucumber-htmlreport",
				"json:target/cucumber-report3.json"
		}

		)

public class RunnerGetWithParametersTest {
	
	
	
}
