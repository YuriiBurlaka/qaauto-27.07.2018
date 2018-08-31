package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LinkedInLoginSubmitPage extends BasePage{

    @FindBy(xpath = "//*[@role = 'alert']")
    private WebElement errorMessage;

    @FindBy(xpath = "//span[@id='session_key-login-error']")
    private WebElement userEmailValidationText;

    @FindBy(xpath = "//span[@id='session_password-login-error']")
    private WebElement usePassValidationText;

    public LinkedInLoginSubmitPage(WebDriver browser) {
        this.browser = browser;
        PageFactory.initElements(browser, this);
        //wait for element
        waitUntilElementIsVisible(errorMessage, 10);
    }


    public String getAlertBoxText() {
        return errorMessage.getText();
    }

    public boolean isLoaded() {
        return errorMessage.isDisplayed()
                && getCurrentPageTitle().contains("Войти в LinkedIn")
                && getCurrentUrl().contains("/uas/login-submit");
    }

    public String getUserEmailValidationText() {
        return userEmailValidationText.getText();
    }

    public String getUserPasswordValidationText() {
        return usePassValidationText.getText();
    }
}


