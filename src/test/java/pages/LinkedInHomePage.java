package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static java.lang.Thread.sleep;

public class LinkedInHomePage extends  BasePage{

    @FindBy(xpath = "//*[@id=\"nav-settings__dropdown-trigger\"]/div/span[1]")
    private WebElement profileMenu;
    String searchTerm = "hr";

    @FindBy(xpath = "//*[@placeholder=\"Поиск\"]")
    private WebElement searchField;

    public LinkedInHomePage(WebDriver browser){
        this.browser = browser;
        PageFactory.initElements(browser, this);
    }



    public boolean isLoaded() {
        return profileMenu.getText().equals("Профиль")
                && getCurrentPageTitle().contains("LinkedIn")
                && getCurrentUrl().contains("/feed/");
    }

    public LinkedInSearchPage search (String searchTerm){

        searchField.sendKeys(searchTerm);
        searchField.sendKeys(Keys.ENTER);
        try {
            sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new LinkedInSearchPage(browser);
    }

}
