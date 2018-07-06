package it.raceup.raceapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.Date;

import it.raceup.raceapp.BuildConfig;
import it.raceup.raceapp.R;

import static it.raceup.raceapp.utils.Utils.getBuildVersion;

public class SplashActivity extends AppCompatActivity {
    private final int SPLASH_DISPLAY_LENGTH = 1500;  // duration of wait (ms)

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.activity_splash);
        setup();

        /* New Handler to start the Menu-Activity
         * and close this Splash-Screen after some seconds.*/
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                /* Create an Intent that will start the Menu-Activity. */
                Intent mainIntent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(mainIntent);
                finish();
            }
        }, SPLASH_DISPLAY_LENGTH);
    }

    private void setup() {
        Date buildDate = new Date(BuildConfig.TIMESTAMP);
        TextView view = findViewById(R.id.build_timestamp);
        Long buildTime = buildDate.getTime();  // todo build points
        view.setText("v" + getBuildVersion(buildTime));
    }
}
