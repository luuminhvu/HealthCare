package com.example.healthcare;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Database extends SQLiteOpenHelper {
    public Database(@Nullable Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
       String qry1 = "CREATE TABLE USERS(USERNAME TEXT,EMAIL TEXT,PASSWORD TEXT)";
         db.execSQL(qry1);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int j) {

    }
    public void Register(String username,String email,String password){
        ContentValues cv = new ContentValues();
        cv.put("USERNAME",username);
        cv.put("EMAIL",email);
        cv.put("PASSWORD",password);
        SQLiteDatabase db = getWritableDatabase();
        db.insert("USERS",null,cv);
        db.close();
    }
    public int Login(String username,String password){
        int result = 0;
        String str[] = new String[2];
        str[0] = username;
        str[1] = password;

        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM USERS WHERE USERNAME=? AND PASSWORD=?",str);
        if(c.moveToFirst()){
            result = 1;
        }
        return result;
    }
}
