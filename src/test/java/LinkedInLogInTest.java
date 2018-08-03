import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import static java.lang.Thread.sleep;


public class LinkedInLogInTest {
    @Test
    public void successfullLoginTest(){
        //HomeWork
    }

    @Test
    public void negativeLoginTest() throws InterruptedException {
        WebDriver browser = new FirefoxDriver(); //open browser
        browser.get("https://www.linkedin.com/"); //goto
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

