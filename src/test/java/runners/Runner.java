package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"./src/test/resources/features"},//path of features folder
        glue={"stepdefinitions","hooks"}, //path of the step definitions folder
        dryRun = false,
        tags = "@test_case_17",
        monochrome = true,
        plugin = {
                "pretty", //prints gherkin step on the console
                "html:target/htmlReports/cucumber-default-report.html",
                "json:target/jsonReports/cucumber-report.json",
                "junit:target/xml-report/cucumber-report.xml",
                "rerun:target/failedRerun.txt"
        }
)
public class Runner {
}
/*
Runner class is used to run the feature files
@RunWith:makes this class runnable
@CucumberOptions:
    1. features:path of the features folder
    2. glue: path of the step definitions folder
 */