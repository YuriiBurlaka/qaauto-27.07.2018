package pages;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Page object class for LinkedInPasswordResetSubmitPage
 */
public class LinkedInPasswordResetSubmitPage extends BasePage{

    /**
     * Constructor of LinkedInPasswordResetSubmitPage class.
     * @param browser - WebDriver instance from test.
     */
    public LinkedInPasswordResetSubmitPage(WebDriver browser) {
        this.browser = browser;
        PageFactory.initElements(browser, this);
    }

    /**
     * This method checks that required page was loaded
     */
    public boolean isLoaded() {
        return getCurrentPageTitle().contains("") && getCurrentUrl().contains("checkpoint/rp/request-password-reset-submit");
    }

    /**
     * This method navigates to forgotPasswordlink from email and returns LinkedInSetNewPasswordPage
     */
    public LinkedInSetNewPasswordPage navigateToLinkFromEmail() {
        String messageSubject = "данное сообщение содержит ссылку для изменения пароля";
        String messageTo = "mrentertheusername@gmail.com";
        String messageFrom = "security-noreply@linkedin.com";
        String message = gMailService.waitMessage(messageSubject, messageTo, messageFrom, 60);
        System.out.println("Content: " + message);
        String linkForPasswordChange = StringUtils.substringBetween("нажмите <a href=\\\"<a href=&quot;","&quot;>[text]</a>").replace("amp;","");
        System.out.println("Content: " + linkForPasswordChange);
        browser.get(linkForPasswordChange);
        return new LinkedInSetNewPasswordPage(browser);
    }
}
