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

    //FindXpathOfAWebElement
    public static String generateXPATH(org.openqa.selenium.WebElement childElement, String current) {
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
}
