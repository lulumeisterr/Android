package fiap.com.br.listaiterativa;

import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class ListaActivity extends AppCompatActivity {

    EditText et;
    Button bt;
    ListView lv;
    ArrayList<String> arraylista ;
    ArrayAdapter<String> Adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        //Recuperando os elementos das view's
        bt = (Button) findViewById(R.id.button); // Quando clicar no botao
        et = (EditText) findViewById(R.id.editText); // Recupere o conteudo desta variavel
        lv = (ListView) findViewById(R.id.lista_add); // Exibicao

        //Chamando as instancias das coleções
        arraylista = new ArrayList<String>();

        //Criando um ListViewAdapter e passando o arrayList no final
        Adapter = new ArrayAdapter<String>(ListaActivity.this , android.R.layout.simple_list_item_1, arraylista);
        lv.setAdapter(Adapter);

        //Metodo que realizará o click
        onbtClick();
    }

    public void onbtClick(){
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String result = et.getText().toString();
                arraylista.add(result);
                Adapter.notifyDataSetChanged();

                Set<String> SemRep = new HashSet<String>(arraylista);
                Iterator<String> IteradoSemRep = SemRep.iterator();
             }

//                for (int i = 0; i < arraylista.size(); i++){
//
//                        if(arraylista.contains(result)) {
//                            Toast.makeText(getApplicationContext(), "Dado aceito", Toast.LENGTH_SHORT).show();
//                        }else if (arraylista.get(i).equals(result)){
//                            Toast.makeText(getApplicationContext(), "Dado duplicado", Toast.LENGTH_SHORT).show();
//                            arraylista.remove(i);
//                        }
//                }
//            }
        });
    }
}
