package com.example.iman.tab1;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;

import static com.example.iman.tab1.Constant.CALORY_COLUMN;
import static com.example.iman.tab1.Constant.FOODNAME_COLUMN;
import static com.example.iman.tab1.Constant.ID_COLUMN;

/**
 * Created by iman on 01/05/2017.
 */

public class FoodsCaloryActivity extends Activity {

    private ArrayList<HashMap> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.foods_calory);

        //TextView tv_foods_calory= (TextView) findViewById(R.id.tv_foods_calory);
        //tv_foods_calory.setText(GetFoodsCalory());


        ListView lvFoodsList = (ListView) findViewById(R.id.lvFoodsList);
        GetFoodsCalory();
        ListviewAdapter adapter = new ListviewAdapter(this, list);
        lvFoodsList.setAdapter(adapter);

    }

    private void GetFoodsCalory()
    {


        list = new ArrayList<>();

        HashMap temp = new HashMap();
        temp.put(ID_COLUMN,"ردیف");
        temp.put(FOODNAME_COLUMN, "نام غذا");
        temp.put(CALORY_COLUMN, "مقدار کالری");
        list.add(temp);


        SQLiteDatabase db=openOrCreateDatabase("Calories", MODE_PRIVATE, null);
        Cursor cursor=db.rawQuery("SELECT * FROM foods_calory", null);
        cursor.moveToFirst();

        int i=0;
        while (cursor.moveToNext()){
            int id=cursor.getInt(cursor.getColumnIndex("id"));
            String foodName=cursor.getString(cursor.getColumnIndex("food_name"));
            String calory=cursor.getString(cursor.getColumnIndex("calory"));


            temp = new HashMap();
            temp.put(ID_COLUMN,id+"");
            temp.put(FOODNAME_COLUMN, foodName);
            temp.put(CALORY_COLUMN, calory);
            list.add(temp);


            i++;
        }


        db.close();


    }
}
