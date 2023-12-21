package utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.cucumber.java.*;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import steps.PageInitializer;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class CommonMethods extends PageInitializer {

    public static AppiumDriver driver;

    public static void launchTheApp() {
        ConfigReader.getProperties(Constants.CONFIG_READER_PATH);
        File appDir = new File(ConfigReader.getProperty("appPath"));
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.APP, appDir.getAbsolutePath());
        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "");
        capabilities.setCapability("noReset", "true");
        capabilities.setCapability("deviceName", "emulator-5554");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("automatorName", "UIAutomator2");
        capabilities.setCapability("noSign", "true");
        capabilities.setCapability("appPackage", ConfigReader.getProperty("appPackage"));
        capabilities.setCapability("appActivity", ConfigReader.getProperty("appActivity"));

        try {
            URL u = new URL(ConfigReader.getProperty("AppiumServerURL"));
            driver = new AppiumDriver(u, capabilities);
            driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
            System.out.println("App Launched");

            initializePageObjects();

        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

    }

    public static void closeMobileApp() {
        if (driver != null) {
            driver.quit();
        }
    }

    public byte[] takeScreenshot(String name) {
        TakesScreenshot ts = (TakesScreenshot) driver;
        byte[] picBytes = ts.getScreenshotAs(OutputType.BYTES);
        File file = ts.getScreenshotAs(OutputType.FILE);

        try {
            String filePath = Constants.SCREENSHOT_FOLDER_PATH + name + "_" +
                    getTimeStamp("yyyy-MM-dd-HH-mm") + ".png";
            FileUtils.copyFile(file, new File(filePath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return picBytes;
    }

    public static String getTimeStamp(String pattern) {
        var date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(date);
    }





}
