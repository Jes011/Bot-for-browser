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

    public final static String read() {
        return escaner.nextLine();
    }

    //WebElementTOElement
    public static final java.util.ArrayList<java.util.ArrayList<Element>> webElementToElement(java.util.ArrayList<java.util.ArrayList<org.openqa.selenium.WebElement>> elements) {

        java.util.ArrayList<java.util.ArrayList<Element>> FinalList = new java.util.ArrayList<>();
        java.util.ArrayList<Element> lee = null;
        for (int i = 0; i < elements.size(); i++) {
            
            lee = new java.util.ArrayList<>();
            for (org.openqa.selenium.WebElement element : elements.get(i)) {
                lee.add(new Element(element));
            }
            
            FinalList.add(lee);

        }
        return FinalList;
    }

}
