
package Model;

/**
 *
 * @author Jes011
 * @github https://github.com/Jes011
 */
public final class ExecutorBot extends Bot{
    
    private org.openqa.selenium.support.ui.WebDriverWait wait;
    private Instruction[] instructions;
    
    public ExecutorBot(org.openqa.selenium.WebDriver driver, Instruction[] instructions){
        super(driver);
        this.wait = new org.openqa.selenium.support.ui.WebDriverWait(driver, java.time.Duration.ofMinutes(1));
    }
    public void startProcesses() {
        if (this.instructions != null) {

            org.openqa.selenium.WebElement elemento = null;

            for (Instruction instruccion : this.instructions) {

                super.goToPage(instruccion.getPagina().getDomine() + instruccion.getPagina().getPath());

                if (this.checkPresenceOfElements(instruccion.getProcesses())) {
                    System.out.println("Starting...");
                    for (Procces process : instruccion.getProcesses()) {

                        elemento = super.findElement(process.getElement().getXpath());

                        if (process.getAction() == Procces.click) { //CLICK
                            elemento.click();
                        } else if (process.getAction() == Procces.write) { //WRITE
                            elemento.click();
                            elemento.sendKeys(process.getContent());
                        }
                    }
                }else{
                    
                    System.out.print("Do you want to continue? (*/n) : ");
                    
                    if(ComplementaryComponents.read().equalsIgnoreCase("n")){
                        break;
                    }
                    
                }

            }
        }
    }
    
    private boolean checkPresenceOfElements(Procces[] elements) {
        
        System.out.println("Checking the presence of all the elements necessary for the process: ");
        for (Procces element : elements) {
            try {
                wait.until(org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated(org.openqa.selenium.By.xpath(element.getElement().getXpath())));
                System.out.println("Element " + element.getElement().getXpath() + " OK");
            } catch (Exception io) {
                System.err.println("Error: element " + element.getElement().getXpath() + " did not load in 1 minute");
                return false;
            }
        }
        return true;

    }
}
