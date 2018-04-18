package com.daimokenya.tic_tac_toe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.TextView;

public class ScoreBoardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.score_board_pop);
        String numberOfWins = getIntent().getStringExtra("EXTRA_SCORE_WINS");
        TextView text_wins = findViewById(R.id.txt_wins);
        text_wins.setText(numberOfWins);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int Width=dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(Width*.8),(int)(height*.5));

    }
}
