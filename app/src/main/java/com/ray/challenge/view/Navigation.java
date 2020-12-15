package com.ray.challenge.view;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.material.navigation.NavigationView;
import com.ray.challenge.R;

import java.util.Map;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

public class Navigation extends Activity {
    public DrawerLayout drawerLayout;
    public ListView drawerList;
    public String[] layers;
    private ActionBarDrawerToggle drawerToggle;
    private Map map;
    private Toolbar toolbar;

    protected void onCreate(Bundle savedInstanceState) {
        // R.id.drawer_layout should be in every activity with exactly the same id.
        super.onCreate(savedInstanceState);
        drawerLayout = findViewById(R.id.drawer_layout);
        toolbar = findViewById(R.id.include);
        drawerToggle = new ActionBarDrawerToggle((Activity) this, drawerLayout, toolbar, 0, 0) {
            public void onDrawerClosed(View view) {
                getActionBar().setTitle(R.string.app_name);
            }

            public void onDrawerOpened(View drawerView) {
                getActionBar().setTitle(R.string.menu);
            }
        };
        drawerLayout.addDrawerListener(drawerToggle);

        getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setHomeButtonEnabled(true);

        drawerList.addFooterView(footerView);

        drawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int pos, long arg3) {
                map.drawerClickEvent(pos);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (drawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);

    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        drawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        drawerToggle.onConfigurationChanged(newConfig);
    }
//    Context context;
//    NavigationView NavView;
//    public DrawerLayout drawerLayout;
//    private Toolbar toolbar;
//    public String[] layers;
//    private ActionBarDrawerToggle drawerToggle;
//    protected void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        drawerLayout =  findViewById(R.id.nav_view);
//        toolbar = findViewById(R.id.include);
//        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout ,R.string.navigation_drawer_open, R.string.navigation_drawer_close){
//            public void onDrawerClosed(View view) {
//                getActionBar().setTitle(R.string.app_name);
//            }
//
//            public void onDrawerOpened(View drawerView) {
//                getActionBar().setTitle(R.string.menu);
//            }
//        };
//        drawerLayout.addDrawerListener(drawerToggle);
//        getActionBar().setDisplayHomeAsUpEnabled(true);
//        getActionBar().setHomeButtonEnabled(true);
//
//        layers = getResources().getStringArray(R.array.layers_array);
//
//        drawerToggle.syncState();
//    }

    //    public Navigation (Context context1, NavigationView navView1){
//        this.context = context1;
//        this.NavView = navView1;
//    }
    //NavView
//    NavigationView navigationView = findViewById(R.id.nav_view);
//        navigationView.setNavigationItemSelectedListener(this);
//    ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
//            R.string.navigation_drawer_open, R.string.navigation_drawer_close);
//        drawer.addDrawerListener(toggle);
//        toggle.syncState();
}
