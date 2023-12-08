package steps;

import io.appium.java_client.MobileElement;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.CommonMethods;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class WelcomeSteps extends CommonMethods {

    @Given("the theScore app is launched first time")
    public void the_app_is_launched() {
        launchTheApp();
    }

    @Then("the welcome page is displayed")
    public void the_welcome_page_is_displayed() {
        Assert.assertTrue("Welcome text is not displayed", welcomePage.welcomeTxt.isDisplayed());
    }

    @When("I click on the {string} button")
    public void i_click_on_the_button(String btnName) {
        welcomePage.selectElement(btnName);
    }

    @Then("the {string} page is displayed")
    public void the_page_is_displayed(String page) {
        welcomePage.handleLocationPopup("later"); // handling with location pop-up
        MobileElement favoritePage = welcomePage.selectElement(page);
        Assert.assertTrue(page + "page not displayed", favoritePage.isDisplayed());
    }

    @When("I select the following leagues")
    public void i_select_the_following_leagues(io.cucumber.datatable.DataTable dataTable) {
        List<Map<String, String>> rows = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> row : rows) {
            String league = row.get("League");
            welcomePage.selectElement(league);
        }
    }

    @When("I press the {string} button")
    public void i_press_the_button(String continueBtn) {
        welcomePage.continuePrimaryBtn.click();
    }

    @When("I select teams as follows")
    public void i_select_teams_as_follows(io.cucumber.datatable.DataTable dataTable) {

        List<Map<String, String>> rows = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> row : rows) {
            String team = row.get("Team");
            welcomePage.selectElement(team);
        }
    }

    @When("I press the {string} another button")
    public void i_press_the_another_button(String continueBtn) {
        welcomePage.continuePrimaryBtn.click();
    }

    @When("I press {string}")
    public void i_press(String doneBtn) {
        welcomePage.selectElement(doneBtn);
    }

    @Then("a pop-up is displayed")
    public void a_pop_up_is_displayed() {
        boolean isPopupVisible = welcomePage.isPopupDisplayed();
        Assert.assertTrue("The pop-up is not displayed as expected", isPopupVisible);
    }

    @When("I close the pop-up")
    public void i_close_the_pop_up() {
        welcomePage.closePopup();
    }

    @Then("the main dashboard is displayed")
    public void the_main_dashboard_is_displayed() {
        boolean isDashboardVisible = welcomePage.navigationFavorites.isDisplayed();
        Assert.assertTrue("The main dashboard is not displayed as expected", isDashboardVisible);
    }


}
