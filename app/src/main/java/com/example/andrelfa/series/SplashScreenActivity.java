package com.example.andrelfa.series;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by JuniorA02 on 10/31/2017.
 */

public class SplashScreenActivity extends AppCompatActivity {

    public static final String PREFS = "REVIEW";

    //public boolean logado = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);

        mostrarSplash();

        SharedPreferences preferences =
                getSharedPreferences("user_preferences", MODE_PRIVATE);
        if (preferences.contains("ja_abriu_app")) {
            mostrarSplash();
            //mostrarLogin();
        } else {
            adicionarPreferenceJaAbriu(preferences);
            mostrarSplash();
        }

        preferences = getSharedPreferences(PREFS, 0);

        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("REVIEW","");
        editor.putString("NOME","");
        editor.commit();
    }



    private void mostrarSplash(){

        Handler handler = new Handler();
        handler.postDelayed(new Runnable(){
            @Override
            public void run(){
                mostrarLogin();
            }
        }, 2000);
    }

    private void mostrarLogin(){
        Intent intent = new Intent(SplashScreenActivity.this, LoginActivity.class);
        startActivity(intent);
        finish();
    }

    private void adicionarPreferenceJaAbriu(SharedPreferences preferences) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean("ja_abriu_app", true);
        editor.commit();
    }
}
