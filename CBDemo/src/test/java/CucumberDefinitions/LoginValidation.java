package CucumberDefinitions;

import Pages.logIN;
import Pages.productPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.example.Base.TestContextSetup;
import org.testng.Assert;

public class LoginValidation {
    TestContextSetup testContextSetup;
    logIN loginPage;
    productPage pp;


    public LoginValidation(TestContextSetup testContextSetup){
        this.testContextSetup=testContextSetup;
        loginPage=testContextSetup.pageObjectManager.loginScreen();
    }

    @Given("User has to landedon in the ecommerce website with {string} {string}")
    public void userHasLoggedIn(String username, String password) {
        // Login action
        // loginPage=setUp();
        pp = loginPage.logged(username,password);
    }

    @Then("Ensure the Title messages {string}")
    public void getTitle(String expectmessage){
        String message=testContextSetup.driver.getTitle();
        Assert.assertEquals(message,expectmessage);

    }

}
