package Model;

/**
 *
 * @author Jes011
 * @github https://github.com/Jes011
 */
public class WebPage {
    private String domine,path,xpaths[];
    
    public WebPage(String domine,String path,String xpaths[]){
        this.domine = domine;
        this.path= path;
        this.xpaths = xpaths;
    }
    
    public String getDomine() {
        return domine;
    }
    public void setDomine(String domine) {
        this.domine = domine;
    }

    public String getPath() {
        return path;
    }
    public void setPath(String path) {
        this.path = path;
    }

    public String[] getXpaths() {
        return xpaths;
    }
    public void setXpaths(String[] xpaths) {
        this.xpaths = xpaths;
    }
    
}
