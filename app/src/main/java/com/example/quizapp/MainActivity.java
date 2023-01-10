package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
private  String set_quiz_name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final LinearLayout quiz1= findViewById(R.id.card1);
        final LinearLayout quiz2= findViewById(R.id.card2);
        final LinearLayout quiz3= findViewById(R.id.card3);
        final LinearLayout quiz4= findViewById(R.id.card4);


        final Button start_button= findViewById(R.id.start_quiz);


        quiz1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                set_quiz_name="quiz1";

                quiz1.setBackgroundResource(R.drawable.round_white_stroke);

                quiz2.setBackgroundResource(R.drawable.round_card);
                quiz3.setBackgroundResource(R.drawable.round_card);
                quiz4.setBackgroundResource(R.drawable.round_card);

            }
        });

        quiz2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                set_quiz_name="quiz2";

                quiz2.setBackgroundResource(R.drawable.round_white_stroke);

                quiz1.setBackgroundResource(R.drawable.round_card);
                quiz3.setBackgroundResource(R.drawable.round_card);
                quiz4.setBackgroundResource(R.drawable.round_card);

            }
        });
        quiz3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                set_quiz_name="quiz3";

                quiz3.setBackgroundResource(R.drawable.round_white_stroke);

                quiz2.setBackgroundResource(R.drawable.round_card);
                quiz1.setBackgroundResource(R.drawable.round_card);
                quiz4.setBackgroundResource(R.drawable.round_card);

            }
        });
        quiz4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                set_quiz_name="quiz4";

                quiz4.setBackgroundResource(R.drawable.round_white_stroke);

                quiz2.setBackgroundResource(R.drawable.round_card);
                quiz3.setBackgroundResource(R.drawable.round_card);
                quiz1.setBackgroundResource(R.drawable.round_card);

            }
        });


        start_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(set_quiz_name.isEmpty())
                {
                    Toast.makeText(MainActivity.this,"Please select the quiz",Toast.LENGTH_LONG).show();
                }
                else
                {
                    Intent intent =new Intent(MainActivity.this,quiz_activity.class);
                    intent.putExtra("select_quiz",set_quiz_name);
                    startActivity(intent)   ;
                }




            }
        });
    }
}