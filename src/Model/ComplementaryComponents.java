package Model;

/**
 *
 * @author Jes011
 * @github https://github.com/Jes011
 */
public final class ComplementaryComponents {
    
    //Colors
    public static final String RESET = "\033[0m";
    public static final String ANSI_BLUE = "\u001B[34m";
    
    //Read
    private static final java.util.Scanner escaner = new java.util.Scanner(System.in);
    public final static String read(){
        return escaner.nextLine();
    }
    
}
