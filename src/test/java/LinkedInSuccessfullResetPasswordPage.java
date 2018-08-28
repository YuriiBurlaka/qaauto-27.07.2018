import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class LinkedInSuccessfullResetPasswordPage extends BasePage{

    public LinkedInSuccessfullResetPasswordPage(WebDriver browser) {
        this.browser = browser;
        PageFactory.initElements(browser, this);
    }

    public boolean isLoaded() {
        return getCurrentPageTitle().contains("Вы изменили свой пароль.") && getCurrentUrl().contains("checkpoint/rp/password-reset-submit");
    }
}
