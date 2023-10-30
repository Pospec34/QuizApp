package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

    // připojení k databázi
    private static final String URL = "jdbc:mysql://localhost:3306/quiz";
    private static final String USER = "root";
    private static final String PASSWORD ="LosPospecos3044";
    private static Connection connection;


    public Database() {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Spojení s databází bylo úspěšně navázáno.");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Nepodařilo se navázat spojení s databází.");
        }
    }

    public Connection getConnection() {
        return connection;
    }
}
