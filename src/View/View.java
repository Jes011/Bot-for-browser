package View;

import org.openqa.selenium.By;

/**
 *
 * @author Jes011
 * @github https://github.com/Jes011
 */
public class View {

    private org.openqa.selenium.WebDriver driver;

    public View() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver/chromedriver");
        this.driver = new org.openqa.selenium.chrome.ChromeDriver();
        this.driver.manage().window().minimize();

    }

    public void printMenu() {
        System.out.println("YOU");

        byte option = 0;

        while (true) {
            option = this.reOption("1. Page\n2. Processes\n3. Exit", 3);

            switch (option) {
                case 1:
                    option = this.reOption("1.Search", 1);

                    switch (option) {
                        case 1:
                            option = this.reOption("1. Static\n2. Dynamic", 2);

                            switch (option) {
                                case 1:
                                    Model.SearcherBot bot = new Model.SearcherBot(driver);

                                    java.util.ArrayList<java.util.ArrayList<org.openqa.selenium.WebElement>> WebElementsList = bot.searchPageElements();

                                    java.util.ArrayList<java.util.ArrayList<Model.Element>> ElementsList = null;
                                    if (WebElementsList != null) {
                                        ElementsList = Model.ComplementaryComponents.webElementToElement(WebElementsList);
                                        ViewFoundElements viewElements = new ViewFoundElements(ElementsList, WebElementsList);
                                        viewElements.setVisible(true);
                                    }
                                    break;
                                case 2:
                                    System.out.println(Model.ComplementaryComponents.ANSI_BLUE + "Working on that :p\n" + Model.ComplementaryComponents.RESET);
                                    break;
                            }

                            break;
                    }
                    System.gc();
                    break;
                case 2:
                    System.gc();
                    break;
                case 3:
                    System.exit(0);
            }
        }

    }

    private byte reOption(String options, int f) {
        byte option = 0;
        System.out.println("\nMenu\n" + options);
        while (true) {
            try {
                System.out.print("\nSelect an option: ");
                option = Byte.valueOf(Model.ComplementaryComponents.read());

                if (option <= 0 || option > f) {
                    System.err.println("Error: Select a valid option");
                } else {
                    return option;
                }
            } catch (Exception io) {
                System.err.println("Error : only digits");
            }
        }
    }
}
