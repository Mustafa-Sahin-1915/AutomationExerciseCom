package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"@target/failedRerun.txt"},//path of features folder
        glue={"stepdefinitions","hooks"}, //path of the step definitions folder
        dryRun = false,
        tags = "",
        monochrome = true,
        plugin = {
                "pretty", //prints gherkin step on the console
                "html:target/htmlReports/cucumber-default-report.html",
                "json:target/jsonReports/cucumber-report.json",
                "junit:target/xml-report/cucumber-report.xml",
                "rerun:target/failedRerun.txt"
        }
)
public class FailedScenarioRunner {
}
