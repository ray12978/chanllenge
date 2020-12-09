package com.ray.challenge;

import android.app.AppComponentFactory;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class PageThree extends AppCompatActivity {
    protected SharedPreferences shared;
    private Button count;
    private TextView counter3;
    private int cnt = 0;
    MainActivity mainActivity = new MainActivity();
    @Override
    protected void onCreate(Bundle savedInstance){
        super.onCreate(savedInstance);
        setContentView(R.layout.page_three);
        initial();
        }
    void initial(){
        count = findViewById(R.id.BtnThree);
        count.setOnClickListener(v -> {
            cnt++;
            counter3 = findViewById(R.id.counter3);
            counter3.setText(cnt);
            mainActivity.AllCnt();
        });
    }
}
