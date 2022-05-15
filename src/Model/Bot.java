package Model;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 *
 * @author Jes011
 * @github https://github.com/Jes011
 *
 * Process to Procces !!!!!!
 */
public class Bot {

    private org.openqa.selenium.WebDriver driver;
    private org.openqa.selenium.support.ui.WebDriverWait wait;
    private org.openqa.selenium.WebDriver.Timeouts waitDomPage;
    private Instruction[] instructions;

    public Bot(org.openqa.selenium.WebDriver driver, Instruction[] instructions) {
        this.driver = driver;
        this.instructions = instructions;
        this.wait = new org.openqa.selenium.support.ui.WebDriverWait(driver, java.time.Duration.ofMinutes(1));
    }

    public void startProcesses() {
        if (this.instructions != null) {

            org.openqa.selenium.WebElement elemento = null;

            for (Instruction instruccion : this.instructions) {

                this.goToPage(instruccion.getPagina().getDomine() + instruccion.getPagina().getPath());

                if (this.checkPresenceOfElements(instruccion.getProcesses())) {
                    System.out.println("Starting...");
                    for (Procces process : instruccion.getProcesses()) {

                        elemento = this.findElement(process.getXpathReference());

                        if (process.getAction() == Procces.click) { //CLICK
                            elemento.click();
                        } else if (process.getAction() == Procces.write) { //WRITE
                            elemento.click();
                            elemento.sendKeys(process.getContent());
                        }
                    }
                }else{
                    
                    System.out.println("Do you want to continue? (*/n)");
                    
                    if(ComplementaryMethods.read().equalsIgnoreCase("n")){
                        break;
                    }
                    
                }

            }
        }
    }

    private final void goToPage(String url) {
        this.driver.navigate().to(url);
        waitDomPage = this.driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(30));
        System.out.println(url + " ha en cargado en " + waitDomPage.getPageLoadTimeout().getSeconds() + " segundos.");
    }

    private final org.openqa.selenium.WebElement findElement(String xpath) {
        return this.driver.findElement(By.xpath(xpath));
    }

    private final boolean checkPresenceOfElements(Procces[] elements) {
        
        System.out.println("Checking the presence of all the elements necessary for the process: ");
        for (Procces element : elements) {
            try {
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(element.getXpathReference())));
                System.out.println("Element " + element.getXpathReference() + " OK");
            } catch (Exception io) {
                System.out.println("Error: element " + element.getXpathReference() + " did not load in 1 minute");
                return false;
            }
        }
        return true;

    }

}
