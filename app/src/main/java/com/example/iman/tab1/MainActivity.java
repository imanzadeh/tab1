package com.example.iman.tab1;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;


public class MainActivity extends TabActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        TabHost tabHost=getTabHost();

        TabHost.TabSpec foodsTab=tabHost.newTabSpec("Foods");
        foodsTab.setIndicator("Foods");

        Intent intentFoods=new Intent(MainActivity.this,FoodsCaloryActivity.class);
        foodsTab.setContent(intentFoods);
        tabHost.addTab(foodsTab);

        TabHost.TabSpec activitiesTab=tabHost.newTabSpec("Activities");
        activitiesTab.setIndicator("Activities");
        Intent intentActivities=new Intent(MainActivity.this,ActivitiesCaloryActivity.class);
        activitiesTab.setContent(intentActivities);
        tabHost.addTab(activitiesTab);

        TabHost.TabSpec insertTab=tabHost.newTabSpec("Insert");
        insertTab.setIndicator("Insert");
        Intent intentInsert=new Intent(MainActivity.this,CaloryInsertActivity.class);
        insertTab.setContent(intentInsert);
        tabHost.addTab(insertTab);

    }
}
