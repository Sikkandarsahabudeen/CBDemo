package SeleniumGrid;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Regiontest{

    private WebDriver driver;

    @Parameters("regionURL")
    @BeforeMethod
    public void setUp(String regionURL) {
        // Initialize WebDriver and navigate to the region URL
        driver = WebDriverManager.getDriver();
        driver.get(regionURL);
    }

    @Test
    public void testRegionLink() {

        // Add assertions and test steps for the region link
        String productName="ZARA COAT 3";


       driver.findElement(By.id("userEmail")).sendKeys("dummy2@email.com");
       driver.findElement(By.id("userPassword")).sendKeys("Test@123");
       driver.findElement(By.id("login")).click();
        try {
            Thread.sleep(30000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(driver.getTitle());
    }
    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
