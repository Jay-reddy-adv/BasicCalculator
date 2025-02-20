package com.example.basiccalculator;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;



public class WeelcomePage extends AppCompatActivity {

    public static int TIME_OUT = 3500;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weelcome_page);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent mainpage = new Intent(WeelcomePage.this, MainActivity.class);
                startActivity(mainpage);
                finish();

            }
        },TIME_OUT);

    }
}