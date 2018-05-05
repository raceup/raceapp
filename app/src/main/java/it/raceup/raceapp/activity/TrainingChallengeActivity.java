package it.raceup.raceapp.activity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.Calendar;

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

        getArgsFromBundle(getIntent().getExtras());
        populate();
        setButtonListeners();
    }

    protected void getArgsFromBundle(Bundle args) {
        circuit = args.getString(ARG_PARAM_CIRCUIT);
        mapId = args.getInt(ARG_PARAM_MAP);
        time = args.getString(ARG_PARAM_RECORD_TIME);
        driver = args.getString(ARG_PARAM_RECORD_DRIVER);
    }

    protected void populate() {
        TextView textView = findViewById(R.id.circuit);
        textView.setText(circuit);

        textView = findViewById(R.id.record_time);
        textView.setText(time);

        textView = findViewById(R.id.record_driver);
        textView.setText(driver);

        // todo add image ImageView imageView = findViewById(R.id.);
        // imageView.setImageResource(mapId);
    }

    protected void setButtonListeners() {
        final Calendar myCalendar = Calendar.getInstance();

        final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                Snackbar.make(view, "Challenge added!", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }

        };

        findViewById(R.id.challenge_invitation).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(
                        TrainingChallengeActivity.this,
                        date,
                        myCalendar.get(Calendar.YEAR),
                        myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)
                ).show();
            }
        });

        findViewById(R.id.challenge_now).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(
                        TrainingChallengeActivity.this,
                        date,
                        myCalendar.get(Calendar.YEAR),
                        myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)
                ).show();
            }
        });
    }

    private void openConfirmationActivity() {
        // todo create activity with confirmation dialog and loading bar
    }
}
