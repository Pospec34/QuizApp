package org.example.selectData;

import org.example.database.Database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SubCategoryIdFinder {
    private Database database;

    public SubCategoryIdFinder(Database database){
        this.database = database;
    }

    public int getSubGategoryId(String selectedSubCategory){
        String subCategoryUpdated = selectedSubCategory.replaceAll("^\\d+ - ", "");     // Used to get rid of selection numbers in front of sub category names
        String sql = "SELECT sub_category_id FROM sub_categories WHERE sub_category_name = ?";
        try (PreparedStatement preparedStatement = database.getConnection().prepareStatement(sql)) {
            preparedStatement.setString(1, subCategoryUpdated);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt("sub_category_id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Chyba při hledání sub_category_id");
        }
        return -1;
    }
}
