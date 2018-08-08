package fiap.com.br.persistencia_1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // Stream para manipulação de arquivo ou seja realizar a leitura de arquivo para recuperar os dados

    // Inicializando os oponentes

    EditText edtUsuario;
    EditText editSenha;
    CheckBox chkManterConnectado;

    // Armazena os dados tipo formato json chave e valor

    SharedPreferences sp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtUsuario = findViewById(R.id.UserID);
        editSenha = findViewById(R.id.edtSenha);
        chkManterConnectado = findViewById(R.id.chkManterConnectado);

        // 1 Parametro o nome que quero dar
        // 2 Parametro modo de visibilidade

        sp = getSharedPreferences("login" , MODE_PRIVATE);

        // Pegando o valor connectado

        boolean conectado = sp.getBoolean("conectado",false);

        if(conectado){
            abrirDashBoard();
        }

    }


    public void login(View view){

        String usuario = edtUsuario.getText().toString();
        String senha = editSenha.getText().toString();

        if(usuario.equals("FIAP") && senha.equals("123")){

            if ( chkManterConnectado.isChecked()){

                // Verificando o valor boolean

                SharedPreferences.Editor editor = sp.edit();
                editor.putString("usuario" , usuario);
                editor.putString("senha" , senha);
                editor.putBoolean("conectado", true);

                //Salvando o valor
                editor.commit();
            }
            //Abrindo nova actv
                abrirDashBoard();
        }else{
            Toast.makeText(this,R.string.login_invalido,Toast.LENGTH_LONG).show();
        }
    }

    private void abrirDashBoard(){
        Intent it = new Intent(this , DashBoardActivity.class);
        startActivity(it);
    }
}
