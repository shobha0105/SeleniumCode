package runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="src\\test\\java\\features" , 
		glue= {"stepdef"},
		tags= {}, //~ for NOT //without ~ for running specific feature file
		monochrome=true, //for the output to be readable
		dryRun=false
		
		
		
		
		)
public class Runner {

}