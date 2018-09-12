package br.com.fiap.persistencia2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText edtNome;
    MeuDB db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtNome = findViewById(R.id.edtNome);

        //Instanciando o db
        db = new MeuDB(this);
    }

    public void salvar(View view){
        String nome = edtNome.getText().toString();

        Cliente c = new Cliente();
        c.setNome(nome);

        db.insertCliente(c);
        Toast.makeText(this,"Cliente Salvo Com Sucesso",Toast.LENGTH_SHORT).show();

        //Limpando o campo
        edtNome.setText("");
    }

    public void listar(View view){

        List<Cliente> clientes = db.getAllClientes();

        for(Cliente cliente : clientes){

            Log.d("MeuDebug",cliente.getNome());
        }

    }
}
