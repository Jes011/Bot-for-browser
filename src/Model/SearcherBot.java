package Model;

import org.openqa.selenium.WebElement;

/**
 *
 * @author Jes011
 * @github https://github.com/Jes011
 */
public final class SearcherBot extends Bot {

    public SearcherBot(org.openqa.selenium.WebDriver driver) {
        super(driver);
    }

    public java.util.ArrayList<java.util.ArrayList<WebElement>> searchPageElements() {
        System.out.println("Type the tagname of the elements you want finding \n example : div;br;table (don't use \"and\" and do not use spaces");

        String in = null;
        String[] elements = null;

        while (true) {
            System.out.print("Tag names: ");
            in = ComplementaryComponents.read().trim();

            if (in.equalsIgnoreCase("")) {
                System.err.println("Error: You must type tagnames");
            } else if (in.equalsIgnoreCase("exit")) {
                return null;
            } else {
                elements = in.split(";");
                if (this.checkTheCharactersOfElementArray(elements)) {

                    java.util.ArrayList<java.util.ArrayList<org.openqa.selenium.WebElement>> ListF = new java.util.ArrayList<>();
                    java.util.ArrayList<org.openqa.selenium.WebElement> elements2 = null;

                    for (String element : elements) {

                        elements2 = (java.util.ArrayList) super.findElements(element);

                        if (!elements2.isEmpty()) {
                            for (org.openqa.selenium.WebElement element2 : elements2) {
                                if (element2.getSize().getWidth() == 0) {
                                    elements2.remove(element2);
                                }
                            }
                            ListF.add(elements2);
                        } else {
                            System.err.println("Error: any " + element + " was found");
                        }

                    }

                    if (ListF.isEmpty()) {
                        System.err.println("Error: none of the tag names were found ");
                    } else {
                        System.out.println("Found elements : " + ListF);
                        return ListF;
                    }

                } else {
                    System.err.println("Error: You can only type letters.");
                }
            }

        }

    }

    private boolean checkTheCharactersOfElementArray(String[] elements) {
        //checking of elements
        char[] characters = null;

        for (String elemento : elements) {
            characters = elemento.toCharArray();
            for (char character : characters) {
                if (!Character.isLetter(character)) {
                    return false;
                }
            }
        }
        return true;
    }

}
