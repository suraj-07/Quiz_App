package com.example.quizapp;

import java.util.ArrayList;
import java.util.List;

public class question_bank {

    private static List<QuestionsList> Quiz_number1(){
        final  List<QuestionsList> questionsLists =new ArrayList<>();

        final QuestionsList ques1 = new QuestionsList("This is dummuugy ques","option1","option2","option3","option4","option2",R.drawable.back_btn,"");
        final QuestionsList ques2 = new QuestionsList("This is dummy ques","option1","option2","option3","option4","option2",R.drawable.algo_pic,"");
        final QuestionsList ques3 = new QuestionsList("This is dummy ques","option1","option2","option3","option4","option4",R.drawable.algo_pic,"");
        final QuestionsList ques4 = new QuestionsList("This is dummy ques","option1","option2","option3","option4","option3",R.drawable.ic_launcher_background,"");
        final QuestionsList ques5 = new QuestionsList("This is dummy ques","option1","option2","option3","option4","option1",R.drawable.ic_launcher_background,"");
        final QuestionsList ques6 = new QuestionsList("This is dummy ques","option1","option2","option3","option4","option2 ",R.drawable.ic_launcher_background,"");


        questionsLists.add(ques1);
        questionsLists.add(ques2);
        questionsLists.add(ques3);
        questionsLists.add(ques4);
        questionsLists.add(ques5);
        questionsLists.add(ques6);


        return questionsLists;


    }

    public static List<QuestionsList> getQuesions(String selectTopicName){
        switch (selectTopicName)
        {
            case "quiz1":
                return Quiz_number1();

            default:
                return Quiz_number1();
        }
    }



}
