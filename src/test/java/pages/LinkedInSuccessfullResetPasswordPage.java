package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Page object class for LinkedInSuccessfullResetPasswordPage
 */
public class LinkedInSuccessfullResetPasswordPage extends BasePage{

    /**
     * Constructor of LinkedInSuccessfullResetPasswordPage class.
     * @param browser - WebDriver instance from test.
     */
    public LinkedInSuccessfullResetPasswordPage(WebDriver browser) {
        this.browser = browser;
        PageFactory.initElements(browser, this);
    }

    /**
     * This method checks that required page was loaded
     */
    public boolean isLoaded() {
        return getCurrentPageTitle().contains("Вы изменили свой пароль.") && getCurrentUrl().contains("checkpoint/rp/password-reset-submit");
    }

    public LinkedInHomePage clickOnGoToHomeButton(){

        return new LinkedInHomePage(browser);
    }
}
