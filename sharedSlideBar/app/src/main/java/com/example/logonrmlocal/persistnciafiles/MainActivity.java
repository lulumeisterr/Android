package com.example.logonrmlocal.persistnciafiles;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {


    EditText edtInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtInfo = findViewById(R.id.edtInfo);

    }

    public void salvar(View view){

        try {
            FileOutputStream fos = openFileOutput("teste.txt" , MODE_PRIVATE);
            String txt = edtInfo.getText().toString();
            fos.write(txt.getBytes());
            fos.close();

            Toast.makeText(this , R.string.salvo_com_sucesso,Toast.LENGTH_SHORT).show();
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }

    public void lerArquivo(View view) throws IOException {

        try {
            FileInputStream fis = openFileInput("teste.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(fis));
            String txt = br.readLine();
            fis.close();

            Toast.makeText(this,txt,Toast.LENGTH_LONG).show();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            Toast.makeText(this,R.string.erro_ao_lerArquivo,Toast.LENGTH_SHORT).show();
        }


    }
}
