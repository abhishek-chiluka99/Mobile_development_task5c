package com.example.myyoutube_player;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView username, password;
    Button Login, Signup;
    ArrayList<String> user_list, pass_list;
    MyDatabaseHelper mydb;

    String check_user, check_pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        username = findViewById(R.id.username);
        password = findViewById(R.id.userpass);
        Signup = findViewById(R.id.Signup);
        Login = findViewById(R.id.Login);
        mydb = new MyDatabaseHelper(MainActivity.this);
        user_list = new ArrayList<>();
        pass_list = new ArrayList<>();

        storealldata();

        Login.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                check_user = username.getText().toString();
                check_pass = password.getText().toString();
                //Toast.makeText(getApplicationContext(), "User and password " + check_pass, Toast.LENGTH_SHORT).show();


                    if(user_list.contains(check_user)){
                        if(pass_list.contains(check_pass)){
                            Toast.makeText(getApplicationContext(), "password ", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(MainActivity.this, Video_Playlist.class);
                            intent.putExtra("user",check_user);
                            intent.putExtra("pass",check_pass);
                            startActivity(intent);

                        }else{
                            Toast.makeText(getApplicationContext(), "Wrong password", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(getApplicationContext(), "Wrong username", Toast.LENGTH_SHORT).show();
                    }
            }
        });

        Signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Signup.class);
                startActivity(intent);
            }
        });

    }


    void storealldata(){
        Cursor cursor = mydb.readalldata();
        if(cursor.getCount() == 0){

        }else{
            while(cursor.moveToNext()){
                user_list.add(cursor.getString(1));
                pass_list.add(cursor.getString(2));
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