package com.ray.challenge;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int count1 = 0;
    protected SharedPreferences shared;
    protected TextView MainCnt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MainCnt = findViewById(R.id.MainCounter);
        shared = getSharedPreferences("myVal", MODE_PRIVATE);
        initial();
    }

    void initial() {
        TextView cnt1 = findViewById(R.id.counter1);
        Button ChPage = findViewById(R.id.button);
        Button plus1 = findViewById(R.id.plus1);
        Button plus2 = findViewById(R.id.plus2);
        Button plus3 = findViewById(R.id.plus3);
        ChPage.setOnClickListener(v -> {
            count1++;
            cnt1.setText(String.valueOf(count1));
            AllCnt();
        });

        plus1.setOnClickListener(v -> {

        });

        plus2.setOnClickListener(v -> {

        });

        plus3.setOnClickListener(v -> {

        });
    }

    protected void AllCnt() {
        int AllCnt = shared.getInt("AllC", 0);
        AllCnt++;
        shared.edit()
                .putInt("AllC", AllCnt)
                .apply();
        MainCnt.setText(AllCnt);
    }
}