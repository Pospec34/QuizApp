package org.example.selectData;

import org.example.database.Database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class QuizCategories {
    private Database database;
    int categoryIndex = 0;

    public QuizCategories(Database database){
        this.database = database;
    }

    /**
     *  Gets a list of categories from database and adds an index to each category name
     * @return returns an array of indexed categories
     */
    public String[] getQuizCategories(){
        String sql = "SELECT category_name FROM categories";
        List<String> categoriesList = new ArrayList<>();

        try (PreparedStatement preparedStatement = database.getConnection().prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()){
            while (resultSet.next()){
                categoryIndex++;
                String category = resultSet.getString("category_name");
                categoriesList.add(categoryIndex + " - " + category);
            }
        } catch (SQLException e){
            e.printStackTrace();
            System.out.println("Chyba při výpisu kategorií");
        }

        categoryIndex = 0;
        return categoriesList.toArray(new String[0]);


    }
}
