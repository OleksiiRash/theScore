package steps;

import io.appium.java_client.MobileElement;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import utils.CommonMethods;

public class LeaguesSteps extends CommonMethods {

    @Given("I navigate to the {string} page")
    public void i_navigate_to_the_page(String pageName) {
        if (pageName.equals("Leagues")) {
            leaguesPage.navigationLeaguesButton.click();
        }
    }

    @When("I check for the Spotlight Betting News")
    public void i_check_for_the_spotlight_betting_news() {
        try {
            // Check if the spotlightElement is displayed
            if (leaguesPage.spotlightElement.isDisplayed()) {
                profilePage.ProfileImageButton.click();
                System.out.println("Opened the Profile page");
                profilePage.ensureSwitchBetModeIsOff();
                System.out.println("Switched off the Bet Mode");
                leaguesPage.backNavigation.click();
            } else {
                System.out.println("spotlightElement is not displayed");
            }
        } catch (Exception e) {
            System.out.println("An error occurred while checking the spotlight element: " + e.getMessage());
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
        try {
            if (leaguesPage.statsTab.isDisplayed()) {
                leaguesPage.statsTab.click();
            } else {
                leaguesPage.backNavigation.click();
            }
        } catch (NoSuchElementException e) {
            leaguesPage.backNavigation.click();
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    @Then("the {string} tab is displayed correctly")
    public void the_tab_is_displayed_correctly(String expectedTab) {
        try {
            if (leaguesPage.statsTab.isDisplayed()) {
                String actualActiveTab = leaguesPage.getCurrentSubTabName();
                boolean isCorrectTab = actualActiveTab != null && actualActiveTab.contains("STATS");
                Assert.assertTrue("Expected active tab to contain 'STATS', but found: '" + actualActiveTab + "'", isCorrectTab);
            } else {
                // If the statsTab is not displayed, perform backNavigation click
                leaguesPage.backNavigation.click();
                Assert.fail("Stats tab is not present, navigating back.");
            }
        } catch (NoSuchElementException e) {
            // If the statsTab is not found within the ScrollView, click backNavigation
            leaguesPage.backNavigation.click();
            Assert.fail("Stats tab is not found, navigating back.");
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            Assert.fail("An unexpected error occurred: " + e.getMessage());
        }
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
