package net.myprojects.guardappv2;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import static android.app.Notification.DEFAULT_ALL;
import static android.app.NotificationManager.IMPORTANCE_MAX;

/**
 * Created by PROBOOK G2 on 4/12/2018.
 */

public class MiFirebaseMessagingService extends FirebaseMessagingService {
    public static final String TAG="MESSAGE";
    public static  int NOTIFICATION_ID = 1;

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        //Call method to generate notification
        if(remoteMessage.getNotification() != null)
        {
            String message = remoteMessage.getNotification().getBody();
            generateNotification(message);
            String DeviceToken = FirebaseInstanceId.getInstance().getToken();
            Log.d("DeviceToken ==> ",  DeviceToken);
        }
        else
        {
            Log.e(TAG,"NO SIRVE PERRO");
        }

    }

    private void generateNotification(String messageBody) {
        //EditText editText = (EditText)findViewById(R.id.etName);
        String name = messageBody;

        NotificationManager notificationManager = (NotificationManager) getSystemService(this.NOTIFICATION_SERVICE);
        String NOTIFICATION_CHANNEL_ID = "my_channel_id_01";

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel notificationChannel = new NotificationChannel(NOTIFICATION_CHANNEL_ID, "My Notifications", IMPORTANCE_MAX);

            // Configure the notification channel.
            notificationChannel.setDescription("Channel description");
            notificationChannel.enableLights(true);
            notificationChannel.setLightColor(Color.CYAN);
            notificationChannel.setVibrationPattern(new long[]{0, 500, 500, 500});
            notificationChannel.enableVibration(true);
            notificationManager.createNotificationChannel(notificationChannel);
        }


        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this, NOTIFICATION_CHANNEL_ID);

        notificationBuilder.setAutoCancel(true)
                .setDefaults(DEFAULT_ALL)
                .setWhen(System.currentTimeMillis())
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setTicker("Hearty365")
                //     .setPriority(Notification.PRIORITY_MAX)
                .setContentTitle("Say Hi")
                .setContentText(name)
                .setContentInfo("Info")
                .setAutoCancel(true);

        notificationManager.notify(/*notification id*/1, notificationBuilder.build());


        //open second activity
        Intent intent = new Intent(this,MenuActivity.class);
        intent.putExtra("name",name);
        //flags
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
        //pending intent
        PendingIntent pending = PendingIntent.getActivity(this,0,intent,PendingIntent.FLAG_UPDATE_CURRENT);
        notificationBuilder.setContentIntent(pending);
        //send notification
        NotificationManager manager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        manager.notify(0,notificationBuilder.build());
    }
/*
     private void mostrarNotificacion(String title,String body)
    {
        Intent intent=new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pendingIntent=PendingIntent.getActivity(this,0,intent,PendingIntent.FLAG_ONE_SHOT);
        Uri soundUri= RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        //NotificationCompat.Builder
        Notification.Builder notificationBuilder=new Notification.Builder(this)
                .setSmallIcon(R.drawable.ic_event)
                .setContent(title)
                .setContentText(body)
                .setAutoCancel(true)
                .setSound(soundUri)
                .setContentIntent(pendingIntent);

        NotificationManager notificationManager=(NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(0,notificationBuilder.build());
    }*/
}
