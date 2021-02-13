package diet.edu.alarms_abr;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;

import androidx.core.app.NotificationCompat;

public class MyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        NotificationManager nm = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        String channel_id ="kri_channel";
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            NotificationChannel nc = new NotificationChannel(channel_id,
                    "kri_channel",NotificationManager.IMPORTANCE_HIGH);
            nc.enableLights(true);
            nc.enableVibration(true);
            nc.setDescription("AlarmChannel");
            nm.createNotificationChannel(nc);
        }
        NotificationCompat.Builder builder = new
                NotificationCompat.Builder(context,channel_id);
        builder.setSmallIcon(R.drawable.ic_launcher_background);
        builder.setContentText("Alarm Notification");
        builder.setContentTitle("This is Alarm Notification");
        builder.setDefaults(NotificationCompat.DEFAULT_ALL);
        nm.notify(12,builder.build());

    }
}