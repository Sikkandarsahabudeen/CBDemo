package CucumberDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.example.Base.TestContextSetup;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import utilities.ExcelReader;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Hooks {
    TestContextSetup testContextSetup;

    public Hooks(TestContextSetup testContextSetup) {

        this.testContextSetup = testContextSetup;
    }
    public void injectData() throws Exception {
        // Read data from Excel
        List<String[]> excelData = ExcelReader.readExcel("C:\\Users\\vishn\\OneDrive\\Documents\\Automation Project\\Logindata.xlsx", "Sheet1");

        // Assuming the first row contains headers, skipping it for data processing
        for (int i = 1; i < excelData.size(); i++) {
            String[] row = excelData.get(i);
            String username = row[0];
            String password = row[1];
            String message = row[2];

            // Use this data for further processing or verification
            System.out.println("Username: " + username + ", Password: " + password + ", Expected message: " + message);
        }

}

    @After
    public void AfterScenario() throws IOException {

        testContextSetup.Btest.driver.quit();

    }

    @AfterStep
    public void AddScreenshot(Scenario scenario) throws IOException {
        WebDriver driver = testContextSetup.Btest.DriverManager();
        if (scenario.isFailed()) {
            //screenshot
            File sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            byte[] fileContent = FileUtils.readFileToByteArray(sourcePath);
            scenario.attach(fileContent, "image/png", "image" );

        }
    }
}

