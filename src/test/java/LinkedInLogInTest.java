import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LinkedInLogInTest {
    WebDriver browser;
    LinkedInLoginPage linkedInLoginPage;


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


    @DataProvider
    public Object[][] validFieldsCombination() {
        return new Object[][]{
                { "mrentertheusername@gmail.com", "a14401440" },
                { "MREntertheuserNAME@gmail.com", "a14401440" }
        };
    }

    @Test (dataProvider = "validFieldsCombination")
    public void successfulLoginTest(String userEmail, String userPass){

        //LogIn
        LinkedInHomePage linkedInHomePage = linkedInLoginPage.loginReturnHomePage(userEmail, userPass);

        //Validation
        Assert.assertTrue(linkedInHomePage.isLoaded(), "Home page is not loaded");




    }

    @Test
    public void negativeLoginTestWrongDataEntered(){

        //Enter login
        LinkedInLoginSubmitPage linkedInLoginSubmitPage = linkedInLoginPage.loginReturnSubmitPage("assdfs","dddaaa");

        //Validation
        //LinkedInLoginSubmitPage linkedInLoginSubmitPage = new LinkedInLoginSubmitPage(browser);
        Assert.assertEquals(linkedInLoginSubmitPage.getAlertBoxText(), "При заполнении формы были допущены ошибки. Проверьте и исправьте отмеченные поля.", "Alert");
    }

    @Test
    public void negativeLoginTestEmptyLoginField(){

        //Enter login
        linkedInLoginPage.loginReturnLoginPage("","dddaaa");

        //Validation
        Assert.assertTrue(linkedInLoginPage.isLoaded(), "Incorrect browser response to an empty field");
    }

    @Test
    public void negativeLoginTestEmptyPasswordField(){

        //Enter login
        linkedInLoginPage.loginReturnLoginPage("dfdf@assdfs.com","");

        //Validation
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
        LinkedInLoginSubmitPage linkedInLoginSubmitPage = linkedInLoginPage.loginReturnSubmitPage(userEmail, userPass);
        //LinkedInLoginSubmitPage linkedInLoginSubmitPage = new LinkedInLoginSubmitPage(browser);

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

        //Enter login
        linkedInLoginPage.loginReturnLoginPage(userEmail, userPass);

        //Validation
        Assert.assertTrue(linkedInLoginPage.isLoaded(), "User is not on login page");
    }
}

