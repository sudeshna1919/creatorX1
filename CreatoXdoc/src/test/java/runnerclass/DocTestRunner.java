package runnerclass;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features ="src/test/resources/Features",
    glue ={"steps"},
    plugin = {"pretty", "html:target/cucumber-reports/cucumber.html"},
    monochrome= true,
    tags = "not @skip" // Exclude scenarios tagged with @skip
)
public class DocTestRunner {

}
