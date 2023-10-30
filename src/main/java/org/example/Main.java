package org.example;

import javax.xml.crypto.Data;

public class Main {
    public static void main(String[] args) {
        Database database = new Database();
        Quiz quiz = new Quiz(database);

        quiz.startQuiz(3);

    }
}