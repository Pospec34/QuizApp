package org.example.views;

import org.example.Database;
import org.example.Quiz;
import org.example.models.QuizSubCategories;
import org.example.models.SubCategoryIdFinder;

import java.util.Scanner;

public class SubCategoriesInterface {
    Scanner scanner = new Scanner(System.in);
    Database database;
    QuizSubCategories quizSubCategories;
    SubCategoryIdFinder subCategoryIdFinder;

    public SubCategoriesInterface(Database database){
        this.database = database;
        this.quizSubCategories= new QuizSubCategories(database);
        this.subCategoryIdFinder = new SubCategoryIdFinder(database);

    }

    public void getSubCategories(int categoryId){
        int selection = 99;

        while (selection != 0){
            System.out.println("––––––––––––––––––––––––––––");
            System.out.println("         PODTÉMATA          ");
            System.out.println("––––––––––––––––––––––––––––");
            String[] subCategories = quizSubCategories.getQuizSubCategories(categoryId);

            for (String subCategory : subCategories){
                System.out.println(subCategory);
            }
            System.out.println();
            System.out.println("0 - Zpět k tématům");

            selection = Integer.parseInt(scanner.nextLine());

            if (selection != 0) {
                int subCategoryId = subCategoryIdFinder.getSubGategoryId(subCategories[selection - 1]);

                Quiz quiz = new Quiz(database);
                quiz.startQuiz(subCategoryId);

            }
        }
    }
}
