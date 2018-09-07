package tests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LinkedInHomePage;
import pages.LinkedInSearchPage;
import java.util.List;
import static java.lang.Thread.sleep;


public class LinkedInSearchTest extends BaseTest{

    String userEmail = "mrentertheusername@gmail.com";
    String userPass = "Aa14401440";
    String searchTerm = "HR";



    @Test
    public void basicSearchTest() {
        Assert.assertTrue(linkedInLoginPage.isLoaded(), "LoginPage is not loaded");
        //LogIn
        LinkedInHomePage linkedInHomePage = linkedInLoginPage.login(userEmail, userPass);
        try {
            sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //Validation
        Assert.assertTrue(linkedInHomePage.isLoaded(), "Home page is not loaded");
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        LinkedInSearchPage linkedInSearchPage = linkedInHomePage.search("hr");
        Assert.assertTrue(linkedInSearchPage.isLoaded(), "SearchPage is not loaded");
        //Assert.assertEquals(linkedInSearchPage.getSearchResultsCount(), 10, "Search results count is wrong");

        try {
            sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        //Assert.assertTrue(linkedInSearchPage.allSearchResultsContainSearchterm(searchTerm),"Not all results contain required search term");
        List<String> searchResults = linkedInSearchPage.getSearchResultsList();
        for (String searchResult: searchResults){
            Assert.assertTrue(searchResult.toLowerCase().contains(searchTerm), "searchterm " +searchTerm+" not found in \n" +searchResult);
        }
    }



}
