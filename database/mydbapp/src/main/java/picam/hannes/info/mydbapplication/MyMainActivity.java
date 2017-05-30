package picam.hannes.info.mydbapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.quickstart.database.LibSignInActivity;

import picam.hannes.info.mydbapplication.activity.AppSignInActivity;

public class MyMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mymain);
        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MyMainActivity.this, LibSignInActivity.class));
            }
        });
        findViewById(R.id.buttonApp).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MyMainActivity.this, AppSignInActivity.class));
            }
        });
        TextView testApplicationID = (TextView) findViewById(R.id.textApp);
        String[] token = BuildConfig.APPLICATION_ID.split("\\.");
        testApplicationID.setText(BuildConfig.APPLICATION_ID);
        setTitle(token[token.length - 1]);
    }
}
