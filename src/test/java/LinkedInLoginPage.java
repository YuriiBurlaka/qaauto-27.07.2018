import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LinkedInLoginPage {

    WebDriver browser;
    WebElement loginField;
    WebElement passwordField;
    WebElement signInButton;

    public LinkedInLoginPage(WebDriver browser) {
        this.browser = browser;
        initElements();
    }

    public void initElements(){
        loginField = browser.findElement(By.xpath("//*[@id=\"login-email\" and @class = \"login-email\"]"));
        passwordField = browser.findElement(By.xpath("//*[@id=\"login-password\"]"));
        signInButton = browser.findElement(By.xpath("//*[@id=\"login-submit\"]"));
    }



    public void Login (String username, String userpass){
        loginField.sendKeys(username);
        passwordField.sendKeys(userpass);
        signInButton.click();
    }
}

