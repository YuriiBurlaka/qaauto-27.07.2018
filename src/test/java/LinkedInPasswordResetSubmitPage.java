import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import util.GMailService;

public class LinkedInPasswordResetSubmitPage extends BasePage{

    public LinkedInPasswordResetSubmitPage(WebDriver browser) {
        this.browser = browser;
        PageFactory.initElements(browser, this);
    }

    public boolean isLoaded() {
        return getCurrentPageTitle().contains("Проверьте, получили ли вы сообщение") && getCurrentUrl().contains("checkpoint/rp/request-password-reset-submit");
    }

    public LinkedInSetNewPasswordPage navigateToLinkFromEmail() {
        String messageSubject = "данное сообщение содержит ссылку для изменения пароля";
        String messageTo = "security-noreply@linkedin.com";
        String messageFrom = "mrentertheusername@gmail.com";


        String message = gMailService.waitMessage(messageSubject, messageTo, messageFrom, 180);

        System.out.println("Content: " + message);
        //ToDo
        return new LinkedInSetNewPasswordPage(browser);
    }
}
