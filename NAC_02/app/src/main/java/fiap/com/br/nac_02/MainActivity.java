package fiap.com.br.nac_02;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private EditText Nnome;
    private EditText Eemail;

    // Para sabermos de qual tela esta vindo o resultado
    public static final int CONSTANTE_TELA_1 = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void nextPagina(View view){

        Intent intent = new Intent(MainActivity.this , Main2Activity.class);

       final EditText Nnome = (EditText) findViewById(R.id.editText);
       final  EditText Eemail = (EditText) findViewById(R.id.editText2);

        String x = Nnome.getText().toString();
        String y = Eemail.getText().toString();

        // Enviando parametros , onde sera carregado os nossos dados

        Bundle parametro = new Bundle();

        parametro.putString("nome_pessoa" , x);
        parametro.putString("email_pessoa" , y);

        //Carregando os parametros para qualquer lugar
        intent.putExtras(parametro);

        // Startar a actv

        startActivity(intent);

    }


}
