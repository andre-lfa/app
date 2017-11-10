package com.example.andrelfa.series;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class FormularioActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);

        Button botaoSalvar = (Button) findViewById(R.id.botao_salvar);
        botaoSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(FormularioActivity.this, "Review Salvo!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(FormularioActivity.this, ReviewActivity.class);
                TextView nome = (TextView) findViewById(R.id.nome);
                String nome_review = "";
                nome_review = nome.getText().toString();

                Bundle bundle = new Bundle();
                bundle.putString("nome_review", nome_review);
                intent.putExtras(bundle);

                startActivity(intent);

                finish();

            }
        });
    }
}
