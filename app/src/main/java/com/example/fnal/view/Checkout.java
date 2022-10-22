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
import android.widget.ImageView;
import android.widget.Toast;

import com.example.fnal.R;

import java.util.Random;

public class Checkout extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);
        CardView layoutGet = findViewById(R.id.Card_Checkout);
        ViewGroup.LayoutParams layoutParams = layoutGet.getLayoutParams();
        int width = layoutParams.width;

        getWindow().setLayout(width, ListPopupWindow.WRAP_CONTENT);
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.gravity = Gravity.CENTER;
        getWindow().setAttributes(params);

        ViewGroup root = (ViewGroup) getWindow().getDecorView().getRootView();
        applydim(root);

        Button btn = findViewById(R.id.Place_Order);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random genrator = new Random();
                int number = genrator.nextInt(2)+1;
                Class activity = null;
                if(number == 1)
                {
                    activity = Error.class;
                }
                else if (number == 2)
                {
                    activity = OrderAccepted.class;
                }

                Intent intent = new Intent(Checkout.this,activity);
                startActivity(intent);
            }
        });

        ImageView exit = findViewById(R.id.exit_checkout);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
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