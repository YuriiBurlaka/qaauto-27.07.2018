package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static java.lang.Thread.sleep;

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
        gMailService.connect();
        loginField.sendKeys(userEmail);
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        confirmButton.click();
        return new LinkedInPasswordResetSubmitPage(browser);

    }


    public boolean isLoaded() {
        return getCurrentPageTitle().contains("") && getCurrentUrl().contains("request-password-reset");
    }

}
