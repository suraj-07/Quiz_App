package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class quiz_result extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_result);

        final AppCompatButton strtNBtn=findViewById(R.id.end_btn);
        final TextView correctAns=findViewById(R.id.correctAnswer);
        final TextView incorrectAns=findViewById(R.id.incorrectAnswer);


        final int getCorrectAnswers= getIntent().getIntExtra("correct",0);
        final int getInCorrectAnswers= getIntent().getIntExtra("Incorrect",0);

        correctAns.setText((String.valueOf(getCorrectAnswers)));
        incorrectAns.setText((String.valueOf(getInCorrectAnswers)));

        strtNBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(quiz_result.this,MainActivity.class));
                finish();
            }
        });



    }
}