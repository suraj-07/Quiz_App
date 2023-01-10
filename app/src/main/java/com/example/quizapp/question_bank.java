package com.example.quizapp;

import java.util.ArrayList;
import java.util.List;

public class question_bank {

    private static List<QuestionsList> Quiz_number1(){
        final  List<QuestionsList> questionsLists =new ArrayList<>();

        final QuestionsList ques1 = new QuestionsList("This is dummy ques1 for quiz 1","option1","option2","option3","option4","option2",R.drawable.que1,"");
        final QuestionsList ques2 = new QuestionsList("This is dummy que2 for quiz 1","option1","option2","option3","option4","option2",R.drawable.que2,"");
        final QuestionsList ques3 = new QuestionsList("This is dummy que3 for quiz 1","option1","option2","option3","option4","option4",R.drawable.que3,"");
        final QuestionsList ques4 = new QuestionsList("This is dummy que4 for quiz 1","option1","option2","option3","option4","option3",R.drawable.que4,"");
        final QuestionsList ques5 = new QuestionsList("This is dummy que5 for quiz 1","option1","option2","option3","option4","option1",R.drawable.que5,"");
        final QuestionsList ques6 = new QuestionsList("This is dummy que6 for quiz 1","option1","option2","option3","option4","option2 ",R.drawable.que6,"");


        questionsLists.add(ques1);
        questionsLists.add(ques2);
        questionsLists.add(ques3);
        questionsLists.add(ques4);
        questionsLists.add(ques5);
        questionsLists.add(ques6);


        return questionsLists;


    }

    private static List<QuestionsList> Quiz_number2(){
        final  List<QuestionsList> questionsLists =new ArrayList<>();

        final QuestionsList ques1 = new QuestionsList("This is dummy ques1 for quiz 2","option1","option2","option3","option4","option2",R.drawable.que1,"");
        final QuestionsList ques2 = new QuestionsList("This is dummy ques2 for quiz 2","option1","option2","option3","option4","option2",R.drawable.que2,"");
        final QuestionsList ques3 = new QuestionsList("This is dummy que3 for quiz 2","option1","option2","option3","option4","option4",R.drawable.que3,"");
        final QuestionsList ques4 = new QuestionsList("This is dummy ques4 for quiz 2","option1","option2","option3","option4","option3",R.drawable.que4,"");
        final QuestionsList ques5 = new QuestionsList("This is dummy ques5 for quiz 2","option1","option2","option3","option4","option1",R.drawable.que5,"");
        final QuestionsList ques6 = new QuestionsList("This is dummy ques6 for quiz 2","option1","option2","option3","option4","option2 ",R.drawable.que6,"");


        questionsLists.add(ques1);
        questionsLists.add(ques2);
        questionsLists.add(ques3);
        questionsLists.add(ques4);
        questionsLists.add(ques5);
        questionsLists.add(ques6);


        return questionsLists;


    }

    private static List<QuestionsList> Quiz_number3(){
        final  List<QuestionsList> questionsLists =new ArrayList<>();

        final QuestionsList ques1 = new QuestionsList("This is dummy ques1 for quiz 3","option1","option2","option3","option4","option2",R.drawable.que1,"");
        final QuestionsList ques2 = new QuestionsList("This is dummy ques2 for quiz 3","option1","option2","option3","option4","option2",R.drawable.que2,"");
        final QuestionsList ques3 = new QuestionsList("This is dummy ques3 for quiz 3","option1","option2","option3","option4","option4",R.drawable.que3,"");
        final QuestionsList ques4 = new QuestionsList("This is dummy ques4 for quiz 3","option1","option2","option3","option4","option3",R.drawable.que4,"");
        final QuestionsList ques5 = new QuestionsList("This is dummy ques5 for quiz 3","option1","option2","option3","option4","option1",R.drawable.que5,"");
        final QuestionsList ques6 = new QuestionsList("This is dummy ques6 for quiz 3","option1","option2","option3","option4","option2 ",R.drawable.que6,"");


        questionsLists.add(ques1);
        questionsLists.add(ques2);
        questionsLists.add(ques3);
        questionsLists.add(ques4);
        questionsLists.add(ques5);
        questionsLists.add(ques6);


        return questionsLists;


    }

    private static List<QuestionsList> Quiz_number4(){
        final  List<QuestionsList> questionsLists =new ArrayList<>();

        final QuestionsList ques1 = new QuestionsList("This is dummy ques1 for quiz 4","option1","option2","option3","option4","option2",R.drawable.que1,"");
        final QuestionsList ques2 = new QuestionsList("This is dummy ques2 for quiz 4","option1","option2","option3","option4","option2",R.drawable.que2,"");
        final QuestionsList ques3 = new QuestionsList("This is dummy ques3 for quiz 4","option1","option2","option3","option4","option4",R.drawable.que3,"");
        final QuestionsList ques4 = new QuestionsList("This is dummy ques4 for quiz 4","option1","option2","option3","option4","option3",R.drawable.que4,"");
        final QuestionsList ques5 = new QuestionsList("This is dummy ques5 for quiz 4","option1","option2","option3","option4","option1",R.drawable.que5,"");
        final QuestionsList ques6 = new QuestionsList("This is dummy ques6 for quiz 4","option1","option2","option3","option4","option2 ",R.drawable.que6,"");


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

            case "quiz2":
                return Quiz_number2();

            case "quiz3":
                return Quiz_number3();

            case "quiz4":
                return Quiz_number4();

            default:
                return Quiz_number1();
        }
    }



}
