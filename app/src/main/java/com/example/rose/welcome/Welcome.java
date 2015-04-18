package com.example.rose.welcome;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rose.R;
import com.example.rose.bmi.BMIcaculator;
import com.example.rose.searchhospital.SearchHospital;

import java.util.ArrayList;

/**
 * Created by Rose on 4/16/2015.
 */
public class Welcome extends Activity {

    GridView gridView;
    ArrayList<Item> gridArray = new ArrayList<Item>();
    GridViewAdapter gridAdapter;

    @Override
     public void onCreate(Bundle savedInstanceBundle) {
        super.onCreate(savedInstanceBundle);
        setContentView(R.layout.welcome_layout);

        //set grid view item
        Bitmap searchIcon = BitmapFactory.decodeResource(this.getResources(), R.drawable.search);
        Bitmap hospitalIcon = BitmapFactory.decodeResource(this.getResources(), R.drawable.search1);
        Bitmap homeIcon = BitmapFactory.decodeResource(this.getResources(), R.drawable.home);
        Bitmap aboutUsIcon = BitmapFactory.decodeResource(this.getResources(), R.drawable.about);

        gridArray.add(new Item(searchIcon, "Search Disease"));
        gridArray.add(new Item(homeIcon,"BMI"));
        gridArray.add(new Item(homeIcon,"Game"));
        gridArray.add(new Item(hospitalIcon,"Search Hospital"));
        gridArray.add(new Item(aboutUsIcon,"About us"));
       /* gridArray.add(new Item(userIcon,"Guide"));
        gridArray.add(new Item(homeIcon,"Home"));
        gridArray.add(new Item(userIcon,"User"));
        gridArray.add(new Item(homeIcon,"Building"));
        gridArray.add(new Item(userIcon,"User"));
        gridArray.add(new Item(homeIcon,"Home"));
        gridArray.add(new Item(userIcon,"xyz"));*/

        gridView = (GridView) findViewById(R.id.gridView);
        gridAdapter = new GridViewAdapter(this, R.layout.grid_row, gridArray);
        gridView.setAdapter(gridAdapter);

        //bat su kien
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               Toast.makeText(getApplicationContext(),"Item"+position,Toast.LENGTH_LONG).show();
                switch (position) {
                    case 0:
                        Intent searchIntent = new Intent(Welcome.this, SearchHospital.class);
                        startActivity(searchIntent);
                    case 1:
                        //Toast.makeText(getApplicationContext(),"Item"+position,Toast.LENGTH_LONG).show();
                        Intent bmiIntent = new Intent(Welcome.this, BMIcaculator.class);
                        startActivity(bmiIntent);
                        break;
                    case 3:
                        Intent searchHospital = new Intent(Welcome.this, SearchHospital.class);
                        startActivity(searchHospital);
                        break;
                }
            }
        });
    }

}
