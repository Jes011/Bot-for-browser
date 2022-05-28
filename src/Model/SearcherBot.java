package Model;

/**
 *
 * @author Jes011
 * @github https://github.com/Jes011
 */
public final class SearcherBot extends Bot {

    //Search Static and dynamic
    public SearcherBot(org.openqa.selenium.WebDriver driver) {
        super(driver);
    }

    //Search Static
    public java.util.ArrayList<Element> searchPageElements() {

        System.out.println("STATIC SEARCHER\n");

        super.solicitarURL();

        System.out.println("Type the tagname of the elements you want finding \n example : div;br;table (don't use \"and\" and do not use spaces)");

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
                    System.out.println("Searching : " + java.util.Arrays.toString(elements));
                    java.util.ArrayList<Element> xpaths = new java.util.ArrayList<>();

                    java.util.ArrayList<org.openqa.selenium.WebElement> elements2 = null;

                    for (String element : elements) {
                        System.out.println("Searching : [" + element + "]");
                        elements2 = (java.util.ArrayList) super.findElements(element);

                        if (!elements2.isEmpty()) {

                            for (int i = 0; i < elements2.size(); i++) {
                                if (elements2.get(i).getSize().getWidth() != 0 & elements2.get(i).getSize().getHeight() != 0) {
                                    xpaths.add(new Element(ComplementaryComponents.generateXPATH(elements2.get(i), "")));
                                }
                            }
                        } else {
                            System.err.println("Error: any " + element + " was found");
                        }

                    }

                    if (xpaths.isEmpty()) {
                        System.err.println("Error: none of the tag names were found ");
                        return null;
                    } else {
                        return xpaths;
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
