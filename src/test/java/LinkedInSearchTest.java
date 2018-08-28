import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;


public class LinkedInSearchTest {
    WebDriver browser;
    LinkedInLoginPage linkedInLoginPage;

    String userEmail = "mrentertheusername@gmail.com";
    String userPass = "Aaa14401440";
    String searchTerm = "HR";



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

        try {
            sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //Scroll
        JavascriptExecutor jse;
        jse = (JavascriptExecutor)browser;
        jse.executeScript("window.scrollBy(0,300)","");

        try {
            sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //Scroll
        jse.executeScript("window.scrollBy(0,1000)","");

        Assert.assertTrue(linkedInSearchPage.allSearchResultsContainSearchterm(searchTerm),"Not all results contain required search term");
    }


    @BeforeMethod
    public void beforeMethod(){
        browser = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\yurii.burlaka.ext\\IdeaProjects\\qaauto-27.07.2018\\chromedriver.exe");
        browser.manage().window().maximize();
        browser.get("https://www.linkedin.com/");
        linkedInLoginPage = new LinkedInLoginPage(browser);
    }

    @AfterMethod
    public void afterMethod(){
        //browser.close();
    }
}
