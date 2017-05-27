package picam.hannes.info.mydbapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.quickstart.database.SignInActivity;

public class MyMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mymain);
        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MyMainActivity.this, SignInActivity.class));
            }
        });
        TextView testApplicationID = (TextView) findViewById(R.id.textApp);
        testApplicationID.setText(BuildConfig.APPLICATION_ID);

    }
}
