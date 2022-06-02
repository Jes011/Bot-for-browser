package Model;

/**
 *
 * @author Jes011
 * @github https://github.com/Jes011
 */
public class WebPage implements java.io.Serializable{
    
    public static final long serialVersionUID = 10L;
    
    public final static String Static = "Static";
    public final static String Dynamic = "Dynamic";
    
    private String url,type;
    private java.util.ArrayList<Model.Element> elements;
    
    public WebPage(String url,String type,java.util.ArrayList<Model.Element> elements){
        this.url = url;
        this.type = type;
        this.elements = elements;
    }
    
    public String getType() {
        return this.type;
    }
    public String getURL() {
        return this.url;
    }
    public java.util.ArrayList<Model.Element> getElements(){
        return this.elements;
    }
    
}
