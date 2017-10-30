package com.example.andrelfa.series;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


/**
 * Created by JuniorA02 on 10/30/2017.
 */

public class SerieActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_of_thrones);

        Button botaoReview = (Button)(findViewById(R.id.novo_review));
        botaoReview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), FormularioActivity.class);
                startActivityForResult(myIntent, 0);
            }
        });
    }
}
