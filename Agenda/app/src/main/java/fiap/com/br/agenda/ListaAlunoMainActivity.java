package fiap.com.br.agenda;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 *  Activity são telas que lista todas as tarefas daquele dia
 *
 */

public class ListaAlunoMainActivity extends AppCompatActivity {

    private Button bt_clicar;

    @Override
    protected void onCreate(Bundle savedInstanceState){

        //Recuperando o comportamento da AppCompatActivi para recuperar o comportamente que ja existe la dentro
        super.onCreate(savedInstanceState);

        //Forma de dizer de onde que esta vindo o conteudo da nossa tela
        setContentView(R.layout.activity_lista_aluno_main);
                       //R é um atalho para acessarmos arquivos em uma determinada pasta

        //Criando o vinculo da view e recuperando o ID do elemento
        ListView lista = (ListView) findViewById(R.id.lv_equipe);

        //Adicionando na coleção
        ArrayList<String> Pessoas = preencherDados();


        ArrayAdapter<String> arrayAdp = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line, Pessoas);
        lista.setAdapter(arrayAdp);
    }

    private ArrayList<String> preencherDados() {

        final ArrayList<String> dados = new ArrayList<>();

        dados.add("Lucas");
        dados.add("Wes");
        dados.add("Jaber");

        return dados;

    }
}
