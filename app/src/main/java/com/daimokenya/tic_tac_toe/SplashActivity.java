package com.daimokenya.tic_tac_toe;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //set a new intent to open an activity
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
