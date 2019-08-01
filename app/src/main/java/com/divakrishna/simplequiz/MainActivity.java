package com.divakrishna.simplequiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView tvQuestion;
    EditText etAnswer;
    Button btnValidate;

    private Quiz quiz = new Quiz();

    private int quizLength = quiz.questions.length;
    private String answer;

    Random random;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        random = new Random();

        tvQuestion = findViewById(R.id.tv_question);
        etAnswer = findViewById(R.id.et_answer);
        btnValidate = findViewById(R.id.btn_validate);
        btnValidate.setOnClickListener(this);

        NextQuiz(random.nextInt(quizLength));
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btn_validate:
                String answering = etAnswer.getText().toString();
                if(answering.equals(answer)){
                    Toast.makeText(this, "You are correct", Toast.LENGTH_SHORT).show();
                    etAnswer.getText().clear();
                    NextQuiz(random.nextInt(quizLength));
                }
                else{
                    Toast.makeText(this, "You are wrong", Toast.LENGTH_SHORT).show();
                }
        }
    }

    private void NextQuiz(int a){
        tvQuestion.setText(quiz.getQuestion(a));
        answer = quiz.getAnswer(a);
    }
}
