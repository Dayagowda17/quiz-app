package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class view_page extends AppCompatActivity {
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_page);
        listView = findViewById(R.id.listview);

        Database quiz = new Database(this, "quiz.db",null,1);

        String username = getIntent().getStringExtra("username");
        ArrayList<view_pattern> arrayList_display = new ArrayList<>();
        ArrayList arrayList = new ArrayList<>();
        ArrayList<view_pattern> array = new ArrayList<>();

        arrayList = quiz.get_marks(username);
        int count = arrayList.size();

                array = (ArrayList<view_pattern>) arrayList.get(0);
        for(int i=0; i<count;i++){
            arrayList_display.add(new view_pattern(""+(i+1),""+username,""+array.get(i)));

        }
        custom_adapter customadapter = new custom_adapter(this, R.layout.view_pattern,arrayList_display);
        listView.setAdapter((customadapter));
    }
}