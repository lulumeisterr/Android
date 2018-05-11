package fiap.com.br.nac_02;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import static fiap.com.br.nac_02.Main2Activity.CONSTANTE_TELA_2;

public class Main3Activity extends AppCompatActivity {

    public static final int CONSTANTE_TELA_3 = 3;

    private Button botao1;
    private Button botao2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        // Buscando a intent
        Intent intent = getIntent();

        // Recuperando as chaves setas na minha primeira main Put
        String nomeOther = intent.getStringExtra("nome_pessoa");
        Toast.makeText(Main3Activity.this, nomeOther + " Você está na terceira tela aberta", Toast.LENGTH_SHORT).show();
    }

//    public void Fechar(View view){
//
//        //Recuperando os botao
//
//        botao1 = (Button) findViewById(R.id.idFechar);
//        botao2 = (Button) findViewById(R.id.Fechar3);
//
//        botao1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if(botao1.equals(true)){
//                    Intent i = new Intent(Main3Activity.this , Main2Activity.class);
//                    startActivity(i);
//                    finish();
//                }
//            }
//        });
//
//        botao2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if(botao2.equals(true)){
//                    Intent i = new Intent(Main3Activity.this , Main3Activity.class);
//                    startActivity(i);
//                    finish();
//                }
//            }
//        });
//
//    }
}
