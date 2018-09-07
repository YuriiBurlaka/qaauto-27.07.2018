package tests;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LinkedInHomePage;
import pages.LinkedInLoginSubmitPage;

public class LinkedInLogInTest extends BaseTest{

    @DataProvider
    public Object[][] validFieldsCombination() {
        return new Object[][]{
                { "mrentertheusername@gmail.com", "Aa14401440" },
                { "MREntertheuserNAME@gmail.com", "Aa14401440" }
        };
    }

    @Test (dataProvider = "validFieldsCombination")
    public void successfulLoginTest(String userEmail, String userPass){
        LinkedInHomePage linkedInHomePage = linkedInLoginPage.login(userEmail, userPass);
        Assert.assertTrue(linkedInHomePage.isLoaded(), "Home page is not loaded");
    }

    @Test
    public void negativeLoginTestWrongDataEntered(){

        LinkedInLoginSubmitPage linkedInLoginSubmitPage = linkedInLoginPage.login("assdfs","dddaaa");
        Assert.assertEquals(linkedInLoginSubmitPage.getAlertBoxText(), "При заполнении формы были допущены ошибки. Проверьте и исправьте отмеченные поля.", "Alert");
    }

    @Test
    public void negativeLoginTestEmptyLoginField(){
        linkedInLoginPage.login("","dddaaa");
        Assert.assertTrue(linkedInLoginPage.isLoaded(), "Incorrect browser response to an empty field");
    }

    @Test
    public void negativeLoginTestEmptyPasswordField(){
        linkedInLoginPage.login("dfdf@assdfs.com","");
        Assert.assertTrue(linkedInLoginPage.isLoaded(), "Incorrect browser response to an empty field");
    }



    @DataProvider
    public Object[][] userpassAndLoginFieldsCombination() {
        return new Object[][]{
                { "a", "a", "Слишком короткий текст (минимальная длина – 3 симв., введено – 1 симв.).","Пароль должен содержать не менее 6 символов."},
                { "aa", "a", "Слишком короткий текст (минимальная длина – 3 симв., введено – 2 симв.).","Пароль должен содержать не менее 6 символов."},
                { "aaa", "a", "Укажите действительный адрес эл. почты.", "Пароль должен содержать не менее 6 символов."},
                { "@com", "aaaaaa", "Укажите действительный адрес эл. почты.", ""},
                { "+", "aaaaaa", "Этот адрес эл. почты не зарегистрирован в LinkedIn. Повторите попытку.", ""},
                { "1", "aaaaaa", "Обязательно включите в номер значок «+» и код своей страны.", ""},
                { "+1", "1", "", "Пароль должен содержать не менее 6 символов."},
                { "ertertetertetertertertetetertetetetetetertetetetettertretertertertretertertertertertertrtertertrtetetertetettetertertetetertertef", "111111", "Слишком длинный текст: максимальная длина – 128 симв., введено 129 симв.", ""},
                { "ertertetertetertertertetetertetetetetetertetetetettertretertertertretertertertertertertrtertertrtetetertetettetertertetetertertef", "1", "Слишком длинный текст: максимальная длина – 128 симв., введено 129 симв.", "Пароль должен содержать не менее 6 символов."},
                { "+1", "ertertetertetertertertetetertetetetetetertetetetettertretertertertretertertertertertertrtertertrteteertertetertetertertertetetertetetetetetertetetetettertretertertertretertertertertertertrtertertrteteertertetertetertertertetetertetetetetetertetetetettertretertertertretertertertertertertrtertertrteteertertetertetertertertetetertetetetetetertetetetettertretertertertretertertertertertertrtertertrteted", "", "Пароль должен содержать не более 400 символов."},
        };
    }

    @Test(dataProvider = "userpassAndLoginFieldsCombination")
    public void validateCombinationsForUserEmailAndPassword(String userEmail, String userPass, String requiredLoginMessage, String requiredPassMessage){
        LinkedInLoginSubmitPage linkedInLoginSubmitPage = linkedInLoginPage.login(userEmail, userPass);
        Assert.assertTrue(linkedInLoginSubmitPage.isLoaded(), "User is not on loginSubmit page");
        Assert.assertEquals(linkedInLoginSubmitPage.getUserEmailValidationText(),requiredLoginMessage,"userEmail field has wrong validation message");
        Assert.assertEquals(linkedInLoginSubmitPage.getUserPasswordValidationText(),requiredPassMessage,"userPass field has wrong validation message");
    }


    @DataProvider
    public Object[][] emptyFieldsCombination() {
        return new Object[][]{
                { "", "" },
                { "", "P@ssword123" },
                { "someone@domain.com", "" }
        };
    }

    @Test(dataProvider = "emptyFieldsCombination")
    public void negativeLoginTestEmptyFields(String userEmail, String userPass){
        linkedInLoginPage.login(userEmail, userPass);
        Assert.assertTrue(linkedInLoginPage.isLoaded(), "User is not on login page");
    }
}

