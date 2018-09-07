import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


import static java.lang.Thread.sleep;


public class Khrystina {
    WebDriver browser;
    WebElement searchField;


    @Test
    public void khrystinaMethod() {
        WebDriverWait wait = new WebDriverWait(browser, 4);
        WebElement searchFiled = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type=\"search\"]")));
        String searchText = "burl";
        searchFiled.sendKeys(searchText);
        String [] credentials = readFile("Report.txt");
        String reportName = credentials[0];
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement report = browser.findElement(By.linkText(reportName));
        report.click();
        boolean reportIsExist = reportForCurrentDateIsAvailable();
        if (reportIsExist){
            System.out.println("Everything is fine");
        }
        else{
            System.out.println("Report for current date is not avaialble");
            createDummyReport();
        }
    }

    public boolean reportForCurrentDateIsAvailable(){

        LocalDate sDate = LocalDate.now();
        String correctDate = sDate.toString().replace("-",".");
        List<WebElement> dates = browser.findElements(By.xpath("/html/body/div[2]/table[2]/tbody/tr[*]/td[1]"));

        List<String> datesList=new ArrayList<String>();
        for (WebElement date : dates){
            datesList.add(date.getText());
        }
        boolean ifExist = Arrays.asList(datesList).contains(correctDate);
        //for(String a : datesList)
           // if (a.trim().contains(correctDate)) {
              //  ifExist = true;
             //   break;
           // } else {
            //   ifExist = false;
            //    break;
           // }
        return ifExist;
    }

    public boolean createDummyReport(){
        return true;
    }

    @BeforeMethod
    public void beforeMethod() {
        browser = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\yurii.burlaka.ext\\IdeaProjects\\qaauto-27.07.2018\\chromedriver.exe");
        browser.manage().window().maximize();
        browser.get("http://10.226.113.27/sr/");
    }

    @AfterMethod
    public void afterMethod() {
        //browser.close();
    }

    public WebElement sdf(String searchText) {
        WebElement asd = null;
        WebElement searchFiled = browser.findElement(By.xpath("//input[@type=\"search\"]"));
        searchFiled.sendKeys(searchText);
        List<WebElement> statusList = browser.findElements(By.xpath("//*[@id=\"example\"]/tbody/tr[*]"));
        for (WebElement reportLine : statusList) {
            boolean a = reportLine.getText().toLowerCase().matches("opened");
            if (a) {
                asd = reportLine;
            } else {

            }
        }
        return asd;
    }

    public String[] readFile(String filename) {
        String content = "";

        File file = new File("C:\\Users\\yurii.burlaka.ext\\Desktop\\" + filename);
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
        String credentials[] = content.split("\\n");
        return credentials;
    }
}