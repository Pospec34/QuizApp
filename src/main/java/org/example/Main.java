package org.example;

import org.example.database.Database;
import org.example.menu.MainMenu;

public class Main {
    public static void main(String[] args) {
        Database database = new Database();
        MainMenu menu = new MainMenu(database);

        menu.execute();


    }
}