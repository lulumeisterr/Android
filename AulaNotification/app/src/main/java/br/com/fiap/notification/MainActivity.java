package br.com.fiap.notification;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @SuppressLint("ObsoleteSdkInt")
    public void exibirNotificacao(View view){
        @SuppressLint("ServiceCast") Notification notificationManager
                = (Notification) getSystemService(Context.NOTIFICATION_SERVICE);

        String channelId = "alertas";

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.BASE){
            NotificationChannel notificationChannel
                    = new NotificationChannel(

                        channelId,
                    "Meu Canal de notificacao",
                    NotificationManager.IMPORTANCE_DEFAULT
            );

            notificationChannel.setDescription("Descricao explicando este canal ....");
            notificationChannel.enableLights(true);
            notificationChannel.setLightColor(Color.RED);
            notificationChannel.setVibrationPattern(new long[]{0,1000,500,200});
            notificationChannel.enableVibration(true);

            notificationManager.createNotificationChannel(notificationChannel);

            NotificationCompat.Builder notification = new NotificationCompat.Builder(this,channelId);

            notification.setContentTitle("Alerta");
            notification.setContentText("Seu download foi concluido");
            notification.setSmallIcon(R.mipmap.ic_launcher);

            notification.setContentIntent(

                    PendingIntent.getActivity(
                            this,0 , new Intent(this,MainActivity.class),
                            PendingIntent.FLAG_CANCEL_CURRENT
                    )

            );

            notification.setAutoCancel(true);
            notificationManager.notify(100 , notification.build());
        }
    }
}
