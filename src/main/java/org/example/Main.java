package org.example;

import org.example.views.SubCategoriesInterface;

public class Main {
    public static void main(String[] args) {
        Database database = new Database();

        SubCategoriesInterface subCategoriesInterface = new SubCategoriesInterface(database);

        subCategoriesInterface.getSubCategories(1);


    }
}