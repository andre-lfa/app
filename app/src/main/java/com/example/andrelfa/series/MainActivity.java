package com.example.andrelfa.series;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String[] series = {"Game of Thrones", "Mr. Robot", "This is Us", "Rick and Morty", "Mr. Robot", "This is Us", "Rick and Morty", "Mr. Robot", "This is Us", "Rick and Morty", "Mr. Robot", "This is Us", "Rick and Morty", "Mr. Robot", "This is Us", "Rick and Morty"};

        ListView listaSeries = (ListView) findViewById(R.id.lista_series);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, series);
        listaSeries.setAdapter(adapter);
    }
}
