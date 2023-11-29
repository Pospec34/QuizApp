package org.example.menu;

import org.example.database.Database;
import org.example.Quiz;
import org.example.selectData.QuizSubCategories;
import org.example.selectData.SubCategoryIdFinder;
import org.example.validators.InputValidator;

import java.util.Scanner;

public class SubCategoriesMenu {
    Scanner scanner = new Scanner(System.in);
    Database database;
    InputValidator inputValidator = new InputValidator();
    QuizSubCategories quizSubCategories;
    SubCategoryIdFinder subCategoryIdFinder;

    public SubCategoriesMenu(Database database){
        this.database = database;
        this.quizSubCategories= new QuizSubCategories(database);
        this.subCategoryIdFinder = new SubCategoryIdFinder(database);

    }

    public void getSubCategories(int categoryId){
        int userInput = 99;

        while (userInput != 0){
            System.out.println("––––––––––––––––––––––––––––");
            System.out.println("         PODTÉMATA          ");
            System.out.println("––––––––––––––––––––––––––––");
            String[] subCategories = quizSubCategories.getQuizSubCategories(categoryId);

            for (String subCategory : subCategories){
                System.out.println(subCategory);
            }
            System.out.println();
            System.out.println("0 - Zpět k tématům");

            String userInputStr = scanner.nextLine();

            if (inputValidator.isInputValid(userInputStr)){
                userInput = Integer.parseInt(userInputStr);

                if (userInput != 0) {
                    int subCategoryId = subCategoryIdFinder.getSubGategoryId(subCategories[userInput - 1]);

                    Quiz quiz = new Quiz(database);
                    quiz.startQuiz(subCategoryId);
            } else {
                    break;
                }
            } else {
                System.out.println("Zadejte pouze platnou číselnou hodnotu.");
            }
        }
    }
}
