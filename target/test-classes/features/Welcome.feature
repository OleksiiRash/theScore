@welcome
Feature: Welcome Sequence Navigation with Customizable League and Team Selections

  Scenario Outline: Successfully navigating through the welcome sequence with user-defined league and team selections

    Given the theScore app is launched first time
    Then the welcome page is displayed

    When I click on the "Get Started" button
    Then the "Choose your favorite leagues" page is displayed

    When I select the following leagues
      | League |
      | <L1>   |
      | <L2>   |
      | <L3>   |
    And I press the "Continue" button
    Then the "Choose your favorite teams" page is displayed

    When I select teams as follows
      | League | Team    |
      | <L1>   | <Team1> |
      | <L2>   | <Team2> |
      | <L3>   | <Team3> |
    And I press the "Continue" another button
    Then the "Never miss a game" page is displayed

    When I press "Done"
    Then a pop-up is displayed

    When I close the pop-up
    Then the main dashboard is displayed

    Examples:
      | L1         | L2           | L3             | Team1               | Team2           | Team3             |
      | NHL Hockey | NFL Football | NBA Basketball | Toronto Maple Leafs | Toronto Raptors | Toronto Blue Jays |

