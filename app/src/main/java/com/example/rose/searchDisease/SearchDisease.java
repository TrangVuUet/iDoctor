package com.example.rose.searchDisease;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.rose.R;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Rose on 4/16/2015.
 */
/* using google API */
public class SearchDisease extends Activity{

    private ListView lv;

    ArrayAdapter<String> adapter;

    EditText inputSearch;

    ArrayList<HashMap<String,String>> productList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.disease_layout);

        //resource
        String producuts[]= {
                "Bệnh đau đầu","Bệnh đau bụng",
                "Bệnh đau tai","Bệnh đau chân",
                "Bệnh sốt", "Bệnh tụt huyết áp"
        };

        lv = (ListView) findViewById(R.id.list_view);
        inputSearch = (EditText) findViewById(R.id.input_search);

        //adding items to listview
        adapter = new ArrayAdapter<String>(this, R.layout.list_item, R.id.product_name, producuts);
        lv.setAdapter(adapter);

        /*enabling search filter */
        inputSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                SearchDisease.this.adapter.getFilter().filter(s);//filter the words
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),"Item "+position, Toast.LENGTH_LONG).show();
            }
        });

    }
}
