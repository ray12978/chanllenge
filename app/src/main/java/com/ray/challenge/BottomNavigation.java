package com.ray.challenge;

import android.content.Context;
import android.content.Intent;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public final class BottomNavigation {
    Context context;
    public BottomNavigation(Context context){
        this.context = context;
    }
    private void BottomNavi_init(){
        BottomNavigationView bottomNavigationView
                = (BottomNavigationView) findViewById(R.id.include2);

        bottomNavigationView.getMenu().getItem(0).setChecked(true);

        bottomNavigationView.setOnNavigationItemSelectedListener((item) -> {
            switch (item.getItemId()) {
                case R.id.nav1:
                    Intent intent = new Intent(context,MainActivity.class);
                    context.startActivity(intent);
                    break;
                case R.id.nav2:
                    Intent intent2 = new Intent(context, PageTwo.class);
                    context.startActivity(intent2);
                    break;
            }
            return true;
        });
    }
}
