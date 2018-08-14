import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import static java.lang.Thread.sleep;

public class LinkedInLoginPage {

    private WebDriver browser;
    private WebElement loginField;
    private WebElement passwordField;
    private WebElement signInButton;

    public LinkedInLoginPage(WebDriver browser) {
        this.browser = browser;
        initElements();
    }

    private void initElements(){
        loginField = browser.findElement(By.xpath("//*[@id=\"login-email\" and @class = \"login-email\"]"));
        passwordField = browser.findElement(By.xpath("//*[@id=\"login-password\"]"));
        signInButton = browser.findElement(By.xpath("//*[@id=\"login-submit\"]"));
    }



    public void Login (String username, String userpass){
        loginField.sendKeys(username);
        passwordField.sendKeys(userpass);
        signInButton.click();
        //Wait
        try {
            sleep (3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String getCurrentPageTitle(){
        return browser.getTitle();
    }

    public String getCurrentUrl(){

        return browser.getCurrentUrl();
    }

    public boolean isLoaded() {
        return
                getCurrentPageTitle().contains("LinkedIn");

    }
}

