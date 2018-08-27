package com.example.lucas.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // Recuperar os IDS a serem utilizados

    // Validar radions

    RadioGroup rdgProdutos;
    CheckBox Frete;
    TextView Resultado;
    EditText Medida;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Frete = findViewById(R.id.chkUltraFrete);
        Medida = findViewById(R.id.Medida);
        Resultado = findViewById(R.id.txtResultado);
        rdgProdutos = findViewById(R.id.rdgProdutos);

    }

    public void nextPagina(View view){

        // Passando a intent que queros ir

        Intent intent = new Intent(MainActivity.this , Main2Activity.class);

        Resultado = findViewById(R.id.txtResultado);
        String resultado = Resultado.getText().toString();

        // Enviando parametro para outra tela

        Bundle parametro = new Bundle();

        parametro.putString("resultado",resultado);

        //Carregando os parametro
        intent.putExtras(parametro);

        startActivity(intent);

    }

    public void calcular(View view ){

        // Variavel para armazenar os valores
        double resultado = 0;

        // Verifico se o EditText da medida esta vazio
            if(Medida.getText().toString().isEmpty()){
                Toast.makeText(this, R.string.informe_a_medida, Toast.LENGTH_SHORT).show();
                return;
            }

            // Verifico se algum check foi selecionado
           int selecionado = rdgProdutos.getCheckedRadioButtonId();

           // Convertendo txt pra double

          double medida = Double.parseDouble(Medida.getText().toString());

            switch (selecionado){
                case R.id.rdbPisoAlbaina:
                    resultado = 11.90 * medida;
                    break;

                case R.id.rdbPisoBrancoBaixoBrilho:
                    resultado = 24.90 * medida;
                    break;

                case R.id.Revestimento:
                    resultado = 16.90 * medida;
                    break;

                case R.id.rdbPisoBranco:
                    resultado = 39.90 * medida;
                    break;
            }

            // Verificando se o frete esta selecionado

        if (Frete.isChecked() ) {
            resultado *= 1.3;
        }

        Resultado.setText(String.format("R$ %.2f", resultado));

    }

    public void nextPaginas(View view){
        nextPagina(view);
    }


}
