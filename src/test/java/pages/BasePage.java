package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.GMailService;


/**
 * Page object class for BasePage
 */
public abstract class BasePage {
    protected WebDriver browser;
    protected static GMailService gMailService = new GMailService();

    /**
     * wait method requires Webelement which should be available and max. timeout value
     */
    public WebElement waitUntilElementIsVisible (WebElement webElement, int timeOutInSeconds){
        WebDriverWait wait = new WebDriverWait(browser, timeOutInSeconds);
        wait.until(ExpectedConditions.visibilityOf(webElement));
        return webElement;
    }

    /**
     * returns current page title for check
     */
    public String getCurrentPageTitle(){

        return browser.getTitle();
    }

    /**
     * returns current page title for check
     */
    public String getCurrentUrl(){

        return browser.getCurrentUrl();    }

    /**
     * This method checks that required page was loaded
     * Abstract method, will be created for all subclasses
     */
    public abstract boolean isLoaded();

}





