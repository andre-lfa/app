package com.example.andrelfa.series;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.*;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        String[] series = {"Game of Thrones", "Mr. Robot", "This is Us", "Rick and Morty", "Mr. Robot", "This is Us", "Rick and Morty", "Mr. Robot", "This is Us", "Rick and Morty", "Mr. Robot", "This is Us", "Rick and Morty", "Mr. Robot", "This is Us", "Rick and Morty"};

        ListView listaSeries = (ListView) findViewById(R.id.lista_series);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, series);
        listaSeries.setAdapter(adapter);

        listaSeries.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                if(position == 0){
                    Intent myIntent = new Intent(view.getContext(), SerieActivity.class);
                    startActivityForResult(myIntent, 0);
                } else if(position == 1){
                    //Intent myIntent = new Intent(view.getContext(), Html_file1.class);
                    // startActivityForResult(myIntent, 0);
                }
            }
        });
    }
}
