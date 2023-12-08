package pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class ProfilePage extends CommonMethods {

    @AndroidFindBy(id = "dialog_container")
    public MobileElement betModePopup;

    @AndroidFindBy(id = "close")
    public MobileElement betModePopupClose;

    @AndroidFindBy(id = "primary_button")
    public MobileElement betModeGotIt;

    @AndroidFindBy(id = "secondary_button")
    public MobileElement betModeManageInAccount;

    @AndroidFindBy(id = "switch_bet_mode")
    public MobileElement switchBetMode;
    

    public ProfilePage() {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

}
