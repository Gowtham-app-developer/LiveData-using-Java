package com.gowtham.livedataapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private Button addScoreButton;
    private Button resetScoreButton;
    private TextView scoreTextView;

    private MainActivityViewModel mainActivityViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        scoreTextView = findViewById(R.id.tvScore);
        addScoreButton = findViewById(R.id.btnAddScore);
        resetScoreButton = findViewById(R.id.btnResetScore);

        mainActivityViewModel = ViewModelProviders.of(this).get(MainActivityViewModel.class);

        mainActivityViewModel.getScore().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(@Nullable Integer integer) {
                Log.i(TAG, "onChanged: ");
                scoreTextView.setText(String.valueOf(integer));
            }
        });


        addScoreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addScore();
            }
        });

        resetScoreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetScore();
            }
        });
    }

    public void addScore() {
        mainActivityViewModel.addScore();
    }

    public void resetScore() {
        mainActivityViewModel.resetScore();
    }

}
