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
    private String content,xpathReference;
    
    public Procces(byte action,String xpathReference){
        this.action = action;
        this.content = null;
        this.xpathReference = xpathReference;
    }
    
    public Procces(byte action,String content,String xpathReference){
        this.action = action;
        this.content = content;
        this.xpathReference = xpathReference;
    }
    
    public byte getAction(){
        return this.action;
    }
    
    public String getContent(){
        return this.content;
    }
    
    public String getXpathReference(){
        return this.xpathReference;
    }
}
