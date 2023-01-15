package fr.perrze.aguilleurdepaires;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.IBinder;

import androidx.preference.PreferenceManager;

public class SwitchmanServerService extends Service {
    ClientSide clientThread;
    public SwitchmanServerService() {
    }
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Context context = getApplicationContext();
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        String serverIp= prefs.getString("ip","10.0.0.5");
        int serverPort = Integer.parseInt(prefs.getString("port","5000"));

        clientThread = new ClientSide(serverPort,serverIp);
        return START_STICKY;
    }
    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

}