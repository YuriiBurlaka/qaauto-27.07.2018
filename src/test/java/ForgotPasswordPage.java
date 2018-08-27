import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgotPasswordPage extends BasePage{

    @FindBy(xpath = "//input[@name='userName']")
    private WebElement loginField;

    @FindBy(xpath = "//button[@class='form__submit']")
    private WebElement confirmButton;


    public ForgotPasswordPage(WebDriver browser) {
        this.browser = browser;
        PageFactory.initElements(browser, this);
    }


    public CheckPointPage requestForPasswordReset(String userEmail){
        loginField.sendKeys(userEmail);
        confirmButton.click();
        return new CheckPointPage(browser);
    }


    public boolean isLoaded() {
        return getCurrentPageTitle().contains("Изменить пароль | LinkedIn") && getCurrentUrl().contains("uas/request-password-reset");
    }


}
