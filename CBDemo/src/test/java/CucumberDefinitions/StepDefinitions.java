package CucumberDefinitions;

import Pages.logIN;
import Pages.productPage;
import Pages.resulPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.example.Base.BaseTest;

import org.example.Base.TestContextSetup;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class StepDefinitions extends BaseTest {

    private WebDriver driver;
    private logIN loginPage;
    private productPage pp;
    private resulPage rP;
    TestContextSetup testContextSetup;

    // Constructor to initialize WebDriver from BaseTest

public StepDefinitions(TestContextSetup testContextSetup){
    this.testContextSetup=testContextSetup;
    loginPage=testContextSetup.pageObjectManager.loginScreen();
}

    @Given("User has logged in the ecommerce website with {string} {string}")
    public void userHasLoggedIn(String username, String password) {
        // Login action
       // loginPage=setUp();
       pp = loginPage.logged(username,password);
    }

    @When("I ordered the product {string}")
    public void i_ordered_the_product(String product) {
        List<WebElement> prod = pp.getPro();
        rP = pp.findProduct(prod, product);
    }

    @When("Check out the submit order {string}")
    public void check_out_the_submit_order(String product) {
        Boolean isThere = rP.getHeaders(product);
        Assert.assertTrue(isThere);
    }

    @Then("Ensure the ordered messages {string}")
    public void ensure_the_ordered_messages(String message) {
        String cnfMessage = rP.finalresult();
        Assert.assertTrue(cnfMessage.equalsIgnoreCase(message));
    }
}
