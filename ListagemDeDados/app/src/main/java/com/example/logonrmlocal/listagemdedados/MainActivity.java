package com.example.logonrmlocal.listagemdedados;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView lstContato;
    List<Contato> contatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Recuperei os atributos
        lstContato = findViewById(R.id.lista);

        contatos = GeradorContatos.geraContato();


        // Chamar o adapter

        ContatosAdapter adapter = new ContatosAdapter(this,contatos);
        lstContato.setAdapter(adapter);

        // Quando for clicado

        lstContato.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Contato contato = contatos.get(i);
                Toast.makeText(MainActivity.this,contato.getStatus(), Toast.LENGTH_SHORT).show();

            }
        });
    }
}

