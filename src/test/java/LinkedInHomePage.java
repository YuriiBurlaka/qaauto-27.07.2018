import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LinkedInHomePage {
    WebDriver browser;
    WebElement profileMenu;


    public LinkedInHomePage(WebDriver browser){
        this.browser = browser;
        initElements();
    }

    public void initElements(){
        profileMenu = browser.findElement(By.xpath("//*[@id=\"nav-settings__dropdown-trigger\"]/div/span[1]"));
    }


    public boolean isNavigationItemDisplayed(){
    return (profileMenu.getText().equals("Профиль"));
    }

    }
