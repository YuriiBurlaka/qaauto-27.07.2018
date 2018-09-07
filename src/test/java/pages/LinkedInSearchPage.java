package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Page object class for LinkedInSearchPage
 */
public class LinkedInSearchPage extends BasePage{

    @FindBy(xpath = "//li[contains(@class, 'search-result s')]")
    private List<WebElement> searchResults;

    @FindBy(xpath = "//h3[contains(@class, 'results__total')]")
    private WebElement searchResultsTotal;

    /**
     * Constructor of LinkedInPasswordResetSubmitPage class.
     * @param browser - WebDriver instance from test.
     */
    public LinkedInSearchPage(WebDriver browser) {
        this.browser = browser;
        PageFactory.initElements(browser, this);
    }

    /**
     * This method checks that required page was loaded
     */
    public boolean isLoaded() {
        return
                getCurrentPageTitle().contains(""); //&& getCurrentUrl().contains("search/") && searchResultsTotal.isDisplayed();
    }

    public int getSearchResultsCount(){
        return searchResults.size();
    }


    /**
     * This method checks that all search results contain required search term
     * param searchTerm - searchTerm for test ("hr" for example)
     */
   // public boolean allSearchResultsContainSearchterm(String searchTerm) {
       // int counter = 0;
        //for (WebElement searchResult : searchResults) {
          //  String searchResultText = searchResult.getText();

         //   int index = searchResultText.indexOf(searchTerm);
         //   if (index >= 1) {
          //      counter++;
         //       System.out.println(counter);
         //   }
         //   else{
         //       System.out.println("Searchresult doesn't contain required word");
         //   }
      //  }
       // if (counter == searchResults.size()) {
       //     return true;
       // } else {
       //     return false;
      //  }
   // }

    public List<String> getSearchResultsList() {
        List<String> searchResultsList = new ArrayList<String>();
        for (WebElement searchresult : searchResults){
            ((JavascriptExecutor)browser).executeAsyncScript("arguments[0].scrollIntoView()",searchresult);
            searchResultsList.add(searchresult.getText());
        }
        return searchResultsList;
    }
}
