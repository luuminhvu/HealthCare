package com.example.healthcare;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class Database extends SQLiteOpenHelper {
    public Database(@Nullable Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String qry1 = "CREATE TABLE USERS(USERNAME TEXT,EMAIL TEXT,PASSWORD TEXT)";
        db.execSQL(qry1);
        String qry2 = "CREATE TABLE CART(USERNAME TEXT,PRODUCT TEXT,PRICE FLOAT,OTYPE TEXT)";
        db.execSQL(qry2);
        String qry3 = "CREATE TABLE ORDERPLACE(USERNAME TEXT,FULLNAME TEXT,ADDRESS TEXT,CONTACTNO TEXT,PINCODE INT,DATE TEXT,TIME TEXT,AMOUNT FLOAT,OTYPE TEXT)";
        db.execSQL(qry3);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int j) {

    }

    public void Register(String username, String email, String password) {
        ContentValues cv = new ContentValues();
        cv.put("USERNAME", username);
        cv.put("EMAIL", email);
        cv.put("PASSWORD", password);
        SQLiteDatabase db = getWritableDatabase();
        db.insert("USERS", null, cv);
        db.close();
    }

    public int Login(String username, String password) {
        int result = 0;
        String str[] = new String[2];
        str[0] = username;
        str[1] = password;

        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM USERS WHERE USERNAME=? AND PASSWORD=?", str);
        if (c.moveToFirst()) {
            result = 1;
        }
        return result;
    }

    public void addCart(String username, String product, float price, String otype) {
        ContentValues cv = new ContentValues();
        cv.put("USERNAME", username);
        cv.put("PRODUCT", product);
        cv.put("PRICE", price);
        cv.put("OTYPE", otype);
        SQLiteDatabase db = getWritableDatabase();
        db.insert("CART", null, cv);
        db.close();
    }

    public int checkCart(String username, String product) {
        int result = 0;
        String str[] = new String[2];
        str[0] = username;
        str[1] = product;
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM CART WHERE USERNAME=? AND PRODUCT=?", str);
        if (c.moveToFirst()) {
            result = 1;
        }
        db.close();
        return result;
    }

    public void removeCart(String username, String otype) {
        String str[] = new String[2];
        str[0] = username;
        str[1] = otype;
        SQLiteDatabase db = getWritableDatabase();
        db.delete("CART", "USERNAME=? AND OTYPE=?", str);
        db.close();
    }

    public ArrayList getCartData(String username, String otype) {
        ArrayList<String> arr = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        String str[] = new String[2];
        str[0] = username;
        str[1] = otype;
        Cursor c = db.rawQuery("SELECT * FROM CART WHERE USERNAME=? AND OTYPE=?", str);
        if (c.moveToFirst()) {
            do {
                String product = c.getString(1);
                String price = c.getString(2);
                arr.add(product + "$" + price);
            } while (c.moveToNext());
        }
        db.close();
        return arr;
    }

    public void addOrder(String username, String fullname, String address, String contact, int pincode, String date, String time, float amount, String otype) {
        ContentValues cv = new ContentValues();
        cv.put("USERNAME", username);
        cv.put("FULLNAME", fullname);
        cv.put("ADDRESS", address);
        cv.put("CONTACTNO", contact);
        cv.put("PINCODE", pincode);
        cv.put("DATE", date);
        cv.put("TIME", time);
        cv.put("AMOUNT", amount);
        cv.put("OTYPE", otype);
        SQLiteDatabase db = getWritableDatabase();
        db.insert("ORDERPLACE", null, cv);
        db.close();
    }
    public ArrayList getOrderData(String username){
        ArrayList<String> arr = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        String str[] = new String[1];
        str[0] = username;
        Cursor c = db.rawQuery("SELECT * FROM ORDERPLACE WHERE USERNAME=?",str);
        if(c.moveToFirst()){
            do{
                String fullname = c.getString(1);
                String address = c.getString(2);
                String contact = c.getString(3);
                String pincode = c.getString(4);
                String date = c.getString(5);
                String time = c.getString(6);
                String amount = c.getString(7);
                String otype = c.getString(8);
                arr.add(fullname+"$"+address+"$"+contact+"$"+pincode+"$"+date+"$"+time+"$"+amount+"$"+otype);
            }while(c.moveToNext());
        }
        db.close();
        return arr;
    }
    public int checkAppointmentsExist(String username,String fullname, String address, String contact, String date, String time){
        int result = 0;
        String str[] = new String[6];
        str[0] = username;
        str[1] = fullname;
        str[2] = address;
        str[3] = contact;
        str[4] = date;
        str[5] = time;
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM ORDERPLACE WHERE USERNAME=? AND FULLNAME=? AND ADDRESS=? AND CONTACTNO=? AND DATE=? AND TIME=?",str);
        if(c.moveToFirst()){
            result = 1;
        }
        db.close();
        return result;
    }
}