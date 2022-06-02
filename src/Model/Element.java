
package Model;


/**
 *
 * @author Jes011
 * @github https://github.com/Jes011
 * 
 * The lib i'm using does not allow to get the xpath of an element, that's why i'm using this class
 */
public class Element implements java.io.Serializable{
    
    private String xpath;
    
    public Element(String xpath){
        this.xpath = xpath;
    }
    
    public String getXpath(){
        return this.xpath;
    }
    
    @Override
    public String toString(){
        return this.xpath;
    }
}
