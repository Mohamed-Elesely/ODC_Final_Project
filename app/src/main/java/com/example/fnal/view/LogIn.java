package com.example.fnal.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fnal.R;

public class LogIn extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        TextView textView = findViewById(R.id.SignUp);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LogIn.this,SignUP.class);
                startActivity(intent);
            }
        });

        EditText editText = findViewById(R.id.email_login);
        String email = getIntent().getStringExtra("mail");
        editText.setText(email);

        Button button = findViewById(R.id.signIn_login);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LogIn.this,HomeScreen.class);
                startActivity(intent);
            }
        });
    }
}