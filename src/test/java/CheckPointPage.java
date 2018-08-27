import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class CheckPointPage extends BasePage{

    public CheckPointPage(WebDriver browser) {
        this.browser = browser;
        PageFactory.initElements(browser, this);
    }

    public boolean isLoaded() {
        return getCurrentPageTitle().contains("Проверьте, получили ли вы сообщение") && getCurrentUrl().contains("checkpoint/rp/request-password-reset-submit");
    }
}
