package com.example.andrelfa.series;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ResourceBundle;

import static com.example.andrelfa.series.LoginActivity.PREFS_NAME;

/**
 * Created by JuniorA02 on 11/23/2017.
 */

public class GameOfThronesActivity extends AppCompatActivity {

    public static final String PREFS = "REVIEW";
    TextView nome;
    TextView review;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_of_thrones);

        nome = (TextView) findViewById(R.id.nomeReview);
        review = (TextView) findViewById(R.id.review);

        Button botaoReview = (Button)(findViewById(R.id.novo_review));
        botaoReview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), FormularioActivity.class);
                startActivityForResult(myIntent, 0);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        SharedPreferences prefs = getSharedPreferences(PREFS, 0);

        if (prefs.getAll().size()>0){
            String nomelocal = prefs.getString("NOME", "");
            String reviewlocal = prefs.getString("REVIEW", "");
            nome.setText("NOME: " + nomelocal);
            review.setText("REVIEW: " + reviewlocal);
        }
    }
}
