package com.example.myyoutube_player;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Video_Playlist extends AppCompatActivity {



    EditText video_link;

    Button play_video, add_video, video_playlist;

    public String  muser, mpass, url_str;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_playlist);
        Intent details = getIntent();
        muser = details.getStringExtra("user");
        mpass = details.getStringExtra("pass");
        play_video = findViewById(R.id.Watch_video);
        video_link = findViewById(R.id.video_link);
        add_video = findViewById(R.id.Add_playlist);
        video_playlist = findViewById(R.id.Watch_playlist);

        play_video.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                url_str = video_link.getText().toString();
                Intent intent = new Intent(Video_Playlist.this, VideoPlayer.class);
                intent.putExtra("url", url_str);
                startActivity(intent);

            }
        });

        add_video.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                url_str = video_link.getText().toString();
                MyDatabaseHelper mydb = new MyDatabaseHelper(Video_Playlist.this);
                mydb.addlist(muser,
                        mpass,
                        url_str);
            }
        });

        video_playlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Video_Playlist.this, VideoList.class);
                intent.putExtra("username", muser);
                startActivity(intent);
            }
        });



    }
}