package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button button,view;
    EditText username,password;
    Cursor quiz_cursor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=findViewById(R.id.bt_start);
        username=findViewById(R.id.et_name);
        password= findViewById(R.id.et_password);
        view = findViewById(R.id.view_history);

        Database quiz = new Database(this, "quiz.db",null,1);


        button.setOnClickListener(new View.OnClickListener() {
           @Override
            public void onClick(View v) {
               String pass=password.getText().toString();
               if(pass.equals("quiz")) {
                   String username_typed = username.getText().toString();
                   if (username_typed.equals("")) {

                       Toast.makeText(MainActivity.this, "Invalid Name", Toast.LENGTH_SHORT).show();
                   } else {
                       Intent intent = new Intent(MainActivity.this, QuizQuestion.class);
                       intent.putExtra("username", username_typed);
                       startActivity(intent);
                   }
               }
               else{
                   Toast.makeText(MainActivity.this, "Password not valid", Toast.LENGTH_SHORT).show();
               }
            }
        });

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username_typed = username.getText().toString();
                try{
                    quiz_cursor = quiz.get_user(username_typed);
                    Toast.makeText(MainActivity.this, ""+quiz_cursor.getString(0), Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, view_page.class);
                    intent.putExtra("username",username_typed);
                    startActivity(intent);
                }catch (Exception e){
                    Toast.makeText(MainActivity.this, "User has not taken any test", Toast.LENGTH_SHORT).show();
                }


            }
        });
    }
}