package steps;

import pages.*;

public class PageInitializer {
    public static WelcomePage welcomePage;
    public static LeaguesPage leaguesPage;
    public static ProfilePage profilePage;

    public static void initializePageObjects() {
        welcomePage = new WelcomePage();
        leaguesPage = new LeaguesPage();
        profilePage = new ProfilePage();
    }

}
