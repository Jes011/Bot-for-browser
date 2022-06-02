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
        javax.swing.JOptionPane.showMessageDialog(null,"Do not close the browser");
    }

    public void printMenu() {
        System.out.println("YOU");

        byte option;

        while (true) {
            option = Model.ComplementaryComponents.reOption("Menu", "1. Pages\n2. Instructions\n3. Exit", 3);

            switch (option) {
                case 1:
                    option = Model.ComplementaryComponents.reOption("Menu", "1.Search", 1);

                    switch (option) {
                        case 1:
                            option = Model.ComplementaryComponents.reOption("Searchers", "1. Static\n2. Dynamic", 2);

                            switch (option) {
                                case 1:
                                    java.util.ArrayList<Model.Element> ElementsList = this.manager.searchElements();
                                    if (ElementsList != null) {
                                        ViewFoundElements viewElements = new ViewFoundElements((java.util.ArrayList) ElementsList, this.manager.getDriver());
                                        viewElements.setVisible(true);

                                        option = Model.ComplementaryComponents.reOption("Select an option", "1. Save\n2. Discard", 2);

                                        switch (option) {
                                            case 1:
                                                this.manager.saveStaticPage(ElementsList);
                                                break;
                                        }
                                        viewElements.dispose();
                                    }
                                    break;
                                case 2:
                                    System.out.println(Model.ComplementaryComponents.ANSI_BLUE + "Working on that :p\n" + Model.ComplementaryComponents.RESET);
                                    break;
                            }

                            break;
                    }
                    break;
                case 2:

                    option = Model.ComplementaryComponents.reOption("Menu", "1. Start\n2. Make", 2);

                    switch (option) {
                        case 1:
                            if (this.manager.getListOfInstructionsName().length != 0) {
                                option = (byte) (Model.ComplementaryComponents.reOption(this.manager.getListOfInstructionsName(), "Select an instruction") - 1);

                                this.manager.executeInstructions(this.manager.getInstructions(this.manager.getListOfInstructionsName()[option]));
                            } else {
                                System.err.println("Error: no instructions found");
                            }

                            break;
                        case 2:

                            java.util.ArrayList<Model.Instruction> instructiontions = this.manager.makeInstructions();

                            if (instructiontions != null) {
                                ViewFoundElements viewElements = new ViewFoundElements((java.util.ArrayList) instructiontions, this.manager.getDriver());
                                viewElements.setVisible(true);

                                option = Model.ComplementaryComponents.reOption("Select an option", "1. Save\n2. Discard", 2);
                                switch (option) {
                                    case 1:
                                        this.manager.saveStaticProcess(instructiontions);
                                        break;
                                }
                                viewElements.dispose();
                            }

                            break;
                    }
                    break;

                case 3:
                    System.exit(0);
            }
        }

    }

}
