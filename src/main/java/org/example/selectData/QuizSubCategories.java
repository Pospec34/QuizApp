package org.example.selectData;


import org.example.database.Database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class QuizSubCategories {

    Database database;
    int subCategoryIndex = 0;       // Used for numbering the selection of subcategories
    public QuizSubCategories(Database database){
        this.database = database;
    }

    public String[] getQuizSubCategories(int sub_category_id){
        String sql = "SELECT sub_category_name FROM sub_categories WHERE category_id = ?";
        List<String> subCategoriesList = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = database.getConnection().prepareStatement(sql);
            preparedStatement.setInt(1, sub_category_id);
            ResultSet resultSet = preparedStatement.executeQuery();
          while(resultSet.next()){
              subCategoryIndex++;
              String category = resultSet.getString( "sub_category_name");
              subCategoriesList.add(subCategoryIndex + " - " + category);
          }
        } catch (SQLException e){
            e.printStackTrace();
            System.out.println("Chyba při výpisu kategorií");
        }
        subCategoryIndex = 0;
        return subCategoriesList.toArray(new String[0]);

    }
}
