package org.example.menu;

import org.example.database.Database;

import java.util.Scanner;

public class MainMenu {
    private Database database;
    private CategoriesMenu categoriesMenu;
    Scanner scanner = new Scanner(System.in);

    public MainMenu(Database database){
        this.database = database;
        this.categoriesMenu = new CategoriesMenu(database);
    }

    public void execute(){
        int selection = 99;

        while (selection != 0){
            System.out.println("––––––––––––––––––––––––––––");
            System.out.println("       HLAVNÍ NABÍDKA       ");
            System.out.println("––––––––––––––––––––––––––––");

            System.out.println("1 - Výběr témat");
            System.out.println("2 - Vlastní témata");
            System.out.println();
            System.out.println("0 - Konec");

            selection = Integer.parseInt(scanner.nextLine());
            switch(selection){
                case 1:
                    categoriesMenu.getCategories();
                    break;
            }
            System.out.println("Na shledanou!");
        }
    }
}
