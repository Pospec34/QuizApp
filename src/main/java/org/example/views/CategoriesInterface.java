package org.example.views;

import org.example.Database;
import org.example.models.QuizCategories;

import java.util.Scanner;

public class CategoriesInterface {

    Scanner scanner = new Scanner(System.in);
    Database database;
    private SubCategoriesInterface subCategoriesInterface;
    private QuizCategories quizCategories;

    public CategoriesInterface(Database database){
        this.database = database;
        this.subCategoriesInterface = new SubCategoriesInterface(database);
        this.quizCategories = new QuizCategories(database);
    }

    public void getCategories(){
        int selection = 99;

        while (selection != 0){
            System.out.println("––––––––––––––––––––––––––––");
            System.out.println("           TÉMATA           ");
            System.out.println("––––––––––––––––––––––––––––");
            String[] categories = quizCategories.getQuizCategories();

            for (String category : categories){
                System.out.println(category);
            }

            System.out.println();
            System.out.println("0 - Zpět do hlavní nabídky");

            selection = Integer.parseInt(scanner.nextLine());

            if (selection != 0){
                subCategoriesInterface.getSubCategories(selection);
            }
        }
    }
}
