import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static java.lang.Thread.sleep;

public class LinkedInLoginSubmitPage {

    private WebDriver browser;
    private WebElement errorMessage;

    public LinkedInLoginSubmitPage(WebDriver browser) {
        this.browser = browser;
        initElements();
    }

    public void initElements(){
        errorMessage = browser.findElement(By.xpath("//*[@role = 'alert']"));
    }

    public String getAlertBoxText() {
        return errorMessage.getText();
    }
}

