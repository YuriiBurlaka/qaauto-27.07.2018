package tests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import pages.LinkedInLoginPage;

public class BaseTest {
    WebDriver browser;
    LinkedInLoginPage linkedInLoginPage;

    @Parameters({"browserName", "envURL"})
    @BeforeMethod
    public void beforeMethod(@Optional("chrome") String browserName, @Optional("UA") String countyCode){
        if (browserName.toLowerCase().equals("firefox")){
            browser = new FirefoxDriver();
        }
        if(browserName.toLowerCase().equals("chrome")) {
            browser = new ChromeDriver();
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\yurii.burlaka.ext\\IdeaProjects\\qaauto-27.07.2018\\chromedriver.exe");
        }
        else {
            try {
                throw new Exception( "browser:" +browserName+ "is not supported");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        browser.manage().window().maximize();

        if (countyCode.toLowerCase().equals("ua")){
            browser.get("https://ua.linkedin.com/");
        }
        if (countyCode.toLowerCase().equals("ru")){
            browser.get("https://ru.linkedin.com/");
        }
        if (countyCode.toLowerCase().equals("de")){
            browser.get("https://de.linkedin.com/");
        }
        else {
            try {
                throw new Exception( "CountryCode:" +countyCode+ "is not supported");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        linkedInLoginPage = new LinkedInLoginPage(browser);
    }

    @AfterMethod
    public void afterMethod(){
        browser.close();
    }
}
