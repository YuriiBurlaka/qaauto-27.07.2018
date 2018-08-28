import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import static java.lang.Thread.sleep;

public class LinkedInForgotPasswordTest {

    WebDriver browser;
    LinkedInLoginPage linkedInLoginPage;
    String userEmail;
    String newPassword;
    String emailPassword;

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
    public void positivePasswordChanging() {
        String[] credentials = readFileWithCredentials("LinkedInMail.txt");
        userEmail = credentials[0];
        newPassword = credentials[1];
        emailPassword = credentials[2];
        Assert.assertTrue(linkedInLoginPage.isLoaded(), "LoginPage is not loaded");

        //ForgotPassword click
        LinkedInRequestPasswordResetPage linkedInRequestPasswordResetPage = linkedInLoginPage.clickOnForgotPasswordLink();

        try {
            sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //Validation
        Assert.assertTrue(linkedInRequestPasswordResetPage.isLoaded(), "ForgotPassword page is not loaded");
        LinkedInPasswordResetSubmitPage linkedInPasswordResetSubmitPage = linkedInRequestPasswordResetPage.findAccount(userEmail);

        try {
            sleep(120000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //Validation
        Assert.assertTrue(linkedInPasswordResetSubmitPage.isLoaded(), "LinkedInPasswordResetSubmitPage page is not loaded");

        try {
            sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        LinkedInSetNewPasswordPage linkedInsetNewPasswordPage = linkedInPasswordResetSubmitPage.navigateToLinkFromEmail();


        LinkedInSuccessfullResetPasswordPage linkedInSuccessfullResetPasswordPage = linkedInsetNewPasswordPage.confirmResetPassword(newPassword);

    }

    public String[] readFileWithCredentials(String filename)
    {
        String content = "";
        File file = new File("C:\\Users\\yurii.burlaka.ext\\Desktop\\"+filename);
        try {
            FileReader reader = new FileReader(file);
            char[] chars = new char[(int) file.length()];
            reader.read(chars);
            content = new String(chars);
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Please check a file with credentials. Probably that file was removed and deleted.");
        }
        String credentials[] =content.split("\\n");
        return credentials;
    }
}
