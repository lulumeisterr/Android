package com.example.logonpf.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class SegundaActivity extends AppCompatActivity {

    private Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(SegundaActivity.this , MainActivity.class);
                //Para garantir que quando voltar para a main , e voltar + um pouco , ele feche
                //o APP e nao volte para a segundaAciti
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                // Esta flag voltará para o estado inicial da tela , e finalizado tudo o'que eu tenho na minha
                //Antiga backstack e criando um novo root

                startActivity(intent);

            }
        });

        Log.d("gofc","2 - onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("gofc","2 - onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("gofc","2 - onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("gofc","2 - onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("gofc","2 - onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("gofc","2 - onDestroy");
    }
}
