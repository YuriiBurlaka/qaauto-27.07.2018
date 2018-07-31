
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.List;
import static java.lang.Thread.sleep;

public class BadCodeExample {
    public static void main (String args []) throws InterruptedException {
        System.out.println("Hello world!!!");
        WebDriver browser = new FirefoxDriver(); //open browser
        browser.get("http://www.google.com"); //goto
        WebElement element = browser.findElement(By.id("lst-ib"));
        element.sendKeys("Selenium");
        element.sendKeys(Keys.ENTER);

        //Verify that results list contains 10 elements
        sleep(4000);
        List<WebElement> searchResults = browser.findElements(By.xpath("//div[@class='srg']/div[@class='g']"));

        System.out.println("Results count: " +searchResults.size());

        //Дописать проверку что результатов 10 или нет


        //Verify that each result contains searchterm, e.g. "Selenium"
        for (WebElement searchResult: searchResults){
            String searchResultText = searchResult.getText();
            System.out.println(searchResultText);
        }
        //дописать проверку что есть слово Selenium


        sleep(3000);
        browser.close();
    }
}
