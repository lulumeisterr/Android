package com.example.logonrmlocal.myapplication;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    // Recuperar ID

    RadioGroup cor;
    RadioButton corVermelha;
    RadioButton corAzul;
    RadioButton corVerde;

    Button salvar;
    View tela;
    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        cor = findViewById(R.id.corzao);

        corVermelha = findViewById(R.id.Vermelho);
        corAzul = findViewById(R.id.Azul);
        corVerde = findViewById(R.id.Verde);


        // Id criado para mudar a cor logo quando iniciado
        tela = findViewById(R.id.view);

        // Seta primeiro a primeira isntancia do Shared
        sp = getSharedPreferences("preferencia" , MODE_PRIVATE);



        SetandoCoresAoDAR_RR();

    }

    private void SetandoCoresAoDAR_RR() {

        int cor = sp.getInt("cor" , 0);

        if(cor == 1){
            tela.setBackgroundColor(Color.RED);
        }else if(cor == 2){
            tela.setBackgroundColor(Color.GREEN);
        }else if(cor == 3){
            tela.setBackgroundColor(Color.BLUE);
        }
    }


    public void salvar(View view){

        // Basta editar o conteudo so
        SharedPreferences.Editor editor = sp.edit();

        // Recupero o valor do radiogroup
        int valorRadion = cor.getCheckedRadioButtonId();

        switch (valorRadion){

            case R.id.Vermelho:
                tela.setBackgroundColor(Color.RED);
                editor.putInt("cor", 1);
                break;

            case R.id.Azul:
                tela.setBackgroundColor(Color.BLUE);
                editor.putInt("cor",2);
                break;

            case R.id.Verde:
                tela.setBackgroundColor(Color.GREEN);
                editor.putInt("cor",2);
                break;
        }

        editor.commit();
        Toast.makeText(this, "Cor alterada", Toast.LENGTH_SHORT).show();

    }


}
