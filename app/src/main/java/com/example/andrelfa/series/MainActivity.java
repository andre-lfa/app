package com.example.andrelfa.series;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;

public class MainActivity extends AppCompatActivity {

    protected void Toolbar () {
        Toolbar toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        toolbar.setTitle("NERVERMORE");
        toolbar.setSubtitle("Serialize-se!");
        toolbar.setLogo(R.mipmap.ic_launcher);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar();


        //Intent myIntent = new Intent(view.getContext(), SerieActivity.class);
        //startActivityForResult(myIntent, 0);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //getMenuInflater().inflate();
        return super.onCreateOptionsMenu(menu);
    }
}
