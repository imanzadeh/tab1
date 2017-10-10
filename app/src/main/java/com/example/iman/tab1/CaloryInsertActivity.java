package com.example.iman.tab1;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by iman on 01/05/2017.
 */

public class CaloryInsertActivity extends Activity {

    EditText etFoodName=null;
    EditText etCalory=null;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calory_insert);
    }

    public void btn_inset_onclick(View view) {
        Toast.makeText(getApplicationContext(), "1", Toast.LENGTH_SHORT).show();

        SQLiteDatabase database = openOrCreateDatabase("Calories", MODE_PRIVATE, null);

        Toast.makeText(getApplicationContext(), "1", Toast.LENGTH_SHORT).show();

        database.execSQL("CREATE TABLE IF NOT EXISTS foods_calory(" +
                "id INTEGER primary key AUTOINCREMENT," +
                "food_name VARCHAR(50)," +
                "calory DOUBLE)");
        Toast.makeText(getApplicationContext(), "1", Toast.LENGTH_SHORT).show();

        etFoodName = (EditText) findViewById(R.id.et_food_name);
        etCalory = (EditText) findViewById(R.id.et_food_calory);
        String foodName = etFoodName.getText().toString();
        String calory = etCalory.getText().toString();
        database.execSQL("INSERT INTO foods_calory (food_name,calory) " +
                "VALUES ('" + foodName + "'," + calory + ")");

        Toast.makeText(getApplicationContext(), "1", Toast.LENGTH_SHORT).show();

        database.close();

        Toast.makeText(getApplicationContext(), "Inserted", Toast.LENGTH_LONG).show();


    }
}
