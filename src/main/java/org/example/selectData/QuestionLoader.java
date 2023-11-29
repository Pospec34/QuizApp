package org.example.selectData;

import org.example.Question;
import org.example.database.Database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class QuestionLoader {

    public List<Question> getQuestionsFromDatabase(int categoryId, Database database){
        String sql = "SELECT * FROM questions WHERE sub_category_id = ?";
        List<Question> loadedQuestions = new ArrayList<>();

        try (PreparedStatement preparedStatement = database.getConnection().prepareStatement(sql)){
            preparedStatement.setInt(1, categoryId);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String text = resultSet.getString("text");
                String correctAnswer = resultSet.getString("correct_answer");

                List<String> wrongAnswers = new ArrayList<>();
                for (int i = 1; i <= 3; i++){
                    wrongAnswers.add(resultSet.getString("wrong_answer" + i));
                }

                Question question = new Question(text, correctAnswer, wrongAnswers);
                loadedQuestions.add(question);
            }
        } catch (SQLException e){
            e.printStackTrace();
            System.out.println("Chyba při načítání otázek z databáze");
        }

        return loadedQuestions;
    }

}
