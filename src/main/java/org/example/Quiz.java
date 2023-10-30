package org.example;

import org.example.models.LoadQuestions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Quiz {
    Scanner scanner = new Scanner(System.in);
    private Database database;
    private List<Question> questions = new ArrayList<>();
    private int score = 0;
    LoadQuestions loadQuestions = new LoadQuestions();


    public Quiz (Database database){
        this.database = database;
    }

    public void startQuiz(int categoryId){
        questions = loadQuestions.getQuestionsFromDatabase(categoryId, database);
        Collections.shuffle(questions);

        for (Question question : questions){
            System.out.println("Otázka: " + question.getText());
            List<String> answerOptions = question.getAnswerOptions();

            int correctAnswerIndex = answerOptions.indexOf(question.getCorrectAnswer()) + 1;

            for (int i = 0; i < answerOptions.size(); i++){
                System.out.println((i + 1) + ". " + answerOptions.get(i));
            }

            System.out.printf("Vaše odpověď (1-" + answerOptions.size() + "): ");
            int userChoice = scanner.nextInt();

            if (userChoice == correctAnswerIndex){
                System.out.println("Správně!");
                score++;
            } else {
                System.out.println("Špatně. Správná odpověď byla: " + question.getCorrectAnswer());
            }
        }
    }
}
