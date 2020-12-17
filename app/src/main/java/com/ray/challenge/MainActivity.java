package com.ray.challenge;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.ray.challenge.view.BottomNavigation;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    protected SharedPreferences shared;
    protected SharedPreferences First;
    protected TextView TVMainCnt;
    private int AllCnt;
    private DrawerLayout drawer;
    private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);
        drawer = findViewById(R.id.drawer_layout_Main);
        toolbar.setTitle("Page1");
        initial();
        InitNav();
        BottomNav_init();
    }

    private void BottomNav_init() {
        BottomNavigationView MyBtmNav = findViewById(R.id.Bottom_Main);
        BottomNavigation BtmNav = new BottomNavigation(this, MyBtmNav,0);
        BtmNav.init();
    }
    private void InitNav(){
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
    }
    void initial() {
        First = getSharedPreferences("first", MODE_PRIVATE);
        boolean isFirst = First.getBoolean("isFirst",true);
        if(isFirst){
            First.edit().putBoolean("isFirst",false).apply();
            Intent intent = new Intent(this,FirstPage.class);
            startActivity(intent);
        }

        shared = getSharedPreferences("myVal", MODE_PRIVATE);
        AllCnt = shared.getInt("AllC", 0);

        int count1 = shared.getInt("count1", 0);
        int count2 = shared.getInt("count2", 0);
        int count3 = shared.getInt("count3", 0);

        Address cntAdr1 = new Address(count1);
        Address cntAdr2 = new Address(count2);
        Address cntAdr3 = new Address(count3);

        TextView cnt1 = findViewById(R.id.counter1);
        TVMainCnt = findViewById(R.id.MainCounter);
        TVMainCnt.setText(String.valueOf(AllCnt));
        cnt1.setText(String.valueOf(count1));

        Button ChPage = findViewById(R.id.changeBtn);
        Button plus1 = findViewById(R.id.plus1);
        Button plus2 = findViewById(R.id.plus2);
        Button plus3 = findViewById(R.id.plus3);
        Button ClrBtn = findViewById(R.id.ClrBtn);

        ChPage.setOnClickListener(v -> {
            Intent intent = new Intent(this, PageTwo.class);
            startActivity(intent);
        });

        ClrBtn.setOnClickListener(v -> {
            shared.edit()
                    .clear()
                    .apply();
            recreate();
        });

        plus1.setOnClickListener(v -> {
            addValue(cntAdr1, cnt1);
            //count1++;
            //cnt1.setText(String.valueOf(count1));
            AllCnt();
        });

        plus2.setOnClickListener(v -> {
            addValue(cntAdr2,2);
//            count2++;
//            cnt2.setText(String.valueOf(count2));
            AllCnt();
        });

        plus3.setOnClickListener(v -> {
            addValue(cntAdr3,3);
            AllCnt();
        });
    }

    protected void addValue(@NonNull Address addr, @NonNull TextView tv) {
        addr.IntVal++;
        tv.setText(String.valueOf(addr.IntVal));
        shared.edit().putInt("count1",addr.IntVal).apply();
    }

    protected void addValue(@NonNull Address addr, int index) {
        addr.IntVal++;
        String Ind = "count" + index;
        shared.edit().putInt(Ind,addr.IntVal).apply();
    }

    public void AllCnt() {
        AllCnt++;
        shared.edit()
                .putInt("AllC", AllCnt)
                .apply();
        TVMainCnt.setText(String.valueOf(AllCnt));
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_page1:
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                break;
            case R.id.nav_page2:
                Intent intent2 = new Intent(this, PageTwo.class);
                startActivity(intent2);
                break;
            case R.id.nav_page3:
                Intent intent3 = new Intent(this, PageThree.class);
                startActivity(intent3);
                onStop();
                break;
        }
        drawer.closeDrawers();
        return true;
    }
}