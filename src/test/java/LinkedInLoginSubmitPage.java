import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class LinkedInLoginSubmitPage {

    private WebDriver browser;
    private WebElement errorMessage;
    private WebElement userEmailValidationText;
    private WebElement usePassValidationText;

    public LinkedInLoginSubmitPage(WebDriver browser) {
        this.browser = browser;
        initElements();
    }

    public void initElements() {
        errorMessage = browser.findElement(By.xpath("//*[@role = 'alert']"));
        userEmailValidationText = browser.findElement(By.xpath("//span[@id='session_key-login-error']"));
        usePassValidationText = browser.findElement(By.xpath("//span[@id='session_password-login-error']"));
    }

    public String getAlertBoxText() {
        return errorMessage.getText();
    }

    public boolean isLoaded() {
        return errorMessage.isDisplayed()
                && getCurrentPageTitle().contains("Войти в LinkedIn")
                && getCurrentUrl().contains("/uas/login-submit");
    }

    public String getCurrentPageTitle() {
        return browser.getTitle();
    }

    public String getCurrentUrl() {

        return browser.getCurrentUrl();
    }

    public String getUserEmailValidationText() {
        return userEmailValidationText.getText();
    }

    public String getUserPasswordValidationText() {
        return usePassValidationText.getText();
    }
}


