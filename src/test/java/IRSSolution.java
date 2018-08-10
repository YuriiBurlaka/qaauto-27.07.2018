import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import static java.lang.Thread.sleep;


public class IRSSolution {
    //Add last issue to cut-off list
    @Test
    public void addLastIssue()throws InterruptedException{

        //WebDriver browser = new FirefoxDriver();
        //System.setProperty("webdriver.gecko.driver", "C:\\Windows\\System32\\geckodriver.exe");

        //WebDriver browser = new InternetExplorerDriver();
        //System.setProperty("webdriver.ie.driver", "IEDriverServer.exe");

        WebDriver browser = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\yurii.burlaka.ext\\IdeaProjects\\qaauto-27.07.2018\\chromedriver.exe");


        browser.get("https://ssi.wincor-nixdorf.com/NamosRTS/INTRO.php?action=startpage");
        browser.manage().window().maximize();
        WebElement errorMessage = browser.findElement(By.xpath("/html/body/center/table/tbody/tr[2]/td"));
        if (errorMessage.isEnabled()){
            WebElement loginLink = browser.findElement(By.xpath("/html/body/center/table/tbody/tr[2]/td/a"));
            loginLink.click();
            sleep(1000);
            WebElement loginField = browser.findElement(By.xpath("//*[@id=\"username\"]"));
            loginField.sendKeys("Yurii.Burlaka");
            WebElement passwordField = browser.findElement(By.xpath("//*[@id=\"password\"]"));
            passwordField.sendKeys("Aa14401440");
            WebElement signInButton = browser.findElement(By.xpath("//*[@id=\"login\"]"));
            signInButton.click();
            sleep(7000);

            //WebElement searchOkButton
            WebElement search = browser.switchTo().frame("B").findElement(By.xpath("/html/body/table/tbody/tr[2]/td/table/tbody/tr[8]/td[2]/form/input"));

            //WebElement search = fr.findElement(By.xpath("/html/body/table/tbody/tr[2]/td/table/tbody/tr[10]/td[2]/table/tbody/tr[2]/td[2]/form/input"));
            search.click();
            sleep(2000);


            //browser.get("https://ssi.wincor-nixdorf.com/NamosRTS/LOAD.php?action=searchreport");

            //sleep(10000);
            //WebElement button = browser.findElement(By.linkText("Search"));
            //WebElement button = browser.findElement(By.xpath('//a[@href="javascript:searchwindowopen()"]'));
            //button.click();
            //WebElement cRMnoField = browser.findElement(By.id("errrefnum"));
            //cRMnoField.click();
            //cRMnoField.sendKeys("sdasd");



            //Perform a search (first try)
            //WebElement checkboxAuthor = browser.findElement(By.xpath("//*[@id=\"chkErrorAuthor\"]"));
            //checkboxAuthor.click();
            //WebElement authorName = browser.findElement(By.xpath("//*[@id=\"ctlErrorAuthor[]\"]/option[136]"));
            //authorName.click();
            //WebElement currentStatus = browser.findElement(By.xpath("//*[@id=\"ctlCStatus[]\"]/option[1]"));
            //currentStatus.click();
            //WebElement checkboxProduct = browser.findElement(By.xpath("//*[@id=\"chkProduct\"]"));
            //checkboxProduct.click();
            //WebElement product = browser.findElement(By.xpath("//*[@id=\"ctlProduct[]\"]/option[16]"));
            //product.click();
            //WebElement startSearch = browser.findElement(By.xpath("//*[@id=\"subm\"]"));
            //String newTab = browser.getWindowHandle();
            //startSearch.click();

            //Perform a search (second try)
            //sleep(3000);
            //String newTab = browser.getWindowHandle();
            //browser.switchTo().window(newTab);
            //sleep(2000);
            //Actions action=new Actions(browser);
            //action.sendKeys(Keys.chord(Keys.CONTROL, "a"));
            //sleep(1000);




            //WebElement checkboxAuthor2 = browser.findElement(By.xpath("//*[@id=\"chkErrorAuthor\"]"));
            //checkboxAuthor2.click();
            //WebElement authorName2 = browser.findElement(By.xpath("//*[@id=\"ctlErrorAuthor[]\"]/option[136]"));
            //authorName2.click();
            //WebElement currentStatus2 = browser.findElement(By.xpath("//*[@id=\"ctlCStatus[]\"]/option[1]"));
            //currentStatus2.click();
            //WebElement checkboxProduct2 = browser.findElement(By.xpath("//*[@id=\"chkProduct\"]"));
            //checkboxProduct2.click();
            //WebElement product2 = browser.findElement(By.xpath("//*[@id=\"ctlProduct[]\"]/option[16]"));
            //product2.click();
            //WebElement startSearch2 = browser.findElement(By.xpath("//*[@id=\"subm\"]"));
            //startSearch2.click();

        }
        else{

        }
    }
}

