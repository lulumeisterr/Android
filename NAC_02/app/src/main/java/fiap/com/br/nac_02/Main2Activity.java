package fiap.com.br.nac_02;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.net.Uri;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private TextView nome2;
    private TextView email2;
    public static final int CONSTANTE_TELA_2 = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent intent = new Intent();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG).setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        Exibir(intent);
    }

    public void Exibir(Intent intent){

        // Buscando a intent

         intent = getIntent();

        // Recuperando as chaves setas na minha primeira main Put

        String nomeOther = intent.getStringExtra("nome_pessoa");
        String emailOther = intent.getStringExtra("email_pessoa");


        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        View header = navigationView.getHeaderView(0);

        // Recuperando os id da minha 2 Tela
        TextView nome = (TextView) header.findViewById(R.id.main2Nome);
        TextView email = (TextView) header.findViewById(R.id.main2Email);

        // Setando os valores nos TextView , Usando o try para tratar o erro caso der

        try {
            nome.setText("Nome : " + nomeOther);
            email.setText("Email : " + emailOther);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Toast.makeText(Main2Activity.this, "Nome : " + nomeOther + "E-mail : " + emailOther, Toast.LENGTH_LONG).show();

        }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.nav_telefone) {
            Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:123456789"));
            startActivity(intent);
        }else
            if(id == R.id.nav_git){

                Uri uri = Uri.parse("https://github.com/lulumeisterr/Android");
                Intent intent = new Intent(Intent.ACTION_VIEW ,uri);
                startActivity(intent);
            }else
                if(id == R.id.nav_face){
                    Uri uri = Uri.parse("https://www.facebook.com/lululubs");
                    Intent intent = new Intent(Intent.ACTION_VIEW ,uri);
                    startActivity(intent);
                }else
                    if(id == R.id.nav_link){
                        Uri uri = Uri.parse("https://linkedin.com/in/lulumeister/");
                        Intent intent = new Intent(Intent.ACTION_VIEW ,uri);
                        startActivity(intent);
                    }else if(id == R.id.nav_tela3){
                        Intent intent = new Intent(Main2Activity.this, Main3Activity.class);
                        startActivity(intent);
                        finish();
                    }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
