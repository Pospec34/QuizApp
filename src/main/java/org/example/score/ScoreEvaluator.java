package org.example.score;

public class ScoreEvaluator {

    public void evaluateScore(int score, int numberOfQuestions){
        System.out.println("Konec kvízu.");
        System.out.println("Skóre: " + score + "/" + numberOfQuestions);
        System.out.println("Úspěšnost: " + ((score / numberOfQuestions) * 100) + " %");
    }
}
