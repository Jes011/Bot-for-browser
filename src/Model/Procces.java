package Model;

/**
 *
 * @author Jes011
 * @github https://github.com/Jes011
 */
public class Procces implements java.io.Serializable{
    
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
    
    public void setContent(String content){
        this.content = content;
    }
    
    public void setAction(byte action){
        this.action = action;
    }
}
