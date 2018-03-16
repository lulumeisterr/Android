package com.example.logonrm.aula06;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId(); // RecuperaID do item

        switch (id) {

            case R.id.item1:
                Toast.makeText(this, "Foi inserido", Toast.LENGTH_SHORT).show();
                break;

            case R.id.item3:
                Toast.makeText(this, "Altrei o 2", Toast.LENGTH_SHORT).show();
                break;

            case R.id.item4:
                Toast.makeText(this, "Alterei o 3", Toast.LENGTH_SHORT).show(); // Exibe texto
                break;
            default:
                break;

        }

        return super.onOptionsItemSelected(item);
    }
}
