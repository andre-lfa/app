package com.example.andrelfa.series;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ResourceBundle;

/**
 * Created by JuniorA02 on 11/23/2017.
 */

public class GameOfThronesActivity extends AppCompatActivity {

    private SharedPreferences sharedPreferences;

    EditText nome = (EditText) findViewById(R.id.nomeReview);
    EditText review = (EditText) findViewById(R.id.novo_review);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_of_thrones);

        SharedPreferences prefs = getSharedPreferences("com.example.andrelfa.series", MODE_PRIVATE);

        String nomelocal = prefs.getString("nome", "");
        String reviewlocal = prefs.getString("review", "");

        nome.setText(nomelocal);
        review.setText(reviewlocal);

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
