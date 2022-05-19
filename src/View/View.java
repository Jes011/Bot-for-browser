package View;


/**
 *
 * @author Jes011
 * @github https://github.com/Jes011
 */
public class View {

    private org.openqa.selenium.WebDriver driver;
    
    public View() {
        System.setProperty("webdriver.chrome.driver", "/home/joyolaa/Downloads/chromedriver");
        this.driver = new org.openqa.selenium.chrome.ChromeDriver();
        this.driver.manage().window().minimize();
    }

    public void printMenu() {
        System.out.println("YOU");

        byte option = 0;
        option = this.reOption("1. Page\n2. Processes\n3. Exit", 3);

        if (option == 1) {
            option = this.reOption("1.Search", 1);
            
            if(option==1){
                
                option = this.reOption("1. Static\n2. Dynamic", 2);
                
                ////////////////////////
                ////////////////////////
                ////////////////////////
                //HERE
                if(option==1){
                    
                    Model.SearcherBot bot = new Model.SearcherBot(driver);
                    
                    java.util.ArrayList<java.util.ArrayList<org.openqa.selenium.WebElement>> lista = bot.searchPageElements();
                    
                    if(lista!=null){
                        ViewFoundElements viewElements = new ViewFoundElements(lista);
                        viewElements.setVisible(true);
                    }
                }else if(option==2){
                    System.out.println(Model.ComplementaryComponents.ANSI_BLUE+"Working in that :p\n"+Model.ComplementaryComponents.RESET);
                }
            }
        }

    }

    private byte reOption(String options, int f) {
        byte option = 0;
        System.out.println("\nMenu\n"+options);
        while (true) {
            try {
                System.out.print("\nSelect an option: ");
                option = Byte.valueOf(Model.ComplementaryComponents.read());

                if (option<=0 || option > f) {
                    System.err.println("Error: Select a valid option");
                }else{
                    return option;
                }
            } catch (Exception io) {
                System.err.println("Error : only digits");
            }
        }
    }
}
