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
            String[] categories = quizCategories.getQuizCategories(); // loads categories from database and adds them into an array

            for (String category : categories){
                System.out.println(category);
            }

            System.out.println();
            System.out.println("0 - Zpět do hlavní nabídky");

            String userInputStr = scanner.nextLine();


            if (validator.isInputValid(userInputStr)) {
                userInput = Integer.parseInt(userInputStr);

                if (userInput != 0){
                    subCategoriesInterface.getSubCategories(userInput);
                } else {
                    break;
                }
            } else {
                System.out.println("Zadejte pouze platnou číselnou hodnotu.");
            }


        }
    }
}
