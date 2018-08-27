import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static java.lang.Thread.sleep;

public class LinkedInLoginPage extends BasePage{

    @FindBy(xpath = "//*[@id=\"login-email\" and @class = \"login-email\"]")
    private WebElement loginField;

    @FindBy(xpath = "//*[@id=\"login-password\"]")
    private WebElement passwordField;

    @FindBy(xpath = "//*[@id=\"login-submit\"]")
    private WebElement signInButton;

    @FindBy(xpath = "//a[contains(@class, 'link-forgot')]")
    private WebElement forgotPasswordLink;



    public LinkedInLoginPage(WebDriver browser) {
        this.browser = browser;
        PageFactory.initElements(browser, this);
    }


    public LinkedInLoginSubmitPage loginReturnSubmitPage (String username, String userpass){
        loginField.sendKeys(username);
        passwordField.sendKeys(userpass);
        signInButton.click();
        //Wait
        try {
            sleep (3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new LinkedInLoginSubmitPage(browser);
    }

    public LinkedInHomePage loginReturnHomePage (String username, String userpass){
        loginField.sendKeys(username);
        passwordField.sendKeys(userpass);
        signInButton.click();
        //Wait
        try {
            sleep (3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new LinkedInHomePage(browser);
    }

    public LinkedInLoginPage loginReturnLoginPage (String username, String userpass){
        loginField.sendKeys(username);
        passwordField.sendKeys(userpass);
        signInButton.click();
        //Wait
        try {
            sleep (3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new LinkedInLoginPage(browser);
    }

    public boolean isLoaded() {
        return
                getCurrentPageTitle().contains("LinkedIn");
    }

    public ForgotPasswordPage loginPageReturnsForgotPasswordPage (){
        forgotPasswordLink.click();
        //Wait
        try {
            sleep (3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new ForgotPasswordPage(browser);
    }
}