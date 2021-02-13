package com.example.notifications_abr;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void send(View view) {
        NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        String channel_Id = "kriChannel";
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            NotificationChannel nc = new NotificationChannel(channel_Id,
                    "krichannel",NotificationManager.IMPORTANCE_HIGH);
            nc.enableLights(true);
            nc.enableVibration(true);
            nc.setDescription("Simple Channel");
            nm.createNotificationChannel(nc);
        }
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this,channel_Id);
        builder.setSmallIcon(R.drawable.article);
        builder.setContentTitle("Notification");
        builder.setContentText("This is a Simple Notification");
        Intent intent = new Intent(this,MainActivity.class);
        PendingIntent pi = PendingIntent.getActivity(this,
                23,
                intent,PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(pi);
        builder.setAutoCancel(true);
        builder.setDefaults(NotificationCompat.DEFAULT_ALL);
        builder.setPriority(1);
        builder.addAction(R.drawable.article,"reply",pi);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),
                R.drawable.val);
        builder.setStyle(new NotificationCompat.BigPictureStyle().
                bigPicture(bitmap));

         nm.notify(23,builder.build());
    }
}