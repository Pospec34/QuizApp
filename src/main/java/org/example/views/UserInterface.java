package org.example.views;

import org.example.Database;

import java.util.Scanner;

public class UserInterface {
    private Database database;
    private CategoriesInterface categoriesInterface;
    Scanner scanner = new Scanner(System.in);

    public UserInterface(Database database){
        this.database = database;
        this.categoriesInterface = new CategoriesInterface(database);
    }

    public void execute(){
        int selection = 99;

        while (selection != 0){
            System.out.println("––––––––––––––––––––––––––––");
            System.out.println("       HLAVNÍ NABÍDKA       ");
            System.out.println("––––––––––––––––––––––––––––");

            System.out.println("1 - Výběr témat");
            System.out.println("2 - Vlastní témata");
            System.out.println("3 - Konec");

            selection = Integer.parseInt(scanner.nextLine());
            switch(selection){
                case 1:
                    categoriesInterface.getCategories();
                    break;
            }
        }
    }
}
