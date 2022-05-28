package Model;

/**
 *
 * @author Jes011
 * @github https://github.com/Jes011
 */
public class WebPage implements java.io.Serializable{
    private String url;
    private java.util.ArrayList<Model.Element> elements;
    
    public WebPage(String url,java.util.ArrayList<Model.Element> elements){
        this.url = url;
        this.elements = elements;
    }
    
    public String getURL() {
        return url;
    }
    
}
