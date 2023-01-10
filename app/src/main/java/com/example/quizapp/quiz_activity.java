package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.util.Pair;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class quiz_activity extends AppCompatActivity {

    private TextView questions, question;
    public ImageView quiz_img;


    private AppCompatButton op1, op2, op3, op4, nxt_btn;
    private Timer quiz_timer;
    public int totalMin = 1, seconds = 0;

    private  List<QuestionsList> questionsLists = new ArrayList<>();

    private int currentQuestionPosition=0;

    private String selectOptionByUser="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quix_question_layout);

        final ImageView back_btn = findViewById(R.id.backbtn);
        final TextView timer = findViewById(R.id.timer);

        final TextView Select_topic = findViewById(R.id.topic_name);


        questions = findViewById(R.id.questions);
        question = findViewById(R.id.question);

        op1= findViewById(R.id.option1);
        op2= findViewById(R.id.option2);
        op3= findViewById(R.id.option3);
        op4= findViewById(R.id.option4);

        quiz_img = findViewById(R.id.quiz_ques_image);

        nxt_btn = findViewById(R.id.nxt_btn);

        final String get_topic_name = getIntent().getStringExtra("select_quiz");

        Select_topic.setText(get_topic_name);

        questionsLists= question_bank.getQuesions(get_topic_name);

        questions.setText((currentQuestionPosition+1)+"/"+questionsLists.size());
        question.setText(questionsLists.get(currentQuestionPosition).getQuestion());
        quiz_img.setImageResource(questionsLists.get(currentQuestionPosition).getQuiz_image());
        op1.setText(questionsLists.get(currentQuestionPosition).getOption1());
        op2.setText(questionsLists.get(currentQuestionPosition).getOption2());
        op3.setText(questionsLists.get(currentQuestionPosition).getOption3());
        op4.setText(questionsLists.get(currentQuestionPosition).getOption4());

        startTimer(timer);

        op1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(selectOptionByUser.isEmpty())
                {
                    selectOptionByUser=op1.getText().toString();

                    op1.setBackgroundResource(R.drawable.round_back_red);
                    op1.setTextColor(Color.WHITE);

                    revealAnswer();

                    questionsLists.get(currentQuestionPosition).setUserSelectAns(selectOptionByUser);

                }

            }
        });

        op2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(selectOptionByUser.isEmpty())
                {
                    selectOptionByUser=op2.getText().toString();

                    op2.setBackgroundResource(R.drawable.round_back_red);
                    op2.setTextColor(Color.WHITE);

                    revealAnswer();

                    questionsLists.get(currentQuestionPosition).setUserSelectAns(selectOptionByUser);

                }

            }
        });

        op3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(selectOptionByUser.isEmpty())
                {
                    selectOptionByUser=op3.getText().toString();

                    op3.setBackgroundResource(R.drawable.round_back_red);
                    op3.setTextColor(Color.WHITE);

                    revealAnswer();

                    questionsLists.get(currentQuestionPosition).setUserSelectAns(selectOptionByUser);

                }
            }
        });

        op4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(selectOptionByUser.isEmpty())
                {
                    selectOptionByUser=op4.getText().toString();

                    op4.setBackgroundResource(R.drawable.round_back_red);
                    op4.setTextColor(Color.WHITE);

                    revealAnswer();

                    questionsLists.get(currentQuestionPosition).setUserSelectAns(selectOptionByUser);

                }
            }
        });

        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                quiz_timer.purge();
                quiz_timer.cancel();

                startActivity(new Intent(quiz_activity.this,MainActivity.class));
                finish();
            }
        });


        nxt_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(selectOptionByUser.isEmpty())
                {
                   Toast.makeText(quiz_activity.this,"please Select an option",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    changeNextQuestion();
                }
            }
        });




    }

    private void  changeNextQuestion(){
        currentQuestionPosition++;

        if((currentQuestionPosition+1)==questionsLists.size()){
            nxt_btn.setText("Submit Quiz");
        }

        if(currentQuestionPosition<questionsLists.size()){

            selectOptionByUser="";

            op1.setBackgroundResource(R.drawable.round_white_stroke);
            op1.setTextColor(Color.parseColor("#1F6BB8"));

            op2.setBackgroundResource(R.drawable.round_white_stroke);
            op2.setTextColor(Color.parseColor("#1F6BB8"));

            op3.setBackgroundResource(R.drawable.round_white_stroke);
            op3.setTextColor(Color.parseColor("#1F6BB8"));

            op4.setBackgroundResource(R.drawable.round_white_stroke);
            op4.setTextColor(Color.parseColor("#1F6BB8"));

            questions.setText((currentQuestionPosition+1)+"/"+questionsLists.size());
            question.setText(questionsLists.get(currentQuestionPosition).getQuestion());
            quiz_img.setImageResource(questionsLists.get(currentQuestionPosition).getQuiz_image());
            op1.setText(questionsLists.get(currentQuestionPosition).getOption1());
            op2.setText(questionsLists.get(currentQuestionPosition).getOption2());
            op3.setText(questionsLists.get(currentQuestionPosition).getOption3());
            op4.setText(questionsLists.get(currentQuestionPosition).getOption4());




        }
        else
        {
            Intent intent = new Intent(quiz_activity.this,quiz_result.class);

            intent.putExtra("correct", getCorrectAnswer().first);
            intent.putExtra("Incorrect", getCorrectAnswer().second);
            startActivity(intent);

            finish();
        }
    }

    private void startTimer(TextView timerTextView) {
        quiz_timer = new Timer();

        quiz_timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if (seconds == 0 && totalMin == 0) {
                    quiz_timer.purge();
                    quiz_timer.cancel();

                    Toast.makeText(quiz_activity.this, "Time is over", Toast.LENGTH_LONG).show();

                    Intent intent = new Intent(quiz_activity.this, quiz_result.class);
                    intent.putExtra("correct", getCorrectAnswer().first);
                    intent.putExtra("Incorrect", getCorrectAnswer().second);
                    startActivity(intent);

                    finish();

                } else if (seconds == 0 ) {
                    totalMin=0;
                    seconds = 59;
                } else {
                    seconds--;
                }

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        String finalMinutes = String.valueOf(totalMin);
                        String finalSeconds = String.valueOf(seconds);

                        if (finalMinutes.length() == 1) {
                            finalMinutes = "0" + finalMinutes;
                        }

                        if (finalSeconds.length() == 1) {
                            finalSeconds = "0" + finalSeconds;
                        }
                        timerTextView.setText(finalMinutes + ": " + finalSeconds);


                    }
                });
            }
        }, 1000, 1000);

    }

    private Pair<Integer, Integer> getCorrectAnswer() {
        int correctAns = 0, Incorrect = 0;
        for (int i = 0; i < questionsLists.size(); i++) {
            final String getUserSelectedAns = questionsLists.get(i).getUserSelectAns();
            final String getAns = questionsLists.get(i).getAnswer();

            if (getUserSelectedAns.equals(getAns)) {
                correctAns++;
            }

            if (!getUserSelectedAns.equals(getAns)) {
                Incorrect++;
            }


        }
        return new Pair<>(correctAns, Incorrect);
    }

    @Override
    public void onBackPressed() {
        quiz_timer.purge();
        quiz_timer.cancel();

        startActivity(new Intent(quiz_activity.this,MainActivity.class));
        finish();
    }

    private void revealAnswer(){
        final String getAnswer= questionsLists.get(currentQuestionPosition).getAnswer();

        if(op1.getText().toString().equals(getAnswer))
        {
            op1.setBackgroundResource(R.drawable.round_back_green);
            op1.setTextColor(Color.WHITE);
        }
        else if(op2.getText().toString().equals(getAnswer))
        {
            op2.setBackgroundResource(R.drawable.round_back_green);
            op2.setTextColor(Color.WHITE);
        }
        else if(op3.getText().toString().equals(getAnswer))
        {
            op3.setBackgroundResource(R.drawable.round_back_green);
            op3.setTextColor(Color.WHITE);
        }
        else if(op4.getText().toString().equals(getAnswer))
        {
            op4.setBackgroundResource(R.drawable.round_back_green);
            op4.setTextColor(Color.WHITE);
        }
    }
}