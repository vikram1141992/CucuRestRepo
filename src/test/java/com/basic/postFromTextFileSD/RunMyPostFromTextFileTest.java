package com.basic.postFromTextFileSD;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;
	
@RunWith(Cucumber.class)
@CucumberOptions(
			monochrome=true,
			dryRun=false,
			features= {"src/test/resources/com/basic/postFromTextFileFF/"},
			glue={"com.basic.postFromTextFileSD"},
			plugin={"pretty",
					"html:target/cucumber-htmlreport",
					"json:target/cucumber-report6.json"
			}
		)
		

public class RunMyPostFromTextFileTest {


}
