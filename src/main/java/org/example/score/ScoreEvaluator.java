package org.example.score;

public class ScoreEvaluator {

    public void evaluateScore(double score, int numberOfQuestions){
        System.out.println("Konec kvízu.");
        System.out.println("Skóre: " + (int)score + "/" + numberOfQuestions);
        System.out.println("Úspěšnost: " + ((score / numberOfQuestions) * 100) + " %");
    }
}
