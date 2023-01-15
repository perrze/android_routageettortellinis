package fr.perrze.aiguilleurdepaires;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class SwitchmanNetwork extends Service {
    public SwitchmanNetwork() {

    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}