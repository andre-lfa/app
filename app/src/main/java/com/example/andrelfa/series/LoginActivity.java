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

    public static final String PREFS_NAME = "MyPrefsFile";

    private EditText login_usuario;
    private EditText login_senha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login_usuario = (EditText) findViewById(R.id.campo_login);
        login_senha = (EditText)findViewById(R.id.campo_senha);

        Button botao_login = (Button) findViewById(R.id.login);
        Button botao_cadastrar = (Button) findViewById(R.id.cadastrar);

        botao_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usuario = login_usuario.getText().toString();
                String senha = login_senha.getText().toString();

                SharedPreferences logins = getSharedPreferences(PREFS_NAME, 0);

                 if(usuario.equals(logins.getString("login_text_user", null))&&
                        senha.equals(logins.getString("login_text_password",null))){
                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                    finish();
                } else {
                    login_usuario.setError("Usuário inválido!");
                    login_senha.setError("Senha inválida!");
                }



            }
        });

        botao_cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String usuario = login_usuario.getText().toString();
                String senha = login_senha.getText().toString();

                if(usuario.equals("")){
                    login_usuario.setError("Digite um usuário!");
                } else if (senha.equals("")){
                    login_senha.setError("Digite uma senha!");
                } else {
                    SharedPreferences logins = getSharedPreferences(PREFS_NAME, 0);
                    SharedPreferences.Editor editor = logins.edit();

                    editor.putString("login_text_user",
                            login_usuario.getText().toString());
                    editor.putString("login_text_password",
                            login_senha.getText().toString());
                    editor.commit();
                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                    finish();
                }
            }
        });

    }
}
