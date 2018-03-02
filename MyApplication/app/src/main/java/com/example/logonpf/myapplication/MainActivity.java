package com.example.logonpf.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btOpen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btOpen = (Button) findViewById(R.id.bt_open);
        btOpen.setOnClickListener(this);
        Log.d("gofc","onCreate");
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.bt_open) {
//            String location = "tel:123456789";
//            Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse(location));

//            Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//            if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
//                startActivityForResult(takePictureIntent, 123);
//            }
            finish();
            Boolean isFinishing = isFinishing(); // Retornará se a activy está aberta ou nao
            Log.d("gofc",isFinishing.toString());
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 123 && resultCode == RESULT_OK) {
            Log.d("gofc", "pegou a foto");
        }

        if (resultCode == RESULT_CANCELED) {
            Log.d("gofc", "ele nao quer mais");
        }

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("gofc","onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("gofc","onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("gofc","onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("gofc","onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("gofc","onDestroy");
    }
}
