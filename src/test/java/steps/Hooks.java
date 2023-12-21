package steps;

import io.cucumber.java.*;
import org.openqa.selenium.By;
import utils.CommonMethods;

public class Hooks extends CommonMethods {

    @Before
    public void start() {
        launchTheApp();

        try {
            By closeButtonLocator = By.id("dismiss_modal");
            if (!driver.findElements(closeButtonLocator).isEmpty()) {
                welcomePage.closePopup();
                System.out.println("Closed the popup");
            }
        } catch (Exception e) {
            System.out.println("An error occurred while checking or closing the popup: " + e.getMessage());
        }
    }

    @After
    public void end(Scenario scenario) {
        byte[] pic;
        String scenarioName = scenario.getName().replaceAll(" ", "_") + "_" + scenario.getStatus();
        byte[] screenshot = takeScreenshot(scenarioName);
        scenario.attach(screenshot, "image/png", scenarioName);

        closeMobileApp();
    }


}
