import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LinkedInHomePage {
    private WebDriver browser;
    private WebElement profileMenu;


    public LinkedInHomePage(WebDriver browser){
        this.browser = browser;
        initElements();
    }

    private void initElements(){
        profileMenu = browser.findElement(By.xpath("//*[@id=\"nav-settings__dropdown-trigger\"]/div/span[1]"));
    }

    public String getCurrentPageTitle(){
      return browser.getTitle();
    }

    public String getCurrentUrl(){
        return browser.getCurrentUrl();
    }

    public boolean isLoaded() {
        return profileMenu.getText().equals("Профиль")
                && getCurrentPageTitle().contains("LinkedIn")
                && getCurrentUrl().contains("/feed/");
    }
}
