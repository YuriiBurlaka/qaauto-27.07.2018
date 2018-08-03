
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
        if(searchResults.size() == 10){
           System.out.println("Results count is correct");
        }
        else {
           System.out.println("Results count is incorrect");
        }

        //Verify that each result contains searchterm, e.g. "Selenium"
        int counter=0;
        for (WebElement searchResult: searchResults){
            String searchResultText = searchResult.getText();

           int index = searchResultText.indexOf("elenium");
           if (index >=1){

              counter++;
              System.out.println("Searchterm found");

           }
           else{
              System.out.println("Searchterm not found");
               counter=counter;

           }

           //System.out.println(searchResultText);
        }

        if (counter == searchResults.size()){
            System.out.println("Searchterm found (additional global check)");
        }
        else{
            System.out.println("Searchterm not found (additional global check)");
        }

        sleep(3000);
        browser.close();
    }
}
