## Test Specification

### Welcome Feature

**Feature:** Welcome Sequence Navigation with Customizable League and Team Selections

**Scenario:** Successfully navigating through the welcome sequence with user-defined league and team selections.

**Preconditions:** The theScore app is installed and launched for the first time.

**Test Steps:**

* Launch the theScore app.
* Verify the welcome page is displayed.
* Click on the "Get Started" button.
* Verify the "Choose your favorite leagues" page is displayed.
* Select specified leagues and press "Continue".
* Verify the "Choose your favorite teams" page is displayed.
* Select specified teams and press "Continue".
* Verify the "Never miss a game" page is displayed.
* Press "Done" and handle any pop-up.
* Verify the main dashboard is displayed.

**Expected Results:** Each step should lead to the next as specified, with the final step landing on the main dashboard.

### Leagues Feature

**Feature:** Enhanced Navigation and Verification of League Pages and Sub-Tabs

**Scenario:** Navigate and verify league pages, interact with sub-tabs, and perform specific actions.

**Preconditions:** The theScore app is installed and launched.

**Test Steps:**

* Launch the theScore app.
* Navigate to the "Leagues" page.
* Select a specific league and verify its page.
* Tap on a specified sub-tab for the chosen league.
* Verify the correct sub-tab is displayed with relevant data.
* Interact with elements within the sub-tab and navigate to the "STATS" tab.
* Verify the "STATS" tab is displayed correctly.
* Perform back navigation and verify return to the sub-tab and then the "Leagues" page.

**Expected Results:** Navigation through the app should be smooth, with each step displaying the correct page or tab, and data corresponding to the chosen league.