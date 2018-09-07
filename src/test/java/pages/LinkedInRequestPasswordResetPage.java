package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Page object class for LinkedInRequestPasswordResetPage
 */
public class LinkedInRequestPasswordResetPage extends BasePage{

    @FindBy(xpath = "//input[@name='userName']")
    private WebElement loginField;

    @FindBy(xpath = "//button[@class='form__submit']")
    private WebElement confirmButton;

    /**
     * Constructor of LinkedInPasswordResetSubmitPage class.
     * @param browser - WebDriver instance from test.
     */
    public LinkedInRequestPasswordResetPage(WebDriver browser) {
        this.browser = browser;
        PageFactory.initElements(browser, this);
    }

    /**
     * This method returns LinkedInPasswordResetSubmitPage
     * @param userEmail - correct username to make request for password change.
     */
    public LinkedInPasswordResetSubmitPage findAccount(String userEmail){
        gMailService.connect();
        loginField.sendKeys(userEmail);
        confirmButton.click();
        return new LinkedInPasswordResetSubmitPage(browser);

    }

    /**
     * This method checks that required page was loaded
     */
    public boolean isLoaded() {
        return getCurrentPageTitle().contains("") && getCurrentUrl().contains("request-password-reset");
    }

}
