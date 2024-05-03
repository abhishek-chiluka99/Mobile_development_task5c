package com.example.myyoutube_player;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MyDatabaseHelper extends SQLiteOpenHelper {

    Context context;
    private static  final String DATABASE_NAME = "Youtube_data1.db";

    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "my_playlist";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_NAME = "my_username";
    private static final String COLUMN_PASSWORD = "my_password";

    private static  final String COLUMN_PLAY = "my_playlist";
    public MyDatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME +
                "(" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_NAME + " TEXT, " +
                COLUMN_PASSWORD + " TEXT, " +
                COLUMN_PLAY + " TEXT );";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);

    }

    void addlist(String username, String password, String playlist){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_NAME, username);
        cv.put(COLUMN_PASSWORD, password);
        cv.put(COLUMN_PLAY, playlist);
        long result = db.insert(TABLE_NAME, null,cv);
        if(result == -1){
            Toast.makeText(context,"Failed", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(context,"Added Successfully", Toast.LENGTH_SHORT).show();
        }
    }


    Cursor readalldata(){
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if(db != null){
            cursor = db.rawQuery("select * from my_playlist " ,null);
        }

        return cursor;
    }

    Cursor readAllDataPlaylist(String username){


        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if(db != null){
            cursor = db.rawQuery("select * from my_playlist where my_username LIKE " + "\'" +  username + "\'" + " Order by my_playlist ASC" ,null);
        }

        return cursor;
    }


}
