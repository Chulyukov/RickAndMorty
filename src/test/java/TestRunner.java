import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions (
        plugin = {"pretty","html:test-output",
        "json:target/cucumber-report/cucumber.json",
        "io.qameta.allure.cucumber6jvm.AllureCucumber6Jvm"},
        features = "src/test/resources/features",
        glue = {"StepsDefinition"},
        tags = "@Test"
)

public class TestRunner {
}