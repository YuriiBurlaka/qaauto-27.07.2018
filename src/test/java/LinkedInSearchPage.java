import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class LinkedInSearchPage extends BasePage{

    @FindBy(xpath = "//li[contains(@class, 'search-result s')]")
    private List<WebElement> searchResults;

    @FindBy(xpath = "//h3[contains(@class, 'results__total')]")
    private WebElement searchResultsTotal;


    public LinkedInSearchPage(WebDriver browser) {
        this.browser = browser;
        PageFactory.initElements(browser, this);
    }
    public boolean isLoaded() {
        return
                getCurrentPageTitle().contains("\"hr\" | Поиск | LinkedIn") && getCurrentUrl().contains("search/") && searchResultsTotal.isDisplayed();

    }

    public int getSearchResultsCount(){
        return searchResults.size();
    }

}
