package CucumberRunner;



import org.junit.runner.RunWith;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;  

@RunWith(Cucumber.class) 
@CucumberOptions(
		features="src/test/resources/FeatureFile",
		glue={"StepDefinitions"},
		plugin = {"pretty"},
		monochrome = true,
		tags ="@TechExam2"
		)

public class TestRunner {
	
//	static initWeb initialize = new initWeb();
////	 @BeforeClass
////	    public static void goToURL() {
////		
////		 initialize.webChrome("https://google.com");
////	 }
////
////
////	    @AfterClass
////	    public static void tearDown() {
////	    	initialize.closeBrowser();
////	    
////	    }
//	
}
