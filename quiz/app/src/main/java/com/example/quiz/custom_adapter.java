package com.example.quiz;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class custom_adapter  extends ArrayAdapter<view_pattern> {
    public custom_adapter(@NonNull Context context, int resource, @NonNull ArrayList<view_pattern> objects) {
        super(context, resource, objects);
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.view_pattern,parent,false);
        }

        TextView textView_num = convertView.findViewById(R.id.textview_num);
        TextView textView_username = convertView.findViewById(R.id.textview_username);
        TextView textView_mark = convertView.findViewById(R.id.textview_marks);
        textView_num.setText(getItem(position).getNum());
        textView_username.setText(getItem(position).getUsername());
        textView_mark.setText(getItem(position).getMarks());
        return convertView;
    }
}
