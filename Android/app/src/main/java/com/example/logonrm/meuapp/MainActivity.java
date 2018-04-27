package com.example.logonrm.meuapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText edtNome;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Recuperando o valor do input

        edtNome = (EditText) findViewById(R.id.editText);

        //Recuperando o valor do botao

        btn = (Button) findViewById(R.id.id_nomeBt);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this , Main2Activity.class);

                //Passando o conteudo da primeira tela para a segunda

                                               //Transformando o atributo em string
                intent.putExtra("nome" , edtNome.getText().toString());

                startActivity(intent);

            }
        });

    }
}
