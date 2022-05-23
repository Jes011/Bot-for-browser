package Model;



/**
 *
 * @author Jes011
 * @github https://github.com/Jes011
 *
 * Process to Procces !!!!!!
 */
public abstract class Bot {

    private org.openqa.selenium.WebDriver driver;
    private org.openqa.selenium.WebDriver.Timeouts waitDomPage;
    

    public Bot(org.openqa.selenium.WebDriver driver) {
        this.driver = driver;
        this.driver.manage().window().minimize();
    }

    protected final void solicitarURL() {
        String entrada = "";
        while (true) {
            System.out.print("URL: ");
            entrada = ComplementaryComponents.read();
            try {
                this.goToPage(entrada);
                break;
            } catch (Exception io) {
                System.err.println("Error: you must type the url in this way : https://www.example.dominio");
            }
        }
    }
    
    protected final void goToPage(String url) {
        this.driver.navigate().to(url);
        waitDomPage = this.driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(30));
        System.out.println(url + " ha en cargado en " + waitDomPage.getPageLoadTimeout().getSeconds() + " segundos.");
        
        
    }
    
    protected final org.openqa.selenium.WebElement findElement(String xpath) {
        return this.driver.findElement(org.openqa.selenium.By.xpath(xpath));
    }
    
    protected final java.util.List<org.openqa.selenium.WebElement> findElements(String tagname){
        return this.driver.findElements(org.openqa.selenium.By.tagName(tagname));
    }

    

}
