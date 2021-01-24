package com.basic.GetAndValidateHeaders;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		
		monochrome=true,
		dryRun=false,
		features = {"src/test/resources/com/basic/GetAndValidateHeaders/"},
		glue ={"com.basic.GetAndValidateHeaders"},
		plugin={"pretty",
				"html:target/cucumber-htmlreport",
				"json:target/cucumber-report312.json"
		}

		)

public class RunnerGetAndValidateHeadersTest {
	
	
	
}
