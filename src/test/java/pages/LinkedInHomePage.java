package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Page object class for LinkedInHomePage
 */
public class LinkedInHomePage extends  BasePage{

    @FindBy(xpath = "//*[@id=\"nav-settings__dropdown-trigger\"]/div/span[1]")
    private WebElement profileMenu;
    String searchTerm = "hr";

    @FindBy(xpath = "//*[@placeholder=\"Поиск\"]")
    private WebElement searchField;

    /**
     * Constructor of LinkedInHomePage class.
     * @param browser - WebDriver instance from test.
     */
    public LinkedInHomePage(WebDriver browser){
        this.browser = browser;
        PageFactory.initElements(browser, this);    }


    /**
     * This method checks that required page was loaded
     */
    public boolean isLoaded() {
        return
                //profileMenu.getText().equals("")
                //&& getCurrentPageTitle().contains("")
                 getCurrentUrl().contains("");
    }

    public LinkedInSearchPage search (String searchTerm){
        searchField.sendKeys(searchTerm);
        searchField.sendKeys(Keys.ENTER);
        waitUntilElementIsVisible(searchField, 10);
        return new LinkedInSearchPage(browser);
    }

}
