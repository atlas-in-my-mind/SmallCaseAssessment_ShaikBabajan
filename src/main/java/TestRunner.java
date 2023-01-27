
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/main/java/Features",
        tags = "@Regression"
        ,glue={"StepDefinitions", "MyHooks"},
        plugin = {"pretty", "html:target/cucumber-reports/report.html"},
        dryRun = false,
        monochrome = true
)

public class TestRunner {
}
