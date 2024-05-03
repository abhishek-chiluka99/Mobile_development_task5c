package com.example.myyoutube_player;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Signup extends AppCompatActivity {

    EditText name, username, password, confirm_password;

    Button SignUp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        name = findViewById(R.id.Name);
        username = findViewById(R.id.usrname);
        password = findViewById(R.id.usrpassword);
        confirm_password = findViewById(R.id.usrconfirmpassword);
        SignUp = findViewById(R.id.Signup);


        SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyDatabaseHelper mydb = new MyDatabaseHelper(Signup.this);
                mydb.addlist(username.getText().toString().trim(),
                        password.getText().toString().trim(),
                        "");
            }
        });


    }
}