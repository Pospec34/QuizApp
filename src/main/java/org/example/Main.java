package org.example;

import org.example.views.CategoriesInterface;
import org.example.views.SubCategoriesInterface;

public class Main {
    public static void main(String[] args) {
        Database database = new Database();

        CategoriesInterface categoriesInterface = new CategoriesInterface(database);

        categoriesInterface.getCategories();


    }
}