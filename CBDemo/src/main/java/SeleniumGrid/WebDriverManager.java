package SeleniumGrid;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class WebDriverManager {
    public static WebDriver getDriver() {
        WebDriver driver = null;
        try {
            URL gridUrl = new URL("http://192.168.0.117:4444/wd/hub");
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setBrowserName("chrome");  // or other browsers if required
            driver = new RemoteWebDriver(gridUrl, capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return driver;
    }
}
