package org.example;

import java.util.ArrayList;

import java.util.Collections;
import java.util.List;

public class Question {

    private String text;
    private String correctAnswer;
    private List<String> wrongAnswers;

    public Question(String text, String correctAnswer, List<String> wrongAnswers){
        this.text = text;
        this.correctAnswer = correctAnswer;
        this.wrongAnswers = wrongAnswers;
    }

    /**
     *
     *
     * @return
     */
    public List<String> getAnswerOptions(){
        List<String> options = new ArrayList<>();
        options.add(correctAnswer);

        for (String wrongAnswer : wrongAnswers){
            options.add(wrongAnswer);
        }

        Collections.shuffle(options);

        return options;
    }

    public String getText() {
        return text;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public List<String> getWrongAnswers() {
        return wrongAnswers;
    }
}
