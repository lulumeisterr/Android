package com.example.lucas.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    TextView Resultados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Resultados = findViewById(R.id.txtResultado2);

        // Recuperando o valor do intent
        Intent it = getIntent();

        if (it != null) {
            // Verifico se há uma intenção
            Bundle extras = it.getExtras();
            if (extras != null){

                // Aqui vc poem oq deseja ser recuperado

                String recuperado = extras.getString("resultado");
                Toast.makeText(this, recuperado, Toast.LENGTH_SHORT).show();

                Resultados.setText(recuperado);
            }
        }


        }
    }


