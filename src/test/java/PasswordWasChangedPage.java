import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PasswordWasChangedPage extends BasePage{

    public PasswordWasChangedPage(WebDriver browser) {
        this.browser = browser;
        PageFactory.initElements(browser, this);
    }

    public PasswordWasChangedPage(){

    }

    public boolean isLoaded() {
        return getCurrentPageTitle().contains("Вы изменили свой пароль.") && getCurrentUrl().contains("checkpoint/rp/password-reset-submit");
    }
}
