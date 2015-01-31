package steps;

import calc.Calculator;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * @author <a href="mailto:androideper@gmail.com"> Android Developer</a>
 *         Date: 11/16/2014 - 9:40 PM
 */
public class MyStepdefs {
    private Calculator calculator;

    @Given("^a calculator I just turned on$")
    public void a_calculator_I_just_turned_on() throws Throwable {
        calculator = new Calculator();
    }

    @When("^I add (\\d+) and (\\d+)$")
    public void I_add_and(int firstNumber, int secondNumber) throws Throwable {
        calculator.push(firstNumber);
        calculator.push(secondNumber);
        calculator.add();
    }

    @Then("^the result is (\\d+)$")
    public void the_result_is(double expectedResult) throws Throwable {
        assertThat(calculator.getResult(), is(expectedResult));
    }

    @Given("^the previous entries:$")
    public void the_previous_entries() throws Throwable {
    }

    @When("^I press \\+$")
    public void I_press_() throws Throwable {
        // Express the Regexp above with the code you wish you had
        throw new PendingException();
    }
}
