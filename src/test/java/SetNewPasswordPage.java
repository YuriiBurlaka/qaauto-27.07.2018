import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class SetNewPasswordPage extends BasePage{

    @FindBy(xpath = "//input[@type='password' and @id='newPassword']")
    private WebElement newPasswordField;

    @FindBy(xpath = "//input[@type='password' and @id='confirmPassword']")
    private WebElement confirmNewPasswordField;

    @FindBy(xpath = "//button")
    private WebElement confirmButton;

    public SetNewPasswordPage(WebDriver browser) {
        this.browser = browser;
        PageFactory.initElements(browser, this);
    }

    public PasswordWasChangedPage setNewPassword(String newPassword){

        newPasswordField.click();
        newPasswordField.sendKeys(newPassword);
        confirmNewPasswordField.click();
        confirmNewPasswordField.sendKeys(newPassword);
        confirmButton.click();
        return null;
    }

    public boolean isLoaded() {
        return getCurrentPageTitle().contains("Изменить пароль | LinkedIn") && getCurrentUrl().contains("password-reset?requestSubmissionId");
    }
}