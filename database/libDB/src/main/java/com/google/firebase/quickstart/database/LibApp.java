package com.google.firebase.quickstart.database;

import android.app.Application;
import android.content.Context;

import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

public abstract class LibApp extends Application {

    public static String DB_LIB = "lib";
    public static FirebaseApp fbApp;

    @Override
    public void onCreate() {
        super.onCreate();
        setupLibFirebase(this);
    }

    public static void setupLibFirebase(Context context) {
        FirebaseOptions.Builder builder = new FirebaseOptions.Builder();
        builder.setApplicationId("info.hannes.firebase.quickstart.database");
        builder.setApiKey("AIzaSyATyo6Xmq2lFJpQ3LP9KJvlo_vZE-xGnEk");
        builder.setDatabaseUrl("https://db-demo-b395f.firebaseio.com");
//        builder.setGcmSenderId(gcmSenderId);
//        builder.setStorageBucket(storageBucket);
        fbApp = FirebaseApp.initializeApp(context, builder.build(), DB_LIB);
    }
}
