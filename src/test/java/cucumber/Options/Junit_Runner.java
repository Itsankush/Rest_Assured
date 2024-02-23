package cucumber.Options;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/features", glue = "stepDefinations", plugin = { "pretty",
		"html:target/cucmber.html",
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" }, 
monochrome = true, 
tags = "@UserCreation", 
dryRun = false)

public class Junit_Runner {

}
