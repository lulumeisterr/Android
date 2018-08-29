package com.example.logonrmlocal.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // Recuperar os IDS

    EditText login;
    EditText senha;
    Button Logar;
    CheckBox ManterLog;

    // Shared

    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        login = findViewById(R.id.loginopa);
        senha = findViewById(R.id.senha);
        //Botao
        Logar = findViewById(R.id.clickBotao);
        //Check
        ManterLog = findViewById(R.id.manterConect);
        sp = getSharedPreferences("login" , MODE_PRIVATE);

        boolean conectado = sp.getBoolean("conectado",false);
        if(conectado){
            abrirDashBoard();
        }

    }


    public void AbrirBotao(View view){

        final String v_nome = login.getText().toString();
        final String v_senha = senha.getText().toString();

        if(v_nome.equalsIgnoreCase("fiap") && v_senha.equals("123456")){
            Toast.makeText(MainActivity.this, "Logado", Toast.LENGTH_LONG).show();

            if(ManterLog.isChecked()){

            SharedPreferences.Editor ed = sp.edit();

                ed.putString("usuario" , v_nome);
                ed.putString("senha" , v_senha);
                ed.putBoolean("conectado" , true);

                // Salvando o valor

                ed.commit();
            }

            abrirDashBoard();
        }else{
            Toast.makeText(MainActivity.this , "Login invalido" , Toast.LENGTH_LONG).show();
        }

    }

    private void abrirDashBoard() {
        Intent i = new Intent(MainActivity.this , Main2Activity.class);
        startActivity(i);
    }
}
