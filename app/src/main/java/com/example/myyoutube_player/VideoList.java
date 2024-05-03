package com.example.myyoutube_player;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class VideoList extends AppCompatActivity {

    RecyclerView recyclerView;
    CustomAdapter customAdapter;
    ArrayList<String> play__list;

    MyDatabaseHelper mydb;
    String muser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_list);
        mydb = new MyDatabaseHelper(VideoList.this);
        play__list = new ArrayList<>();
        storealldata();
        Intent details = getIntent();
        muser = details.getStringExtra("user");


     recyclerView = findViewById(R.id.view1);

        Log.i("value","playlist " + play__list);
        customAdapter = new CustomAdapter(VideoList.this, this, play__list);
        recyclerView.setAdapter(customAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(VideoList.this));



    }

    void storealldata(){
        Cursor cursor = mydb.readalldata();
        if(cursor.getCount() == 0){

        }else{
            while(cursor.moveToNext()){
                play__list.add(cursor.getString(3));
                //pass_list.add(cursor.getString(2));
            }
        }

    }
    public void onRestart()
    {
        super.onRestart();
        finish();
        startActivity(getIntent());
    }
}