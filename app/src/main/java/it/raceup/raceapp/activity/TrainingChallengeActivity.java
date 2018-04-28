package it.raceup.raceapp.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import it.raceup.raceapp.R;

public class TrainingChallengeActivity extends AppCompatActivity {
    public static final String ARG_PARAM_CIRCUIT = "circuit";
    public static final String ARG_PARAM_MAP = "map_id";
    public static final String ARG_PARAM_RECORD_TIME = "time";
    public static final String ARG_PARAM_RECORD_DRIVER = "driver";
    private String circuit, time, driver;
    private int mapId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_training_challenge);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    protected void getArgsFromBundle(Bundle args) {
        circuit = args.getString(ARG_PARAM_CIRCUIT);
        mapId = args.getInt(ARG_PARAM_MAP);
        time = args.getString(ARG_PARAM_RECORD_TIME);
        driver = args.getString(ARG_PARAM_RECORD_DRIVER);
    }

    protected void populate() {
        TextView textView = findViewById(R.id.text_name);
        textView.setText(circuit);

        textView = findViewById(R.id.text_age);
        textView.setText(time);

        textView = findViewById(R.id.text_spa);
        textView.setText(driver);

        ImageView imageView = findViewById(R.id.imageView);
    }

    private void openConfirmationActivity() {
        // todo create activity with confirmation dialog and loading bar
    }
}
