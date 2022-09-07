package com.example.lottieanimation;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import com.airbnb.lottie.LottieAnimationView;

public class MainActivity extends AppCompatActivity {

    LottieAnimationView laView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        laView.setAnimation(R.raw.handsjoystick);
//        laView.playAnimation();
//        laView.loop(true);
    }
}