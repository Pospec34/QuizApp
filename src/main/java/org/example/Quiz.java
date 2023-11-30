package org.example;

import org.example.database.Database;
import org.example.selectData.QuestionLoader;
import org.example.score.ScoreEvaluator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Quiz {
    Scanner scanner = new Scanner(System.in);
    Database database;
    private List<Question> questions = new ArrayList<>();
    private int score = 0;
    private int numberOfQuestions = 0;
    QuestionLoader questionLoader;
    ScoreEvaluator scoreEvaluator = new ScoreEvaluator();

    public Quiz (Database database){
        this.questionLoader = new QuestionLoader();
        this.database = database;
    }

    public void startQuiz(int categoryId){
        questions = questionLoader.getQuestionsFromDatabase(categoryId, database);
        Collections.shuffle(questions);         //Mixes up the questions so they are not always in the same order

        for (Question question : questions){
            System.out.println("Otázka: " + question.getText());
            List<String> answerOptions = question.getAnswerOptions();

            int correctAnswerIndex = answerOptions.indexOf(question.getCorrectAnswer()) + 1;    // Finds index of the correct answer so it can be compared with users answer

            for (int i = 0; i < answerOptions.size(); i++){
                System.out.println((i + 1) + ". " + answerOptions.get(i));
            }

            System.out.printf("Vaše odpověď (1-" + answerOptions.size() + "): ");
            int userChoice = scanner.nextInt();
            numberOfQuestions++;

            if (userChoice == correctAnswerIndex){
                System.out.println("Správně!");
                System.out.println();
                score++;
            } else {
                System.out.println("Špatně. Správná odpověď byla: " + question.getCorrectAnswer());
                System.out.println();
            }
        }

        scoreEvaluator.evaluateScore(score, numberOfQuestions);
    }
}
