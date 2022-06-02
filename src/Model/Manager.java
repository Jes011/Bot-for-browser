package Model;

/**
 *
 * @author Jes011
 * @github https://github.com/Jes011
 */
public class Manager {

    private org.openqa.selenium.WebDriver driver;
    private SearcherBot searcherBot;
    private ExecutorBot executorBot;

    public Manager() {

        FileManager.mkdirs();

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver/chromedriver");

        this.driver = new org.openqa.selenium.chrome.ChromeDriver();
        this.driver.manage().window().minimize();

        this.searcherBot = new Model.SearcherBot(driver);
        this.executorBot = new Model.ExecutorBot(driver);
    }

    public void executeInstructions(java.util.ArrayList<Instruction> instructions) {
        if (this.getListOfInstructionsName().length != 0) {
            this.executorBot.startProcesses(instructions);
        } else {
            System.err.println("Error: no instructions found");
        }
    }

    public java.util.ArrayList<Model.Instruction> makeInstructions() {

        if (this.getListOfWebPagesName().length != 0) {
            int option;
            java.util.ArrayList<Model.Instruction> instructions = new java.util.ArrayList<>();
            java.util.ArrayList<Model.Procces> processes;
            Model.WebPage page;
            Model.Procces process;
            Model.Element element;
            while (true) {

                option = Model.ComplementaryComponents.reOption("Page", "1. Add\n2. Stop", 2);

                if (option == 1) {

                    option = (byte) (Model.ComplementaryComponents.reOption(this.getListOfWebPagesName(), "Select a page:") - 1);

                    page = this.getWebPage(this.getListOfWebPagesName()[option]);

                    processes = new java.util.ArrayList<>();

                    while (true) {
                        option = Model.ComplementaryComponents.reOption("Process", "1. Add\n2. Stop", 2);

                        if (option == 1) {

                            String[] xpathElements = new String[page.getElements().size()];
                            for (int i = 0; i < page.getElements().size(); i++) {
                                xpathElements[i] = page.getElements().get(i).getXpath();
                            }

                            option = (byte) (Model.ComplementaryComponents.reOption(xpathElements, "Select an element:") - 1);

                            element = page.getElements().get(option);

                            option = Model.ComplementaryComponents.reOption("Select the type of acction", "1. Click\n2. Type", 2);

                            process = new Model.Procces((byte) option, element);

                            switch (option) {
                                case 2:
                                    System.out.print("Type content: ");
                                    process.setContent(Model.ComplementaryComponents.read());
                                    break;
                            }
                            processes.add(process);
                        } else if (option == 2) {
                            break;
                        }
                    }
                    System.out.print("Type the name of this instruction : ");

                    instructions.add(new Model.Instruction(ComplementaryComponents.read(), page, processes));

                } else if (option == 2) {
                    break;
                }

            }
            return instructions;
        } else {
            System.err.println("Error: There are not saved pages");
            return null;
        }
    }

    public java.util.ArrayList<Model.Element> searchElements() {
        return this.searcherBot.searchPageElements();
    }

    public void saveStaticPage(java.util.ArrayList<Model.Element> elements) {
        WebPage page = new WebPage(this.driver.getCurrentUrl(), WebPage.Static, elements);
        FileManager.savePage(page);

    }

    public void saveStaticProcess(java.util.ArrayList<Model.Instruction> instructions) {
        FileManager.saveInstructions(instructions);
    }

    public String[] getListOfWebPagesName() {
        return FileManager.pages.list();
    }

    public String[] getListOfInstructionsName() {
        return FileManager.instructions.list();
    }

    public java.util.ArrayList<Instruction> getInstructions(String FileName) {
        return FileManager.loadInstructions(FileName);
    }

    public WebPage getWebPage(String FileName) {
        return FileManager.loadPage(FileName);
    }

    public org.openqa.selenium.WebDriver getDriver() {
        return this.driver;
    }
}
