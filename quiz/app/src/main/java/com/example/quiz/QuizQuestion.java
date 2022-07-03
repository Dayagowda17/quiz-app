package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;
import java.util.Random;

public class QuizQuestion extends AppCompatActivity {
    TextView questionsTV,questionNumberTv;
    Button option1,option2,option3,option4;
    private ArrayList<QuizModal>quizModalArrayList;
    Random random;
    int currentScore=0;
    int questionAttempted=1;
    int currentPos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_question);
        questionsTV=findViewById(R.id.tv_Questions);
        questionNumberTv=findViewById(R.id.questionsAttempted1);
        option1=findViewById(R.id.bt_option1);
        option2=findViewById(R.id.bt_option2);
        option3=findViewById(R.id.bt_option3);
        option4=findViewById(R.id.bt_option4);
        quizModalArrayList=new ArrayList<>();
        random=new Random();
        getQuizQuestion(quizModalArrayList);
        currentPos=random.nextInt(quizModalArrayList.size());
        setDataToViews(currentPos);
        option1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (quizModalArrayList.get(currentPos).getAnswer().trim().toLowerCase().equals(option1.getText().toString().trim().toLowerCase())) {
                    currentScore++;
                }
                questionAttempted++;
                currentPos=random.nextInt(quizModalArrayList.size());
                setDataToViews(currentPos);
            }
        });
        option2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (quizModalArrayList.get(currentPos).getAnswer().trim().toLowerCase().equals(option2.getText().toString().trim().toLowerCase())){
                    currentScore++;
                }
                questionAttempted++;
                currentPos=random.nextInt(quizModalArrayList.size());
                setDataToViews(currentPos);
            }
        });
        option3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (quizModalArrayList.get(currentPos).getAnswer().trim().toLowerCase().equals(option3.getText().toString().trim().toLowerCase())){
                    currentScore++;
                }
                questionAttempted++;
                currentPos=random.nextInt(quizModalArrayList.size());
                setDataToViews(currentPos);
            }
        });
        option4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (quizModalArrayList.get(currentPos).getAnswer().trim().toLowerCase().equals(option4.getText().toString().trim().toLowerCase())){
                    currentScore++;
                }
                questionAttempted++;
                currentPos=random.nextInt(quizModalArrayList.size());
                setDataToViews(currentPos);
            }
        });

    }
    private void showBottomSheet(){
        TextView err;
        BottomSheetDialog bottomSheetDialog=new BottomSheetDialog(QuizQuestion.this);
        View bottomsheetView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.score,(LinearLayout)findViewById(R.id.score));
        TextView scoreTv=bottomsheetView.findViewById(R.id.yourscore);
        Button restartQuiz=bottomsheetView.findViewById(R.id.restart);
        //err = (TextView)findViewById(R.id.et_name);
      //  err.setText(" ");
        scoreTv.setText("Your Score is\n"+currentScore+"/10");

        restartQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentPos=random.nextInt(quizModalArrayList.size());
                setDataToViews(currentPos);
                questionAttempted=1;
                currentScore=0;
                bottomSheetDialog.dismiss();
                Intent intent = new Intent(QuizQuestion.this, MainActivity.class);
                startActivity(intent);
            }
        });
        bottomSheetDialog.setCancelable(false);
        bottomSheetDialog.setContentView(bottomsheetView);
        bottomSheetDialog.show();
    }

    private  void setDataToViews(int currentPos){
        questionsTV.setText("Question Attempted: "+questionAttempted+ "/10");
        if (questionAttempted==10)
        {
            showBottomSheet();
        }
        else {
            questionsTV.setText(quizModalArrayList.get(currentPos).getQuestion());
            option1.setText(quizModalArrayList.get(currentPos).getOption1());
            option2.setText(quizModalArrayList.get(currentPos).getOption2());
            option3.setText(quizModalArrayList.get(currentPos).getOption3());
            option4.setText(quizModalArrayList.get(currentPos).getOption4());
        }
    }

    private void getQuizQuestion(ArrayList<QuizModal>quizModalArrayList) {

        quizModalArrayList.add(new QuizModal("who is father of computer?","chalesbabage","ram","ravi","manuju","chalesbabage"));
        quizModalArrayList.add(new QuizModal("add 2,5","7","25","36","both","7"));
        quizModalArrayList.add(new QuizModal("what are the data types in c langugae","int","float","double","all of the above","all of the above"));
        quizModalArrayList.add(new QuizModal("Data can be stored only from one end of the stack called ____","Top","Bottom","start","End","Top"));
        quizModalArrayList.add(new QuizModal("The node is part of_____data structure","Array","LinkedList","Queue","stack","LinkedList"));
        quizModalArrayList.add(new QuizModal("Binary tree is________data Structure","Non-Linear","Primitive","none","Linear","Non-Linear"));
        quizModalArrayList.add(new QuizModal("The prefix form of(A*B)+C","A*B+C","A*(B+C)","Both A&B","none of these","A*B+C"));
        quizModalArrayList.add(new QuizModal("The aggregate functions in sql are except","sum()","max()","avg()","sort()","sort()"));
        quizModalArrayList.add(new QuizModal("Minimal super key is____?","primary key","update","auxilary","none","primary key"));
        quizModalArrayList.add(new QuizModal("The data manipulation language statement are","insert","update","select","all of the above","all of the above"));
    }
}