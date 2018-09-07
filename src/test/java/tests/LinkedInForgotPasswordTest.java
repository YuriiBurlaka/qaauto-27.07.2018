package tests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import static java.lang.Thread.sleep;

public class LinkedInForgotPasswordTest extends BaseTest{
    String userEmail;
    String newPassword;
    String emailPassword;

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
            sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //Validation
        Assert.assertTrue(linkedInPasswordResetSubmitPage.isLoaded(), "pages.LinkedInPasswordResetSubmitPage page is not loaded");

        LinkedInSetNewPasswordPage linkedInsetNewPasswordPage = linkedInPasswordResetSubmitPage.navigateToLinkFromEmail();

        LinkedInSuccessfullResetPasswordPage linkedInSuccessfullResetPasswordPage = linkedInsetNewPasswordPage.confirmResetPassword(newPassword);
        Assert.assertTrue(linkedInSuccessfullResetPasswordPage.isLoaded(),
                "SuccessfulPasswordResetPage is not loaded.");

        LinkedInHomePage linkedinHomePage =
                linkedInSuccessfullResetPasswordPage.clickOnGoToHomeButton();
        //sleep(180000);
        Assert.assertTrue(linkedinHomePage.isLoaded(),
                "HomePage is not loaded.");

      }
    }

