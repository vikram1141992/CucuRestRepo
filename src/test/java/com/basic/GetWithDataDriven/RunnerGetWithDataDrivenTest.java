package com.basic.GetWithDataDriven;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		
		monochrome=true,
		dryRun=false,
		features = {"src/test/resources/com/basic/GetWithDataDriven/GetRequestWithDataDriven.feature"},
		glue ={"com.basic.GetWithDataDriven"},
		plugin={"pretty",
				"html:target/cucumber-htmlreport",
				"json:target/cucumber-report1.json"
		}

		)

public class RunnerGetWithDataDrivenTest {
	
	
}
