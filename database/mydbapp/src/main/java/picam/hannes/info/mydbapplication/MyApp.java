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
        builder.setApiKey(BuildConfig.API_KEY);
        builder.setDatabaseUrl(BuildConfig.DATABASE_URL);
//        builder.setGcmSenderId(gcmSenderId);
        builder.setStorageBucket(BuildConfig.STORAGEBUCKET);
        fbApp = FirebaseApp.initializeApp(this, builder.build(), DB_APP);
    }
}
