
package Model;


/**
 *
 * @author Jes011
 * @github https://github.com/Jes011
 * 
 * The lib i'm using does not allow to get the xpath of an element, that's why i'm using this class
 */
public final class Element implements java.io.Serializable{
    
    private String xpath;
    
    public Element(org.openqa.selenium.WebElement element){
        this.xpath = this.generateXPATH(element, "");
    }
    
    private String generateXPATH(org.openqa.selenium.WebElement childElement, String current) {
        String childTag = childElement.getTagName();
        if (childTag.equals("html")) {
            return "/html[1]" + current;
        }
        org.openqa.selenium.WebElement parentElement = childElement.findElement(org.openqa.selenium.By.xpath(".."));
        java.util.List<org.openqa.selenium.WebElement> childrenElements = parentElement.findElements(org.openqa.selenium.By.xpath("*"));
        int count = 0;
        for (int i = 0; i < childrenElements.size(); i++) {
            org.openqa.selenium.WebElement childrenElement = childrenElements.get(i);
            String childrenElementTag = childrenElement.getTagName();
            if (childTag.equals(childrenElementTag)) {
                count++;
            }
            if (childElement.equals(childrenElement)) {
                return generateXPATH(parentElement, "/" + childTag + "[" + count + "]" + current);
            }
        }
        return null;
    }
    
    public String getXpath(){
        return this.xpath;
    }
}
