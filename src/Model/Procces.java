package Model;

/**
 *
 * @author Jes011
 * @github https://github.com/Jes011
 */
public class Procces {
    
    public final static byte click = 1;
    
    public final static byte write = 2;
    
    private byte action;
    private String content;
    private Element element;
    
    public Procces(byte action,Element element){
        this.action = action;
        this.content = null;
        this.element = element;
    }
    
    public Procces(byte action,String content,Element element){
        this.action = action;
        this.content = content;
        this.element = element;
    }
    
    public byte getAction(){
        return this.action;
    }
    
    public String getContent(){
        return this.content;
    }
    
    public Element getElement(){
        return this.element;
    }
}
