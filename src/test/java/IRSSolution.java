import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import static java.lang.Thread.sleep;


public class IRSSolution {

    public String[] readFile(String filename)
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


    //Add last issue to cut-off list
    @Test
   public void addLastIssue()throws InterruptedException{

        //Initialize all variables
        String[] credentials = readFile("123.txt");
        String cutoffList = credentials[2];
        String username = credentials[0];
        String password = credentials[1];

        //Start
        WebDriver browser = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\yurii.burlaka.ext\\IdeaProjects\\qaauto-27.07.2018\\chromedriver.exe");

        browser.get("https://ssi.wincor-nixdorf.com/NamosRTS/INTRO.php?action=startpage");
        browser.manage().window().maximize();
        WebElement errorMessage = browser.findElement(By.xpath("/html/body/center/table/tbody/tr[2]/td"));

        if (errorMessage.isEnabled()){
            WebElement loginLink = browser.findElement(By.xpath("/html/body/center/table/tbody/tr[2]/td/a"));
            loginLink.click();

            //+Wait instead of Sleep
            WebDriverWait wait = new WebDriverWait(browser, 10);
            WebElement loginField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"username\"]")));

            loginField.sendKeys(username);
            WebElement passwordField = browser.findElement(By.xpath("//*[@id=\"password\"]"));
            passwordField.sendKeys(password);
            WebElement signInButton = browser.findElement(By.xpath("//*[@id=\"login\"]"));
            signInButton.click();
            sleep(7000);

            //WebElement searchOkButton
            WebElement search = browser.switchTo().frame("B").findElement(By.xpath("/html/body/table/tbody/tr[2]/td/table/tbody/tr[8]/td[2]/form/input"));
            search.click();
            sleep(4000);

            browser.switchTo().parentFrame();
            WebElement dfdf = ((ChromeDriver) browser).findElementByXPath(".//frame[contains(@name,'C')]");
            browser.switchTo().frame(dfdf);

            //Get all issues from displayed list
            List <WebElement> cells = ((ChromeDriver) browser).findElementsByPartialLinkText("WINSSI");

            List<String> firstList=new ArrayList<String>();
            for (WebElement issue: cells) {
                firstList.add(issue.getText());
            }

            //Maintain cut-off list
            browser.switchTo().parentFrame();
            WebElement maintainListDetail = browser.switchTo().frame("B").findElement(By.partialLinkText("Maintain list details"));
            maintainListDetail.click();
            sleep(1500);
            browser.switchTo().parentFrame();
            WebElement mainFrame = ((ChromeDriver) browser).findElementByXPath(".//frame[contains(@name,'C')]");
            browser.switchTo().frame(mainFrame);

            //select fropdown list
            Select dropdown = new Select(browser.findElement(By.xpath("//select[@name='idAddGroup[0]']")));

            //select necessary cut-off list
            dropdown.selectByVisibleText(cutoffList);
            WebElement showButton = browser.findElement(By.xpath("/html/body/form[1]/table/tbody/tr/td[3]/input"));
            showButton.click();

            //Wait
            WebElement checkElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/form[2]/fieldset/table/tbody/tr[3]/td/table/tbody/tr['2']/td[3]/span")));

            //Get added issues
            List<WebElement> addedIssues = browser.findElements(By.xpath("/html/body/form[2]/fieldset/table/tbody/tr[3]/td/table/tbody/tr['*']/td[3]/span"));

            List<String> secondList=new ArrayList<String>();
            for (WebElement addedIssue: addedIssues) {
                //Convert List<WebElement> => List<String>
                secondList.add(addedIssue.getText());
            }

            //Compare 2 lists (Added and found issues)
            Collection<String> similar = new HashSet<String>(firstList);
            Collection<String> differens = new HashSet<String>();
            differens.addAll(firstList);
            differens.removeAll(secondList);
            System.out.printf("Found issues:%s%n", differens);

            if(differens.size()>=1){

                //insert non-added issues
                WebElement addForm = browser.findElement(By.xpath("//*[contains(@id,'formEntry')]"));
                addForm.click();
                for (String nonAddedIssue: differens) {
                    addForm.sendKeys(nonAddedIssue);
                    addForm.sendKeys(Keys.ENTER);
                }
                WebElement saveButton = browser.findElement(By.xpath("//*[@value='Add manual entries']"));
                saveButton.click();
                //sleep(1500);

                //Wait + check
                WebElement checkElement2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='info']")));
                //(/html/body/center/table/tbody/tr/td)
                System.out.println(checkElement2.getText());
                browser.close();

            }
            else{
                System.out.println("All issues already added to current cutt-off list");
                browser.close();
            }

        }
        else{

        }
    }
}

