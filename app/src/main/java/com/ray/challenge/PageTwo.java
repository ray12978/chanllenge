package com.ray.challenge;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.ray.challenge.view.BottomNavigation;

public class PageTwo extends AppCompatActivity {
    protected SharedPreferences shared;
    private MainActivity mainActivity = new MainActivity();
    MyApplication myApp;
    private Button count;
    private TextView counter;
    private int cnt = 0;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_two);
        setTitle("Page2");
        initial();
        BottomNav_init();

    }
    private void BottomNav_init() {
        BottomNavigationView MyBtmNav = findViewById(R.id.include2);
        BottomNavigation BtmNav = new BottomNavigation(this, MyBtmNav,1);
        BtmNav.init();
    }
    void initial(){
        count = findViewById(R.id.BtnTwo);
        shared = getSharedPreferences("myVal" , MODE_PRIVATE);
        cnt =  shared.getInt("count1",0);

        count.setOnClickListener(v -> {
            cnt++;
            counter = findViewById(R.id.counter2);
            counter.setText(String.valueOf(cnt));
            mainActivity.AllCnt();
        });
    }

    protected void onResume(){
        super.onResume();
       // myApp.setCurrentActivity(this);
    }
}
