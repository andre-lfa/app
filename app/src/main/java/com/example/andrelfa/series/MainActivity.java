package com.example.andrelfa.series;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;

import com.example.andrelfa.series.adapters.AdapterSerie;

public class MainActivity extends AppCompatActivity {

    protected void Toolbar () {
        Toolbar toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        toolbar.setTitle("NERVERMORE");
        toolbar.setSubtitle("Serialize-se!");
        toolbar.setLogo(R.mipmap.ic_launcher);
    }

    private void recyclerView(){
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rvSerie);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerView.setAdapter(new AdapterSerie());


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar();
        recyclerView();

        //Intent myIntent = new Intent(view.getContext(), SerieActivity.class);
        //startActivityForResult(myIntent, 0);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //getMenuInflater().inflate();
        return super.onCreateOptionsMenu(menu);
    }
}
