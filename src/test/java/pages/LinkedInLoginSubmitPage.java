package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Page object class for LinkedInLoginSubmitPage
 */
public class LinkedInLoginSubmitPage extends BasePage{

    @FindBy(xpath = "//*[@role = 'alert']")
    private WebElement errorMessage;

    @FindBy(xpath = "//span[@id='session_key-login-error']")
    private WebElement userEmailValidationText;

    @FindBy(xpath = "//span[@id='session_password-login-error']")
    private WebElement usePassValidationText;

    /**
     * Constructor of LinkedInHomePage class.
     * @param browser - WebDriver instance from test.
     */
    public LinkedInLoginSubmitPage(WebDriver browser) {
        this.browser = browser;
        PageFactory.initElements(browser, this);
        waitUntilElementIsVisible(errorMessage, 10);
    }


    public String getAlertBoxText() {
        return errorMessage.getText();
    }

    /**
     * This method checks that required page was loaded
     */
    public boolean isLoaded() {
        return errorMessage.isDisplayed()
                && getCurrentPageTitle().contains("Войти в LinkedIn")
                && getCurrentUrl().contains("/uas/login-submit");
    }

    public String getUserEmailValidationText() {
        return userEmailValidationText.getText();
    }
    public String getUserPasswordValidationText() {
        return usePassValidationText.getText();
    }
}


