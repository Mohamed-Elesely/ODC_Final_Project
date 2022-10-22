package com.example.fnal.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fnal.R;

public class SignUP extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        EditText editText = findViewById(R.id.email_sign_up);

        TextView textView = findViewById(R.id.SignIn);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUP.this,LogIn.class);
                startActivity(intent);
            }
        });

        Button btn = findViewById(R.id.BtnSignUp);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = editText.getText().toString();
                Intent intent = new Intent(SignUP.this,LogIn.class);
                intent.putExtra("mail",email);
                startActivity(intent);
                finish();
            }
        });
    }
}