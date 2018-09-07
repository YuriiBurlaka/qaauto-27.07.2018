package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Page object class for LinkedInSetNewPasswordPage
 */
public class LinkedInSetNewPasswordPage extends BasePage{

    @FindBy(xpath = "//input[@type='password' and @id='newPassword']")
    private WebElement newPasswordField;

    @FindBy(xpath = "//input[@type='password' and @id='confirmPassword']")
    private WebElement confirmNewPasswordField;

    @FindBy(xpath = "//button")
    private WebElement confirmButton;

    /**
     * Constructor of LinkedInSetNewPasswordPage class.
     * @param browser - WebDriver instance from test.
     */
    public LinkedInSetNewPasswordPage(WebDriver browser) {
        this.browser = browser;
        PageFactory.initElements(browser, this);
    }

    /**
     * This method sets new password when requst for change was processed
     * @param newPassword - new user password which should be set
     */
    public LinkedInSuccessfullResetPasswordPage confirmResetPassword(String newPassword){
        newPasswordField.click();
        newPasswordField.sendKeys(newPassword);
        confirmNewPasswordField.click();
        confirmNewPasswordField.sendKeys(newPassword);
        confirmButton.click();
        return null;
    }

    /**
     * This method checks that required page was loaded
     */
    public boolean isLoaded() {
        return getCurrentPageTitle().contains("Изменить пароль | LinkedIn") && getCurrentUrl().contains("password-reset?requestSubmissionId");
    }
}