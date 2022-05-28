
package Model;

/**
 *
 * @author Jes011
 * @github https://github.com/Jes011
 */
public class Manager {
    
    private org.openqa.selenium.WebDriver driver;
    private SearcherBot searcherBot;
    
    public Manager(){
        
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver/chromedriver");
        
        this.driver = new org.openqa.selenium.chrome.ChromeDriver();
        this.driver.manage().window().minimize();
        
        this.searcherBot = new Model.SearcherBot(driver);
    }
    
    public java.util.ArrayList<Model.Element> searchElements(){
        return this.searcherBot.searchPageElements();
    }
    
    public void savePage(java.util.ArrayList<Model.Element> elements){
        WebPage page = new WebPage(this.driver.getCurrentUrl(),elements);
        FileManager.savePage(page);
        
    }
    
    public org.openqa.selenium.WebDriver getDriver(){
        return this.driver;
    }
}
