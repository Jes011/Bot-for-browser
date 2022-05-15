package Model;

/**
 *
 * @author Jes011
 * @github https://github.com/Jes011
 */
public class Instruction {
    private WebPage page;
    private Procces[] processes;
    
    public Instruction(WebPage page,Procces[] processes){
        this.page = page;
        this.processes=processes;
    }
    
    public WebPage getPagina(){
        return this.page;
    }
    
    public Procces[] getProcesses(){
        return this.processes;
    }
}
