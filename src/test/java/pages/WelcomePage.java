package pages;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.CommonMethods;

import java.time.Duration;

public class WelcomePage extends CommonMethods {

    @AndroidFindBy(xpath = "//*[@text='WELCOME']")
    public MobileElement welcomeTxt;

    @AndroidFindBy(xpath = "//*[@text='LOG IN']")
    public MobileElement login;

    @AndroidFindBy(xpath = "//*[@text='Get Started']")
    public MobileElement getStarted;

    @AndroidFindBy(xpath = "//*[@text='Choose your favorite leagues']")
    public MobileElement chooseLeaguesTxt;

    @AndroidFindBy(xpath = "//*[@text='Continue']")
    public MobileElement continueBtn;

    @AndroidFindBy(id = "img_location")
    public MobileElement locationPopup;

    @AndroidFindBy(id = "btn_disallow")
    public MobileElement noLocation;

    @AndroidFindBy(id = "btn_allow")
    public MobileElement allowLocation;

    public void handleLocationPopup(String action) {
        try {
            if (locationPopup.isDisplayed()) {
                if ("later".equalsIgnoreCase(action)) {
                    noLocation.click();
                    System.out.println("Clicked 'Maybe Later' on location popup");
                } else if ("allow".equalsIgnoreCase(action)) {
                    allowLocation.click();
                    System.out.println("Clicked 'Allow Location' on location popup");
                }
            }
        } catch (Exception e) {
            System.out.println("Location popup was not displayed or an error occurred: " + e.getMessage());
        }
    }

    @AndroidFindBy(xpath = "//*[@text='Choose your favorite teams']")
    public MobileElement chooseFavoriteTeamsTxt;

    @AndroidFindBy(xpath = "//*[@text='Never miss a game']")
    public MobileElement neverMissGameTxt;

    @AndroidFindBy(xpath = "//*[@text='Done']")
    public MobileElement doneBtn;

    @AndroidFindBy(id = "btn_primary")
    public MobileElement continuePrimaryBtn;

    String elementXPathTemplate = "//*[@text='%s']";

    //old method - need to be deleted
    public MobileElement selectElement(String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        String xpath = String.format("//android.widget.TextView[@text='%s']", elementName);
        MobileElement element = (MobileElement) wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));

        // Scroll to the element if not visible
        if (!element.isDisplayed()) {
            scrollToElement(element);
        }

        // Check if the element is clickable
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
        return element;
    }

    public MobileElement selectElementNew(String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 3);
        MobileElement element = null;

        try {
            scrollToElementNew(elementName);
            String xpath = String.format("//android.widget.TextView[@text='%s']", elementName);
            element = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));

            element.click();

        } catch (Exception e) {
            System.out.println("Element with name '" + elementName + "' not found or not clickable");
        }

        return element;
    }

    public MobileElement selectElementNewNoWait(String elementName) {
        MobileElement element = null;

        try {
            scrollToElementNew(elementName);
            String xpath = String.format("//android.widget.TextView[@text='%s']", elementName);
            element = (MobileElement) driver.findElement(By.xpath(xpath));
            element.click();

        } catch (Exception e) {
            System.out.println("Element with name '" + elementName + "' not found or not clickable");
        }

        return element;
    }

    private void scrollToElementNew(String elementText) {
        driver.findElement(MobileBy.AndroidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true))" +
                        ".scrollIntoView(new UiSelector().text(\"" + elementText + "\"))"));
    }


    //old method - need to be deleted
    private void scrollToElement(MobileElement element) {
        TouchAction touchAction = new TouchAction(driver);
        int startX = element.getLocation().getX() + element.getSize().getWidth() / 2;
        int startY = element.getLocation().getY() + element.getSize().getHeight() / 2;
        int endY = driver.manage().window().getSize().getHeight() / 4; // Scroll up to a quarter of the screen height

        // Scroll action
        touchAction.press(PointOption.point(startX, startY))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
                .moveTo(PointOption.point(startX, endY))
                .release()
                .perform();
    }


    public void closePopup() {
        By closeButtonLocator = By.id("dismiss_modal");
        WebElement closeButton = driver.findElement(closeButtonLocator);
        closeButton.click();
    }

    public boolean isPopupDisplayed() {
        try {
            By popupLocator = By.id("dismiss_modal");
            WebElement popup = driver.findElement(popupLocator);
            return popup.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    @AndroidFindBy(id = "navigation_favorites")
    public MobileElement navigationFavorites;


    public WelcomePage() {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

}
