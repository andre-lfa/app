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

    public int serie = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        switch (serie){
            case 1:
                setContentView(R.layout.activity_game_of_thrones);
                break;
            case 2:
                setContentView(R.layout.activity_mr_robot);
                break;
            case 3:
                setContentView(R.layout.activity_rick_and_morty);
                break;
            case 4:
                setContentView(R.layout.activity_this_is_us);
                break;
        }

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
