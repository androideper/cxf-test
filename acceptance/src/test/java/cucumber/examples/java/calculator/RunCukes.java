package cucumber.examples.java.calculator;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


/**
 * @author <a href="mailto:androideper@gmail.com"> Android Developer</a>
 *         Date: 11/16/2014 - 5:19 AM
 */
@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = "json:target/cucumber-report.json",
        features = "src/test/resources/features",
        strict = true,
        glue = "steps"
)
public class RunCukes {
}

