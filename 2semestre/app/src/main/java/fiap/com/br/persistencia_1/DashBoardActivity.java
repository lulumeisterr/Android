package fiap.com.br.persistencia_1;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class DashBoardActivity extends AppCompatActivity {

    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);

        // Matando a sessao no sharedPreference

        sp = getSharedPreferences("login", MODE_PRIVATE);
    }

    public void logout(View v){

        // Matando a sessao no sharedPreference

        SharedPreferences.Editor editor = sp.edit();

        editor.remove("usuario");
        editor.remove("senha");
        editor.remove("conectado");

        editor.commit();

    }


}
