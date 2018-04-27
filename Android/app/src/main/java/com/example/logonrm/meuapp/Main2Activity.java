package com.example.logonrm.meuapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    private TextView txtNome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        txtNome = (TextView) findViewById(R.id.txt_nome);

        //Metodo getIntent consegue recuperar a primeira activity
        //Recuperando dentro da variavel nome , passando o valor da primeira activty
        String nome = getIntent().getStringExtra("nome");

        //Setando o nomee
        txtNome.setText(nome);
    }
}
