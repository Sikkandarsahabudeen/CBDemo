package CucumberDefinitions;
import Pages.logIN;
import Pages.productPage;
import io.cucumber.java.en.*;
import org.example.Base.TestContextSetup;
import org.testng.Assert;

public class LoginSteps {

    TestContextSetup testContextSetup;
    logIN loginPage;
    productPage pp;


    public LoginSteps(TestContextSetup testContextSetup){
        this.testContextSetup=testContextSetup;
        loginPage=testContextSetup.pageObjectManager.loginScreen();
    }


    @Given("User has to landed-on in the ecommerce website with {string} {string}")
    public void userHasLoggedIn(String username, String password) {
        // Login action
        // loginPage=setUp();
        pp = loginPage.logged(username,password);
    }

    @Then("Ensure the messages {string}")
    public void getTitle(String Title){
        String message=testContextSetup.driver.getTitle();
        Assert.assertEquals(message,Title);

    }
}
