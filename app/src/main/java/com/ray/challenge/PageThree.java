package com.ray.challenge;

import android.app.AppComponentFactory;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.ray.challenge.view.BottomNavigation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

public class PageThree extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    protected SharedPreferences shared;
    private Button BtnCount;
    private TextView TVCounter3;
    private int cnt = 0;
    private DrawerLayout drawer;
    private Toolbar toolbar;
    private Address cntAdr3;
    private Button BtnChPage;

    @Override
    protected void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);
        setContentView(R.layout.page_three);
        toolbar = findViewById(R.id.toolbar);
        drawer = findViewById(R.id.drawer_layout_Main);
        toolbar.setTitle("Page3");
        initial();
        BottomNav_init();
        InitNav();
    }

    protected void onResume() {
        super.onResume();

    }

    void initial() {
        shared = getSharedPreferences("myVal", MODE_PRIVATE);
        BtnCount = findViewById(R.id.BtnThree);
        TVCounter3 = findViewById(R.id.counter3);
        cnt = shared.getInt("count3", 0);

        cntAdr3 = new Address(cnt);
        TVCounter3.setText(String.valueOf(cntAdr3.IntVal));
        BtnChPage = findViewById(R.id.button2);

        BtnCount.setOnClickListener(v -> {
            addThree();
            AllCnt();
        });

        BtnChPage.setOnClickListener(v -> {
            Intent intent = new Intent(this, MainActivity.class);
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

    protected void addThree() {
        cntAdr3.IntVal++;
        TVCounter3.setText(String.valueOf(cntAdr3.IntVal));
        shared.edit().putInt("count2",cntAdr3.IntVal).apply();
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
        BottomNavigation BtmNav = new BottomNavigation(this, MyBtmNav, 2);
        BtmNav.init();
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
