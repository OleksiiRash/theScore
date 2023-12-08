@leagues
Feature: Enhanced Navigation and Verification of League Pages and Sub-Tabs

  Scenario Outline: Navigate and verify league pages, interact with sub-tabs, and perform specific actions
    Given theScore app is launched on the device
    Then I navigate to the "Leagues" page
    When I check for the Spotlight Betting News
    And I navigate to the "<LeagueName>" new page
    Then the "<LeagueName>" page is displayed correctly

    When I tap on the "<SubTab>" sub-tab for "<LeagueName>"
    Then the "<SubTab>" sub-tab is displayed correctly with the relevant "<LeagueName>" title

    When I select the container element in "<SubTab>"
    And I navigate to the "STATS" tab
    Then the "STATS" tab is displayed correctly

    When I initiate back navigation
    Then I am returned to the "<SubTab>" sub-tab

    When I initiate back navigation again
    Then I am returned to the "Leagues" page correctly

    Examples:
      | LeagueName | SubTab    |
      | NBA        | SCORES    |
      | NBA        | STANDINGS |
      | NBA        | LEADERS   |
      | NHL        | SCORES    |
      | NHL        | STANDINGS |
      | NHL        | LEADERS   |

