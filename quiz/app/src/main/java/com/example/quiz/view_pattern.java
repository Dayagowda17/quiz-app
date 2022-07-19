package com.example.quiz;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.stream.Stream;

public class view_pattern extends ArrayList<view_pattern> {
    String num;
    String username;
    String marks;

    public view_pattern( String num, String username, String marks) {
        this.num = num;
        this.username = username;
        this.marks = marks;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMarks() {
        return marks;
    }

    public void setMarks(String marks) {
        this.marks = marks;
    }


}
