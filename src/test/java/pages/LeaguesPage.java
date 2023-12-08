package pages;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

import java.util.List;

public class LeaguesPage extends CommonMethods {
    @AndroidFindBy(id = "navigation_leagues")
    public MobileElement navigationLeaguesButton;

    @AndroidFindBy(id = "titleTextView")
    public MobileElement titleText;

    String subTabXPathTemplate = "//*[@text='%s']";

    public void selectSubTab(String subTabName) {
        String xpath = String.format(subTabXPathTemplate, subTabName);
        WebElement subTabElement = driver.findElement(By.xpath(xpath));
        subTabElement.click();
    }

    public String getCurrentSubTabName() {
        List<MobileElement> subTabs = driver.findElements(By.xpath("//android.widget.TextView"));

        for (MobileElement subTab : subTabs) {
            if ("true".equals(subTab.getAttribute("selected"))) {
                return subTab.getText();
            }
        }
        return null;
    }

    @AndroidFindBy(id = "txt_rank")
    public MobileElement standingsContainerElement;

    @AndroidFindBy(id = "scores_container")
    public MobileElement scoreContainerElement;

    @AndroidFindBy(id = "big_leader")
    public MobileElement leadersContainerElement;

    @AndroidFindBy(xpath = "//*[contains(@content-desc, 'Stats')]")
    public MobileElement statsTab;

    @AndroidFindBy(id = "Navigate up")
    public MobileElement backNavigation;


    public LeaguesPage() {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }


}
