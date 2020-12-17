package com.ray.challenge;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.ray.challenge.view.BottomNavigation;

public class PageTwo extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    protected SharedPreferences shared;
    private Button BtnCount;
    private Button BtnChPage;
    private TextView TVCounter2;
    private int cnt = 0;
    private DrawerLayout drawer;
    private Toolbar toolbar;
    private Address cntAdr2;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_two);
        toolbar = findViewById(R.id.toolbar);
        drawer = findViewById(R.id.drawer_layout_Main);
        toolbar.setTitle("Page2");
        initial();
        BottomNav_init();
        InitNav();
    }

    private void InitNav() {
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
    }

    private void BottomNav_init() {
        BottomNavigationView MyBtmNav = findViewById(R.id.Bottom_Main);
        BottomNavigation BtmNav = new BottomNavigation(this, MyBtmNav, 1);
        BtmNav.init();
    }

    void initial() {
        BtnCount = findViewById(R.id.BtnTwo);
        shared = getSharedPreferences("myVal", MODE_PRIVATE);
        cnt = shared.getInt("count2", 0);
        TVCounter2 = findViewById(R.id.counter2);
        cntAdr2 = new Address(cnt);
        TVCounter2.setText(String.valueOf(cntAdr2.IntVal));
        BtnChPage = findViewById(R.id.button2);

        BtnCount.setOnClickListener(v -> {
            addTwo();
            AllCnt();
        });

        BtnChPage.setOnClickListener(v -> {
            Intent intent = new Intent(this, PageThree.class);
            startActivity(intent);
        });
    }

    public void AllCnt() {
        int AllCnt = shared.getInt("AllC", 0);
        AllCnt++;
        shared.edit()
                .putInt("AllC", AllCnt)
                .apply();
    }

    protected void addTwo() {
        cntAdr2.IntVal++;
        TVCounter2.setText(String.valueOf(cntAdr2.IntVal));
        shared.edit().putInt("count2",cntAdr2.IntVal).apply();
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
