
package Controller;

import Model.FileManager;


/**
 *
 * @author Jes011
 * @github https://github.com/Jes011
 */
public class main {

    
    public static void main(String[] args){
        
        FileManager.mkdirs();
        
        System.out.println(System.getProperty("os.name"));
        View.View aa = new View.View();
       
        aa.printMenu();
    }
}
