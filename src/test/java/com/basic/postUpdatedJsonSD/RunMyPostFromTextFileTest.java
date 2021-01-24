package com.basic.postUpdatedJsonSD;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;
	
@RunWith(Cucumber.class)
@CucumberOptions(
		
			monochrome=true,
			dryRun=false,
			features= {"src/test/resources/com/basic/postUpdatedJsonFF/"},
			glue={"com.basic.postUpdatedJsonSD"},
			plugin={"pretty",
					"html:target/cucumber-htmlreport",
					"json:target/cucumber-report8.json"
			}
		)
		

public class RunMyPostFromTextFileTest {


}
