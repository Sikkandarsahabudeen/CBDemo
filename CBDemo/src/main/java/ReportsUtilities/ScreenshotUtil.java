package ReportsUtilities;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ScreenshotUtil {

    public static File takeScreenshots(WebDriver driver, String methodName) {
            Path screenshotDir = Paths.get("C:\\Users\\sikka\\OneDrive\\Documents\\Automation\\CBDemo\\Reports\\screenshots");
            try {
                if (!Files.exists(screenshotDir)) {
                    Files.createDirectories(screenshotDir);
                }

                // Capture screenshot using WebDriver
                File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                if (screenshot == null) {
                    System.out.println("Screenshot capture failed for: " + methodName);
                    return null;
                }

                Path destPath = screenshotDir.resolve(methodName + ".png");
                Files.copy(screenshot.toPath(), destPath); // Save screenshot to the desired location

                System.out.println("Screenshot captured at: " + destPath.toString()); // Debug log
                return destPath.toFile();
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }

    }

