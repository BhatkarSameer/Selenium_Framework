package Runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        //Specify feature file destination
        features = "src\\test\\java\\Features",

        //Specify stepDefinitions location
        glue = "StepDefinitions",

        monochrome = true,

        //Tags help grouping specific related scenarios
        tags = {},

        //Report config
        plugin = {"pretty",
                "html:target\\reports\\cucumber",
                "json:target\\reports\\cucumber.json"
        }
)

public class TestRunner {

    //Runner Main

}