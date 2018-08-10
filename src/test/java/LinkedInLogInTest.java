import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static java.lang.Thread.sleep;


public class LinkedInLogInTest {
    WebDriver browser;

    @BeforeMethod
    public void beforeMethod(){
        browser = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\yurii.burlaka.ext\\IdeaProjects\\qaauto-27.07.2018\\chromedriver.exe");
        browser.manage().window().maximize();
        browser.get("https://www.linkedin.com/");
    }

    @AfterMethod
    public void afterMethod(){
        browser.close();
    }

    @Test
    public void successfulLoginTest() throws InterruptedException {

        //LogIn
        LinkedInLoginPage linkedInLoginPage = new LinkedInLoginPage(browser);
        linkedInLoginPage.Login("mrentertheusername@gmail.com","a14401440");

        //Wait
        Wait<WebDriver> wait = new WebDriverWait(browser,7).withMessage("Element was not found");
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"nav-settings__dropdown-trigger\"]/div/span[1]")));

        //Validations:
        //check that specific element is available
        LinkedInHomePage linkedInHomePage = new LinkedInHomePage(browser);
        Assert.assertTrue(linkedInHomePage.isNavigationItemDisplayed(), "Navigation item is not displayed.");

        //compare page title
        String title = browser.getTitle();
        Assert.assertEquals(title,"LinkedIn","Recived result is not correct");

        //compare URL
        String pageURL = browser.getCurrentUrl();
        Assert.assertEquals(pageURL, "https://www.linkedin.com/feed/","Recived URL is not correct");
    }

    @Test
    public void negativeLoginTest() throws InterruptedException {

        //Enter login
        WebElement loginField = browser.findElement(By.xpath("//*[@id=\"login-email\" and @class = \"login-email\"]"));
        loginField.sendKeys("assdfs");
        //Enter password
        WebElement passwordField = browser.findElement(By.xpath("//*[@id=\"login-password\"]"));
        passwordField.sendKeys("dddaaa");
        //Click "LogIn"
        WebElement signInButton = browser.findElement(By.xpath("//*[@id=\"login-submit\"]"));
        signInButton.click();
        //Validation
        sleep(3000);
        WebElement errorMessage = browser.findElement(By.xpath("//*[@role = 'alert']"));
        Assert.assertEquals(errorMessage.getText(), "При заполнении формы были допущены ошибки. Проверьте и исправьте отмеченные поля.", "Alert");



    }
}

