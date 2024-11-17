package CucumberRunners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
@CucumberOptions(
        features = "src/test/java/Cucumber",
        glue = "CucumberDefinitions",

        plugin = {"html:target/cucumber.html", "json:target/cucumber.json",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                "rerun:target/failed_scenarios.txt"})

public class TestRunner extends AbstractTestNGCucumberTests {
    // Runs tests based on CucumberOptions
}


//    private TestNGCucumberRunner testNGCucumberRunner;
//
//    @BeforeClass(alwaysRun = true)
//    public void setUpClass() throws Exception {
//        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
//    }
//
//    // Use @Test with the @DataProvider to run scenarios
//    @Test(groups = "cucumber", description = "Run Cucumber Scenarios", dataProvider = "scenarios")
//    public void testRunScenario(String scenario) {
//        testNGCucumberRunner.runScenario(scenario);
//    }
//
//    // DataProvider supplies the scenarios to run
//    @DataProvider
//    public Object[][] scenarios() {
//        return testNGCucumberRunner.provideScenarios();  // Automatically supplies scenario data
//    }
//
//    // Cleanup after test execution
//    @AfterClass(alwaysRun = true)
//    public void tearDownClass() {
//        if (testNGCucumberRunner != null) {
//            testNGCucumberRunner.finish();  // Finish the runner to clean up after tests
//        }
//    }
////
////    @BeforeClass(alwaysRun = true)
////    public void setUpClass() throws Exception {
////        // Initialize TestNGCucumberRunner with the current class
////        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
////    }
////
////    // DataProvider for providing the scenarios to be run
////    @DataProvider
////    public Object[][] scenarios() {
////        return testNGCucumberRunner.provideScenarios();
////    }
////
////    // Test method to run scenarios using Scenario
////    @Test(groups = "cucumber", description = "Run Cucumber Scenarios", dataProvider = "scenarios")
////    public void testRunScenario(Scenario scenario) {
////        // Run the scenario using Scenario
////        testNGCucumberRunner.runScenario(scenario);
////    }


