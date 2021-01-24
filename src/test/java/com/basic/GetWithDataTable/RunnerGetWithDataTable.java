package com.basic.GetWithDataTable;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		
		monochrome=true,
		dryRun=false,
		features = {"src/test/resources/com/basic/GetWithDataTable/GetRequestWithDataTable.feature"},
		glue ={"com.basic.GetWithDataTable"},
		plugin={"pretty",
				"html:target/cucumber-htmlreport",
				"json:target/cucumber-report2.json"
		}
		)

public class RunnerGetWithDataTable {
	
	
}
