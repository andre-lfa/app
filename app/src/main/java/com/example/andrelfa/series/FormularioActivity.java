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

    private EditText nome_review;
    private EditText novo_review;
    private SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);

        prefs = getSharedPreferences("com.example.andrelfa.series", Context.MODE_PRIVATE);

        nome_review = (EditText) findViewById(R.id.nome);
        novo_review = (EditText) findViewById(R.id.novo_review);

        Spinner spinner = (Spinner) findViewById(R.id.spinner_serie);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.nota_array, R.layout.support_simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        Button botaoSalvar = (Button) findViewById(R.id.botao_salvar);
        botaoSalvar.setOnClickListener(new View.OnClickListener() {

            String nome = nome_review.getText().toString();
            String review = novo_review.getText().toString();

            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = prefs.edit();
                editor.putString(getString(R.string.nome), nome);
                editor.putString(getString(R.string.review), review);
                editor.commit();
                Toast.makeText(FormularioActivity.this, "Review Salvo!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
