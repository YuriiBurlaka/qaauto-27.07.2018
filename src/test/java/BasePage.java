import org.openqa.selenium.WebDriver;

public abstract class BasePage {

    protected WebDriver browser;

    public String getCurrentPageTitle(){
        return browser.getTitle();
    }

    public String getCurrentUrl(){

        return browser.getCurrentUrl();    }

    public abstract boolean isLoaded();

}





