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

    @AndroidFindBy(className = "android.widget.ImageButton")
    public MobileElement ProfileImageButton;

    public void ensureSwitchBetModeIsOff() {
        try {
            String switchStatus = switchBetMode.getAttribute("checked");

            if ("true".equals(switchStatus)) {
                switchBetMode.click();
                System.out.println("Switch was on. It has been turned off");
            } else {
                System.out.println("Switch is already off. No action taken");
            }
        } catch (Exception e) {
            System.out.println("An error occurred while checking or toggling the switch: " + e.getMessage());
        }
    }

    public ProfilePage() {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

}
