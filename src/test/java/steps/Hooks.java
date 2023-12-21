package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
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
    public void afterScenario() {
        closeMobileApp();
    }


}
