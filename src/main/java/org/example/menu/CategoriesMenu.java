package org.example.menu;

import org.example.database.Database;
import org.example.validators.InputValidator;
import org.example.selectData.QuizCategories;

import java.util.Scanner;

public class CategoriesMenu {

    Scanner scanner = new Scanner(System.in);
    InputValidator validator = new InputValidator();
    Database database;
    private SubCategoriesMenu subCategoriesInterface;
    private QuizCategories quizCategories;

    public CategoriesMenu(Database database){
        this.database = database;
        this.subCategoriesInterface = new SubCategoriesMenu(database);
        this.quizCategories = new QuizCategories(database);
    }

    public void getCategories(){
        int userInput = 99;

        while (userInput != 0){
            System.out.println("––––––––––––––––––––––––––––");
            System.out.println("           TÉMATA           ");
            System.out.println("––––––––––––––––––––––––––––");
            String[] categories = quizCategories.getQuizCategories();

            for (String category : categories){
                System.out.println(category);
            }

            System.out.println();
            System.out.println("0 - Zpět do hlavní nabídky");

            String userInputStr = scanner.nextLine();

            /**
             * Needs to be looked into more
             */
            if (validator.isInputValid(userInputStr)){    // Checks if users input is a number
                userInput = Integer.parseInt(userInputStr);
                if (userInput != 0){
                    subCategoriesInterface.getSubCategories(userInput);
                }
            } else if (userInput == 0) {
                break;
            } else {
                System.out.println("Zadejte pouze platnou číselnou hodnotu.");
            }
        }
    }
}
