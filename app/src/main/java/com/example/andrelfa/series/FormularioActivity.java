package com.example.andrelfa.series;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class FormularioActivity extends AppCompatActivity {

    public static final String PREFS = "REVIEW";

    private EditText nome_review;
    private EditText novo_review;
    private SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);

        nome_review =(EditText) findViewById(R.id.nome);
        novo_review = (EditText) findViewById(R.id.descricao);

        Spinner spinner = (Spinner) findViewById(R.id.spinner_serie);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.nota_array, R.layout.support_simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        Button botaoSalvar = (Button) findViewById(R.id.botao_salvar);
        botaoSalvar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                prefs = getSharedPreferences(PREFS, 0);
                SharedPreferences.Editor editor = prefs.edit();

                String usuario = nome_review.getText().toString();
                String review = novo_review.getText().toString();

                editor.putString("NOME", usuario);
                editor.putString("REVIEW", review);
                editor.commit();

                Toast.makeText(FormularioActivity.this, "Review Salvo!", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}
