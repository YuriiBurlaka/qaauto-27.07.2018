import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class LinkedInSearchTest {
    WebDriver browser;
    LinkedInLoginPage linkedInLoginPage;

    String userEmail = "mrentertheusername@gmail.com";
    String userPass = "a14401440";
    String searchTerm = "hr";

    @Test
    public void basicSearchTest() {
        Assert.assertTrue(linkedInLoginPage.isLoaded(), "LoginPage is not loaded");
        //LogIn
        LinkedInHomePage linkedInHomePage = linkedInLoginPage.loginReturnHomePage(userEmail, userPass);

        //Validation
        Assert.assertTrue(linkedInHomePage.isLoaded(), "Home page is not loaded");

        LinkedInSearchPage linkedInSearchPage = linkedInHomePage.search("hr");

        Assert.assertTrue(linkedInSearchPage.isLoaded(), "SearchPage is not loaded");

        Assert.assertEquals(linkedInSearchPage.getSearchResultsCount(), 10, "Search results count is wrong");


    }


    @BeforeMethod
    public void beforeMethod(){
        browser = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\yurii.burlaka.ext\\IdeaProjects\\qaauto-27.07.2018\\chromedriver.exe");
        //browser.manage().window().maximize();
        browser.get("https://www.linkedin.com/");
        linkedInLoginPage = new LinkedInLoginPage(browser);
    }

    @AfterMethod
    public void afterMethod(){
        browser.close();
    }
}
