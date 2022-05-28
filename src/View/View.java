package View;


/**
 *
 * @author Jes011
 * @github https://github.com/Jes011
 */
public class View {

    private Model.Manager manager;

    public View() {
        this.manager = new Model.Manager();
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
                                    java.util.ArrayList<Model.Element> ElementsList = this.manager.searchElements();
                                    if (ElementsList != null) {
                                        ViewFoundElements viewElements = new ViewFoundElements(ElementsList,this.manager.getDriver());
                                        viewElements.setVisible(true);
                                        
                                        option = this.reOption("1. Save\n2. Discard", 2);
                                        
                                        switch (option){
                                            case 1:
                                                this.manager.savePage(ElementsList);
                                                break;
                                        }
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
            }catch(java.lang.NumberFormatException io){
                System.err.println("Error: Select a valid option");
            } 
            catch (Exception io) {
                System.err.println("Error : only digits");
            }
        }
    }
}
