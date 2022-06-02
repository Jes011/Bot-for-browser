package Model;

/**
 *
 * @author Jes011
 * @github https://github.com/Jes011
 */
public class Instruction implements java.io.Serializable{
    private WebPage page;
    private String name;
    private java.util.ArrayList<Procces> processes;
    
    public Instruction(String name,WebPage page,java.util.ArrayList<Procces> processes){
        this.name = name;
        this.page = page;
        this.processes=processes;
    }
    
    public WebPage getPage(){
        return this.page;
    }
    
    public java.util.ArrayList<Procces> getProcesses(){
        return this.processes;
    }
    
    public String getName(){
        return this.name;
    }
}
