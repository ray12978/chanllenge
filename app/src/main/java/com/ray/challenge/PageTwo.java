package com.ray.challenge;

import android.Manifest;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class PageTwo extends AppCompatActivity {
    protected SharedPreferences shared;
    private MainActivity mainActivity = new MainActivity();
    private Button count;
    private TextView counter;
    private int cnt = 0;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.page_two);
        initial();
    }
    void initial(){
        count = findViewById(R.id.BtnTwo);
        count.setOnClickListener(v -> {
            cnt++;
            counter = findViewById(R.id.counter2);
            counter.setText(cnt);
            mainActivity.AllCnt();
        });
    }
}
