package br.com.fiap.aula_broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.widget.Toast;

public class MeuBroadCast extends BroadcastReceiver {


    @Override
    public void onReceive(Context context, Intent intent) {
        //Tudo oq foi enviado para a intent sera armazenado
        Bundle myBundle  = intent.getExtras();
        // Array de sms
        SmsMessage[] messages = null;
        //Variavel que enviara os valores
        String strMessage = "";

        if(myBundle != null){
            Object[] pdus = (Object[]) myBundle.get("pdus");
            messages = new SmsMessage[pdus.length];

            for(int i =0; i < messages.length; i++){
                //Retornando versao do android
                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                    String format = myBundle.getString("format");
                    messages[i] = SmsMessage.createFromPdu((byte[])pdus[i],format);
                }else{
                    //Para verificar versoes mais antigas
                    messages[i] = SmsMessage.createFromPdu((byte[])pdus[i]);
                }

                //Telefone de quem enviou para concatenar com o numero da pessoa
                strMessage += "SMS from: " + messages[i].getOriginatingAddress();
                strMessage += " : " + messages[i].getMessageBody();
                strMessage += "\n";

            }

            Toast.makeText(context, strMessage, Toast.LENGTH_SHORT).show();
        }

    }
}
