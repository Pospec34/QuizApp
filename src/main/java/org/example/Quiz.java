package org.example;

import org.example.models.QuestionLoader;
import org.example.models.ScoreEvaluator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Quiz {
    Scanner scanner = new Scanner(System.in);
    private Database database = new Database();
    private List<Question> questions = new ArrayList<>();
    private int score = 0;
    private int numberOfQuestions = 0;
    QuestionLoader questionLoader;
    ScoreEvaluator scoreEvaluator = new ScoreEvaluator();


    public Quiz (){
        this.questionLoader = new QuestionLoader();
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
                score++;
            } else {
                System.out.println("Špatně. Správná odpověď byla: " + question.getCorrectAnswer());
            }
        }

        scoreEvaluator.evaluateScore(score, numberOfQuestions);
    }
}
