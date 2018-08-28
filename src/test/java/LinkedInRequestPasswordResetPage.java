import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.GMailService;

public class LinkedInRequestPasswordResetPage extends BasePage{

    @FindBy(xpath = "//input[@name='userName']")
    private WebElement loginField;

    @FindBy(xpath = "//button[@class='form__submit']")
    private WebElement confirmButton;


    public LinkedInRequestPasswordResetPage(WebDriver browser) {
        this.browser = browser;
        PageFactory.initElements(browser, this);
    }


    public LinkedInPasswordResetSubmitPage findAccount(String userEmail){
        gMailService = new GMailService("mrentertheusername@gmail.com","a14401440");
        gMailService.connect();
        loginField.sendKeys(userEmail);
        confirmButton.click();
        return new LinkedInPasswordResetSubmitPage(browser);
    }


    public boolean isLoaded() {
        return getCurrentPageTitle().contains("Изменить пароль | LinkedIn") && getCurrentUrl().contains("uas/request-password-reset");
    }


}
