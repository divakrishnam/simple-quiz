package com.divakrishna.simplequiz;

public class Quiz {
    public String questions[] = {
            "Kamu siapa?",
            "Namamu siapa?",
            "Yang nanya siapa?"
    };

    public String answers[] = {
            "Diva",
            "Diva",
            "Diva"
    };

    public String getQuestion(int a) {
        String question = questions[a];
        return question;
    }

    public String getAnswer(int a) {
        String answer = answers[a];
        return answer;
    }
}
