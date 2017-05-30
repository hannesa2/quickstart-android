package picam.hannes.info.mydbapplication;

import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.quickstart.database.LibApp;

public class MyApp extends LibApp {

    public static String DB_APP = "app";
    public static FirebaseApp fbApp;

    @Override
    public void onCreate() {
        super.onCreate();
        setupAppFirebase();
    }

    private void setupAppFirebase() {
        FirebaseOptions.Builder builder = new FirebaseOptions.Builder();
        builder.setApplicationId(BuildConfig.APPLICATION_ID);
        builder.setApiKey("AIzaSyAITvMrg9SL9Idu8aAncR26_RH_UEDHL2Q");
        builder.setDatabaseUrl("https://mx-tracks-info.firebaseio.com");
//        builder.setGcmSenderId(gcmSenderId);
        builder.setStorageBucket("mx-tracks-info.appspot.com");
        fbApp = FirebaseApp.initializeApp(this, builder.build(), DB_APP);
    }
}
