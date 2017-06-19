package picam.hannes.info.appneu;

import android.app.Application;

import com.google.firebase.quickstart.database.LibApp;

public class AppNeu extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        LibApp.setupLibFirebase(this);
    }
}
