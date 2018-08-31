
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class Khrystina {
    WebDriver browser;


    @Test
    public void khrystinaMethod(){
    }

    @BeforeMethod
    public void beforeMethod(){
        browser = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\yurii.burlaka.ext\\IdeaProjects\\qaauto-27.07.2018\\chromedriver.exe");
        browser.manage().window().maximize();
        browser.get("http://10.226.113.27/sr/");
    }

    @AfterMethod
    public void afterMethod(){
        //browser.close();
    }
}
