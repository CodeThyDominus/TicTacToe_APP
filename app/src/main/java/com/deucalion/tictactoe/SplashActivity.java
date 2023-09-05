package com.deucalion.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.airbnb.lottie.LottieAnimationView;

public class SplashActivity extends AppCompatActivity {

    LottieAnimationView lView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        lView = findViewById(R.id.animation_lottie);

        lView.setAnimation(R.raw.animationtictactoe);
        lView.playAnimation();

        Handler handler = new Handler();

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                lView.cancelAnimation();

                Intent iMain = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(iMain);

                finish();

            }
        },4400);



    }
}