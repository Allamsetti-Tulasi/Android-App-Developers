package diet.edu.alarms_abr;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.widget.CompoundButton;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    ToggleButton toggleButton;
    AlarmManager am;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toggleButton = findViewById(R.id.tog1);
        am = (AlarmManager) getSystemService(ALARM_SERVICE);
        Intent intent = new Intent(MainActivity.this,
                MyReceiver.class);
        PendingIntent pi = PendingIntent.getBroadcast(MainActivity.this,
                23,intent,PendingIntent.FLAG_UPDATE_CURRENT);
        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton,
                                         boolean b) {
                if(b){

                    long triggertime = SystemClock.elapsedRealtime();
                    long intervaltime = 2*60*1000;
                    am.setInexactRepeating(AlarmManager.ELAPSED_REALTIME_WAKEUP,triggertime,
                            intervaltime,pi);

                    //Toast.makeText(MainActivity.this, "On",
                         //   Toast.LENGTH_SHORT).show();
                }
                else{
                    am.cancel(pi);
                    //Toast.makeText(MainActivity.this, "Off",
                           // Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}