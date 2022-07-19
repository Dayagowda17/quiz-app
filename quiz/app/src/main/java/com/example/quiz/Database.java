package com.example.quiz;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class Database extends SQLiteOpenHelper {

    public Database(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String create_user_table = "CREATE TABLE if not exists user_table (username Text ,marks Text)";
        sqLiteDatabase.execSQL(create_user_table);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String drop = String.valueOf("DROP TABLE IF EXISTS");
        sqLiteDatabase.execSQL(drop, new String[]{"user_table"});
        onCreate(sqLiteDatabase);
    }
    public long add_marks(String username, String marks){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("username",username);
        values.put("marks",marks);
        long k = db.insert("user_table",null,values);
        db.close();
        return k;
    }

    public Cursor get_user(String username){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT username from user_table WHERE username=?",new String[]{username});
        if(cursor != null && cursor.moveToFirst()){
            Log.d("mytag",cursor.getString(0));
        }
        else{
            Log.d("mytag","Some error");
        }
        return cursor;
    }

    public ArrayList get_marks(String username){
        ArrayList score = new ArrayList();
        ArrayList scores = new ArrayList();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT marks FROM user_table WHERE username=?",new String[]{username});
        if(cursor.getCount()>0){
            int i=0;
            while (cursor.moveToNext()){
//                Log.d("mytag",""+cursor.getString(2));
                score.add(cursor.getString(0));
                scores.add(i,score);
                i++;
            }
        }
        else{
            Log.d("mytag","Some error");
        }
        db.close();
        return scores;
    }
}
