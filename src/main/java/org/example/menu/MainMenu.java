package org.example.menu;

import org.example.database.Database;
import org.example.validators.InputValidator;

import java.util.Scanner;

public class MainMenu {
    private Database database;
    private CategoriesMenu categoriesMenu;
    private InputValidator inputValidator = new InputValidator();
    Scanner scanner = new Scanner(System.in);

    public MainMenu(Database database){
        this.database = database;
        this.categoriesMenu = new CategoriesMenu(database);
    }

    public void execute(){
        int userInput = -1;

        while (userInput != 0) {
            System.out.println("––––––––––––––––––––––––––––");
            System.out.println("       HLAVNÍ NABÍDKA       ");
            System.out.println("––––––––––––––––––––––––––––");

            System.out.println("1 - Výběr témat");
            System.out.println("2 - Vlastní témata");
            System.out.println();
            System.out.println("0 - Konec");


            String userInputStr = scanner.nextLine();

            if (inputValidator.isInputValid(userInputStr)) {
                userInput = Integer.parseInt(userInputStr);
                switch (userInput) {
                    case 1:
                        categoriesMenu.getCategories();
                        break;
                }
            } else {
                System.out.println("Zadejte pouze platnou číselnou hodnotu.");
            }
        }
        System.out.println("Na shledanou!");
    }
}
