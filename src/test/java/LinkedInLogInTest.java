import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LinkedInLogInTest {
    WebDriver browser;
    LinkedInLoginPage linkedInLoginPage;

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
        browser.close();
    }

    @Test
    public void successfulLoginTest(){

        //LogIn
        linkedInLoginPage.Login("mrentertheusername@gmail.com","a14401440");

        //Validation
        LinkedInHomePage linkedInHomePage = new LinkedInHomePage(browser);
        Assert.assertTrue(linkedInHomePage.isLoaded(), "Home page is not loaded");
    }

    @Test
    public void negativeLoginTest(){

        //Enter login
        linkedInLoginPage.Login("assdfs","dddaaa");

        //Validation
        LinkedInLoginSubmitPage linkedInLoginSubmitPage = new LinkedInLoginSubmitPage(browser);
        Assert.assertEquals(linkedInLoginSubmitPage.getAlertBoxText(), "При заполнении формы были допущены ошибки. Проверьте и исправьте отмеченные поля.", "Alert");
    }
}

//HomeWork
//CopyPasteAndCreateManyNegativeTests
//Выделение классов эквивалентности