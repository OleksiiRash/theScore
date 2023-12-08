package utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import steps.PageInitializer;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
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
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            System.out.println("App Launched");

            initializePageObjects();

        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

    }

}
