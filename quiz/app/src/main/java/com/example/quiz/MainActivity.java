package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button button;
    EditText username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       button=findViewById(R.id.bt_start);
        username=findViewById(R.id.et_name);
        button.setOnClickListener(new View.OnClickListener() {
           @Override
            public void onClick(View v) {
                String username_typed = username.getText().toString();
                if(username_typed.equals("") ) {
                    Toast.makeText(MainActivity.this, "Please Enter Your Name", Toast.LENGTH_SHORT).show();
                }
                else {
                    Intent intent = new Intent(MainActivity.this, QuizQuestion.class);
                    startActivity(intent);
                }
            }
        });
    }
}