package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Page object class for LinkedInLoginPage
 */
public class LinkedInLoginPage extends BasePage{

    @FindBy(xpath = "//*[@id=\"login-email\" and @class = \"login-email\"]")
    private WebElement loginField;

    @FindBy(xpath = "//*[@id=\"login-password\"]")
    private WebElement passwordField;

    @FindBy(xpath = "//*[@id=\"login-submit\"]")
    private WebElement signInButton;

    @FindBy(xpath = "//a[contains(@class, 'link-forgot')]")
    private WebElement forgotPasswordLink;

    @FindBy(xpath = "//*[@id=\"nav-settings__dropdown-trigger\"]/div/span[1]")
    private WebElement profileMenu;

    @FindBy(xpath = "//button[@class='form__submit']")
    private WebElement confirmButton;

    /**
     * Constructor of LinkedInLoginPage class.
     * @param browser - WebDriver instance from test.
     */
    public LinkedInLoginPage(WebDriver browser) {
        this.browser = browser;
        PageFactory.initElements(browser, this);
    }

    /**
     * This method enters credentials and click 'logIn' button.
     * @param username - String with user email.
     * @param userpass - String with user password.
     * @<T> - generic type to return corresponding pageObject
     * @return - either LinkedInHomePage or LinkedInLoginSubmitPage or LinkedInLoginPage
     */
    public <T> T login (String username, String userpass){
        loginField.sendKeys(username);
        passwordField.sendKeys(userpass);
        signInButton.click();
        if (getCurrentUrl().contains("/feed")) {
            return (T) new LinkedInHomePage(browser);
        }
        if (getCurrentUrl().contains("/uas/login")) {
            return (T) new LinkedInLoginSubmitPage(browser);
        }
        else{
            //return (T) this;
            return (T) new LinkedInLoginPage(browser);
        }
    }

    /**
     * This method checks that required page was loaded
     */
    public boolean isLoaded() {
        return
                getCurrentPageTitle().contains("LinkedIn");
    }

    public LinkedInRequestPasswordResetPage clickOnForgotPasswordLink(){
        forgotPasswordLink.click();
        waitUntilElementIsVisible(confirmButton, 10);
        return new LinkedInRequestPasswordResetPage(browser);
    }
}