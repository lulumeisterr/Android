package com.example.logonrmlocal.listagemdedados;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ContatosAdapter extends BaseAdapter{

    Context context;
    List<Contato> contatos;


    public ContatosAdapter(Context context , List<Contato> contatos){
        this.context = context;
        this.contatos = contatos;
    }

    @Override
    // Quantas as celulas as listas vai conter , ou seja pegamos o tamanho da lista
    public int getCount() {
        // Retornar a quantidade de contato
        return this.contatos.size();
    }

    @Override
    public Object getItem(int i) {
        // Retornando as posicoes da lista
        return this.contatos.get(i);
    }

    @Override
    public long getItemId(int i) {
        // Incrementando o ID
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        // Inflando o XML

        // Receber o contexto
        LayoutInflater layoutInflater = LayoutInflater.from(this.context);

        // Pegar os dados dos contatos especificos
        Contato contato = this.contatos.get(i);

        // Passar a view da Lista
        View v = layoutInflater.inflate(R.layout.listview_contatos, null);

        // Recuperando os componentes do layoult
        ImageView imgContato = v.findViewById(R.id.imgContato);
        TextView txtNome = v.findViewById(R.id.txtNome);
        TextView txtTelefone = v.findViewById(R.id.txtTelefone);

        // Setando os dados

        imgContato.setImageResource(contato.getImagem());
        txtNome.setText(contato.getNome());
        txtTelefone.setText(contato.getTelefone());

        // Retornando a VIEW
        return v;
    }
}
