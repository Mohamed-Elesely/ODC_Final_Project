package com.example.fnal.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ListPopupWindow;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroupOverlay;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import com.example.fnal.R;

public class Error extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_error);

        CardView layoutGet = findViewById(R.id.Card_error);
        ViewGroup.LayoutParams layoutParams = layoutGet.getLayoutParams();
        int width = layoutParams.width;

        getWindow().setLayout(width, ListPopupWindow.WRAP_CONTENT);
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.gravity = Gravity.CENTER;
        getWindow().setAttributes(params);

        ViewGroup root = (ViewGroup) getWindow().getDecorView().getRootView();
        applydim(root);

        Button btn = findViewById(R.id.please_try_again_error);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               finish();
            }
        });
        TextView textView = findViewById(R.id.back_to_hom);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Error.this,HomeScreen.class);
                startActivity(intent);
            }
        });
    }


    private static void applydim(ViewGroup parent) {
        Drawable dim = new ColorDrawable(Color.TRANSPARENT);
        dim.setBounds(0, 0, parent.getWidth(), parent.getHeight());
        dim.setAlpha(200);
        ViewGroupOverlay overlay = parent.getOverlay();
        overlay.add(dim);
    }
}
