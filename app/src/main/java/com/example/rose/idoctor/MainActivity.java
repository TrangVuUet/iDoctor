package com.example.rose.idoctor;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button diagnostic = (Button) findViewById(R.id.diagnostic);
        diagnostic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //intent for explixitl layout
                Intent diagnostic_intent = new Intent(MainActivity.this, Diagnostic.class);
                startActivity(diagnostic_intent);

            }
        });


    }

}
