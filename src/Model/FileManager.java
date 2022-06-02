package Model;

/**
 *
 * @author Jes011
 * @github https://github.com/Jes011
 */
public abstract class FileManager {

    public static java.io.File main = new java.io.File("main"), instructions = new java.io.File(FileManager.main.getPath()+((System.getProperty("os.name").equalsIgnoreCase("linux"))?"/":"\\")+"instructions"),pages = new java.io.File(FileManager.main.getPath() + ((System.getProperty("os.name").equalsIgnoreCase("linux")) ? "/" : "\\")+"pages");

    private static java.io.ObjectOutputStream writer = null;

    private static java.io.ObjectInputStream reader = null;

    private FileManager() {
    }

    public static void mkdirs() {
        FileManager.main.mkdir();
        FileManager.instructions.mkdir();
        FileManager.pages.mkdir();
    }

    public static void savePage(WebPage page) {

        try {
            FileManager.writer = new java.io.ObjectOutputStream(new java.io.FileOutputStream(pages.getPath() + ((System.getProperty("os.name").equalsIgnoreCase("linux")) ? "/" : "\\") + page.getType()+"--"+page.getURL().substring(0, page.getURL().length() - 1).substring(8, page.getURL().length() - 1) + ".you"));

            FileManager.writer.writeObject(page);

            FileManager.writer.close();
            System.out.println(ComplementaryComponents.ANSI_BLUE + page.getURL() + " saved" + ComplementaryComponents.RESET);
        } catch (java.io.IOException io) {
            io.printStackTrace();
            System.err.println("Error: the file could not be saved");
        }

    }

    public static WebPage loadPage(String webPageFileName){
        try {
            FileManager.reader = new java.io.ObjectInputStream(new java.io.FileInputStream(pages.getPath() + ((System.getProperty("os.name").equalsIgnoreCase("linux")) ? "/" : "\\") +webPageFileName));
            WebPage page = (WebPage) FileManager.reader.readObject();
            FileManager.reader.close();
            return page;
        } catch (java.io.IOException io) {
            io.printStackTrace();
            System.err.println("Error: The file "+webPageFileName+" can not be load");
        }catch(ClassNotFoundException io){
            System.err.println("Error: WebPage file not found");
        }
        return null;
    }
    
    public static void saveInstructions(java.util.ArrayList<Instruction> instructions) {

        try {
            
            String name = "";
            
            for(Instruction instruction : instructions){
                name+= instruction.getName()+", ";
            }
            
            FileManager.writer = new java.io.ObjectOutputStream(new java.io.FileOutputStream(FileManager.instructions.getPath() + ((System.getProperty("os.name").equalsIgnoreCase("linux")) ? "/" : "\\") + name + ".yuo"));

            FileManager.writer.writeObject(instructions);

            FileManager.writer.close();
            System.out.println(ComplementaryComponents.ANSI_BLUE + name + " saved" + ComplementaryComponents.RESET);
        } catch (java.io.IOException io) {
            io.printStackTrace();
            System.err.println("Error: the file could not be saved");
        }

    }
    
    public static java.util.ArrayList<Instruction> loadInstructions(String instructionsFileName){
        try {
            FileManager.reader = new java.io.ObjectInputStream(new java.io.FileInputStream(instructions.getPath() + ((System.getProperty("os.name").equalsIgnoreCase("linux")) ? "/" : "\\") +instructionsFileName));
            java.util.ArrayList<Instruction> instructions = (java.util.ArrayList<Instruction>) FileManager.reader.readObject();
            FileManager.reader.close();
            return instructions;
        } catch (java.io.IOException io) {
            io.printStackTrace();
            System.err.println("Error: The file "+instructions+" can not be load");
        }catch(ClassNotFoundException io){
            System.err.println("Error: WebPage file not found");
        }
        return null;
    }
}
