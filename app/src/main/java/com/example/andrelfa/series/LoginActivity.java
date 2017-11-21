package com.example.andrelfa.series;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by JuniorA02 on 11/21/2017.
 */

public class LoginActivity extends AppCompatActivity {

    private EditText login_usuario;
    private EditText login_senha;
    private Button botao_login;
    private Button botao_cadastrar;
    private SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login_usuario = (EditText) findViewById(R.id.campo_login);
        login_senha = (EditText)findViewById(R.id.campo_senha);
        botao_login = (Button)findViewById(R.id.login);
        botao_cadastrar = (Button)findViewById(R.id.cadastrar);

        prefs = getSharedPreferences("com.example.andrelfa.series", Context.MODE_PRIVATE);

        if(prefs.getString("admin", null) != null){
            login_usuario.setText(prefs.getString("admin", null));
            login_senha.requestFocus();
        }

        botao_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String usuario = login_usuario.getText().toString().trim();
                String senha = login_senha.getText().toString().trim();

                if(usuario.equalsIgnoreCase(prefs.getString("admin", null)) && senha.equals(prefs.getString("admin", null))){
                    prefs.edit().putBoolean("status", true).apply();
                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                    Toast.makeText(LoginActivity.this,"foi", Toast.LENGTH_SHORT).show();
                    finish();
                }else{
                    Toast.makeText(LoginActivity.this, "Usuário ou senha inválidos, tente novamente!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        botao_cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usuario = login_usuario.getText().toString().trim();
                String senha = login_senha.getText().toString().trim();

                prefs.edit().putString("admin", usuario).apply();
                prefs.edit().putString("admin",senha).apply();
                prefs.edit().putBoolean("status", true).apply();

                startActivity(new Intent(LoginActivity.this, MainActivity.class));
            }
        });

    }
}
