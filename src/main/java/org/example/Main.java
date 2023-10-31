package org.example;

import org.example.views.CategoriesInterface;
import org.example.views.UserInterface;

public class Main {
    public static void main(String[] args) {
        Database database = new Database();

        UserInterface userInterface = new UserInterface(database);

        userInterface.execute();


    }
}