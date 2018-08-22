package com.example.logonrmlocal.listagemdedados;

import java.util.ArrayList;
import java.util.List;

public class GeradorContatos {

    public static List<Contato> geraContato(){
        List<Contato> contatos = new ArrayList<>();

        Contato c1 = new Contato("Jaber" , "(11) 2222222" , "Ausente" , R.drawable.if_users_2_984102);
        Contato c = new Contato("Lucas" , "(42) 400289377" , "Disponivel" , R.drawable.if_users_4_984103);
        contatos.add(c);

        return contatos;
    }


}
