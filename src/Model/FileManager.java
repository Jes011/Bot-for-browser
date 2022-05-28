
package Model;

/**
 *
 * @author Jes011
 * @github https://github.com/Jes011
 */
public abstract class FileManager {
    
    public static java.io.File main = new java.io.File("main"),pages = (System.getProperty("os.name").equalsIgnoreCase("linux"))?new java.io.File(FileManager.main.getPath()+"/pages"):new java.io.File(FileManager.main.getAbsolutePath()+"\\pages");
    
    private static java.io.ObjectOutputStream writer = null;
    
    private FileManager(){
    }
    
    public static void mkdirs(){
        main.mkdir();
        pages.mkdir();
    }
    
    public static void savePage(WebPage page){
        
        try{
            FileManager.writer = new java.io.ObjectOutputStream(new java.io.FileOutputStream(pages.getPath()+((System.getProperty("os.name").equalsIgnoreCase("linux"))?"/":"\\")+page.getURL().substring(0, page.getURL().length()-1).substring(8, page.getURL().length()-1)+".you"));
            
            FileManager.writer.writeObject(page);
            
            FileManager.writer.close();
            System.out.println(ComplementaryComponents.ANSI_BLUE+page.getURL()+" saved"+ComplementaryComponents.RESET);
        }catch(java.io.IOException io){
            io.printStackTrace();
            System.err.println("Error: the file could not be saved");
        }
        
    }
}
