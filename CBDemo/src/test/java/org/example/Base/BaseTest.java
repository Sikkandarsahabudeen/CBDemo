package org.example.Base;

import Pages.logIN;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import utilities.settings;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import static utilities.readerfromProprties.populateSettings;

public class BaseTest {

    public WebDriver driver;
    public logIN lg;


    // Set up method to initialize WebDriver and open the region-specific URL
  //  @BeforeClass(alwaysRun = true)
    public WebDriver DriverManager() {
        populateSettings();
        String US=settings.US;
        String UK=settings.UK;
        String CA=settings.CA;
        String HK=settings.HK;
        String ZA=settings.ZA;
        String AU=settings.AU;

        // Get region from environment variable (e.g., set in Jenkins)
        String region = System.getenv("REGION");  // Or some other source

        if (driver == null) {
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.manage().window().maximize();
            // Debugging step
            System.out.println("System Launched "+US);
            driver.get(US);
        }
        return driver;
    }

    // Take screenshot method
    public String takeScreenshot(String testcasename, WebDriver driver) {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        String path = System.getProperty("user.dir") + "/reports/" + testcasename + ".png";
        File file = new File(path);
        try {
            FileUtils.copyFile(source, file);
        } catch (IOException e) {
            throw new RuntimeException("Failed to capture screenshot", e);
        }
        return path;
    }

    // After test cleanup to quit the driver
    @AfterClass(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            driver.quit(); // Quit the driver after test execution
        }
    }
}
