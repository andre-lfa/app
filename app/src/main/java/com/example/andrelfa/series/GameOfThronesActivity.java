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
