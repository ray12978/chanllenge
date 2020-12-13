package com.ray.challenge;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    protected SharedPreferences shared;
    protected TextView MainCnt;
    private int AllCnt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initial();
        BottomNavi_init();
    }
    private void BottomNavi_init(){
        BottomNavigationView bottomNavigationView
                = (BottomNavigationView) findViewById(R.id.include2);

        bottomNavigationView.getMenu().getItem(0).setChecked(true);

        bottomNavigationView.setOnNavigationItemSelectedListener((item) -> {
            switch (item.getItemId()) {
                case R.id.nav1:
                    break;
                case R.id.nav2:
                    Intent intent2 = new Intent(MainActivity.this, PageTwo.class);
                    startActivity(intent2);
                    break;
            }
            return true;
        });
    }
    void initial() {

        shared = getSharedPreferences("myVal", MODE_PRIVATE);
        AllCnt = shared.getInt("AllC", 0);

        int count1 = shared.getInt("count1", 0);
        int count2 = shared.getInt("count2", 0);
        int count3 = shared.getInt("count3", 0);

        Address cntAdr1 = new Address(count1);
        Address cntAdr2 = new Address(count2);
        Address cntAdr3 = new Address(count3);

        TextView cnt1 = findViewById(R.id.counter1);
        MainCnt = findViewById(R.id.MainCounter);
        MainCnt.setText(String.valueOf(AllCnt));

        Button ChPage = findViewById(R.id.changeBtn);
        Button plus1 = findViewById(R.id.plus1);
        Button plus2 = findViewById(R.id.plus2);
        Button plus3 = findViewById(R.id.plus3);

        ChPage.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, PageTwo.class);
            startActivity(intent);
        });

        plus1.setOnClickListener(v -> {
            addValue(cntAdr1, cnt1);
            //count1++;
            //cnt1.setText(String.valueOf(count1));
            AllCnt();
        });

        plus2.setOnClickListener(v -> {
            addValue(cntAdr2);
//            count2++;
//            cnt2.setText(String.valueOf(count2));
            AllCnt();
        });

        plus3.setOnClickListener(v -> {
            addValue(cntAdr3);
            AllCnt();
        });
    }

    protected void addValue(@NonNull Address addr,@NonNull TextView tv) {
        addr.IntVal++;
        tv.setText(String.valueOf(addr.IntVal));
    }

    protected void addValue(@NonNull Address addr) {
        addr.IntVal++;
    }
    protected void AllCnt() {

        AllCnt++;
        shared.edit()
                .putInt("AllC", AllCnt)
                .apply();
        MainCnt.setText(String.valueOf(AllCnt));
    }
}