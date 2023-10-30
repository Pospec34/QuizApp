package org.example.models;

import org.example.Database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class QuizCategories {
    private Database database;

    public QuizCategories(Database database){
        this.database = database;
    }

    public String[] getQuizCategories(){
        String sql = "SELECT category_name FROM categories";
        List<String> categoriesList = new ArrayList<>();

        try (PreparedStatement preparedStatement = database.getConnection().prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()){
            while (resultSet.next()){
                String category = resultSet.getString("category_name");
                categoriesList.add(category);
            }
        } catch (SQLException e){
            e.printStackTrace();
            System.out.println("Chyba při výpisu kategorií");
        }
        return categoriesList.toArray(new String[0]);

    }
}
