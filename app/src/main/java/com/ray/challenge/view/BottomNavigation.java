package com.ray.challenge.view;

import android.app.Application;
import android.content.Context;
import android.content.Intent;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.ray.challenge.MainActivity;
import com.ray.challenge.MyApplication;
import com.ray.challenge.PageThree;
import com.ray.challenge.PageTwo;
import com.ray.challenge.R;

public final class BottomNavigation {
    Context context;
    BottomNavigationView bottomNav;
    int index = 0;
    //MyApplication myApp = new MyApplication();

    public BottomNavigation(Context context,BottomNavigationView nav,int index){
        this.context = context;
        this.bottomNav = nav;
        this.index = index;
    }
    public void init(){
        bottomNav.getMenu().getItem(index).setChecked(true);

        bottomNav.setOnNavigationItemSelectedListener((item) -> {
            switch (item.getItemId()) {
                case R.id.nav1:
                    Intent intent = new Intent(context, MainActivity.class);
                    context.startActivity(intent);
                    break;
                case R.id.nav2:
                    Intent intent2 = new Intent(context, PageTwo.class);
                    context.startActivity(intent2);
                    break;
                case R.id.nav3:
                    Intent intent3 = new Intent(context, PageThree.class);
                    context.startActivity(intent3);
                    break;
            }
            return true;
        });
    }
}
