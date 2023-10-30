package org.example.views;

import org.example.Database;
import org.example.Quiz;
import org.example.models.QuizSubCategories;

import java.util.Scanner;

public class SubCategoriesInterface {
    Scanner scanner = new Scanner(System.in);
    Database database;
    QuizSubCategories quizSubCategories;


    public SubCategoriesInterface(Database database){
        this.database = database;
        this.quizSubCategories= new QuizSubCategories(database);
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
                Quiz quiz = new Quiz();
                quiz.startQuiz(selection);

            }
        }

    }
}
