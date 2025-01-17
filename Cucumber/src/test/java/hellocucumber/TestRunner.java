package hellocucumber;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

import static io.cucumber.junit.platform.engine.Constants.PLUGIN_PROPERTY_NAME;

// @Suite
// @IncludeEngines("cucumber")
// @SelectClasspathResource("hellocucumber")
// @ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty")
// public class RunCucumberTest {
// }


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/features",
    glue = "stepdefinitions",
    plugin = {"pretty", "html:target/cucumber-reports"}
)
public class TestRunner {
}