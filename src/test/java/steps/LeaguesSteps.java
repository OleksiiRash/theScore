package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import utils.CommonMethods;

public class LeaguesSteps extends CommonMethods {

    @Given("theScore app is launched on the device")
    public void the_score_app_is_launched_on_the_device() {
        launchTheApp();
    }

    @When("I navigate to the {string} page")
    public void i_navigate_to_the_page(String pageName) {
        if (pageName.equals("Leagues")) {
            leaguesPage.navigationLeaguesButton.click();
        }
    }

    @When("I navigate to the {string} new page")
    public void i_navigate_to_the_new_page(String leagueName) {
        welcomePage.selectElement(leagueName);
    }

    @Then("the {string} page is displayed correctly")
    public void the_page_is_displayed_correctly(String leagueName) {
        Assert.assertTrue(leaguesPage.titleText.getText().contains(leagueName));
    }

    @When("I tap on the {string} sub-tab for {string}")
    public void i_tap_on_the_sub_tab_for(String subTab, String leagueName) {
        System.out.println("Navigating to the sub-tab: " + subTab + " for league: " + leagueName);
        Assert.assertTrue("The league page displayed is not correct",
                leaguesPage.titleText.getText().contains(leagueName));
        leaguesPage.selectSubTab(subTab);
    }

    @Then("the {string} sub-tab is displayed correctly with the relevant {string} title")
    public void the_sub_tab_is_displayed_correctly_with_the_relevant_data(String expectedSubTab, String expectedLeagueName) {
        String actualLeagueName = leaguesPage.titleText.getText();
        Assert.assertTrue("Expected league name: " + expectedLeagueName + ", but found: " + actualLeagueName,
                actualLeagueName.contains(expectedLeagueName));

        String actualSubTab = leaguesPage.getCurrentSubTabName();

        Assert.assertTrue("Expected sub-tab: " + expectedSubTab + ", but found: " + actualSubTab,
                actualSubTab.equals(expectedSubTab));
    }

    @When("I select the container element in {string}")
    public void i_select_the_container_element_in(String subTab) {
        switch (subTab) {
            case "STANDINGS":
                leaguesPage.standingsContainerElement.click();
                break;
            case "SCORES":
                leaguesPage.scoreContainerElement.click();
                break;
            case "LEADERS":
                leaguesPage.leadersContainerElement.click();
                break;
        }
    }

    @When("I navigate to the {string} tab")
    public void i_navigate_to_the_tab(String tab) {
        if (leaguesPage.statsTab.isDisplayed()) {
            leaguesPage.statsTab.click();
        } else {
            System.out.println("The '" + tab + "' tab is not displayed. Initiating back navigation.");
            leaguesPage.backNavigation.click();
        }
    }

    @Then("the {string} tab is displayed correctly")
    public void the_tab_is_displayed_correctly(String expectedTab) {
        String actualActiveTab = leaguesPage.getCurrentSubTabName();
        boolean isCorrectTab = actualActiveTab != null && actualActiveTab.contains("STATS");
        Assert.assertTrue("Expected active tab to contain 'STATS', but found: '" + actualActiveTab + "'", isCorrectTab);
    }

    @When("I initiate back navigation")
    public void i_initiate_back_navigation() {
        leaguesPage.backNavigation.click();
    }

    @Then("I am returned to the {string} sub-tab")
    public void i_am_returned_to_the_sub_tab(String expectedSubTab) {
        String actualSubTab = leaguesPage.getCurrentSubTabName();

        Assert.assertEquals("Expected to return to the " + expectedSubTab + " sub-tab, but found: " + actualSubTab,
                expectedSubTab, actualSubTab);
    }

    @When("I initiate back navigation again")
    public void i_initiate_back_navigation_again() {
        leaguesPage.backNavigation.click();
    }

    @Then("I am returned to the {string} page correctly")
    public void i_am_returned_to_the_page_correctly(String pageName) {
        String actualPageTitle = leaguesPage.titleText.getText();

        Assert.assertTrue("Expected to be on the " + pageName + " page, but found: " + actualPageTitle,
                actualPageTitle.contains(pageName));
    }

}
