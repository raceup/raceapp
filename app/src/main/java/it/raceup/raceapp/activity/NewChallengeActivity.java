package it.raceup.raceapp.activity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.DatePicker;

import java.util.Calendar;

import it.raceup.raceapp.R;

public class NewChallengeActivity extends AppCompatActivity {
    final Calendar myCalendar = Calendar.getInstance();

    final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            myCalendar.set(Calendar.YEAR, year);
            myCalendar.set(Calendar.MONTH, monthOfYear);
            myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        }
    };
    final View.OnClickListener dateListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            new DatePickerDialog(
                    NewChallengeActivity.this,
                    date,
                    myCalendar.get(Calendar.YEAR),
                    myCalendar.get(Calendar.MONTH),
                    myCalendar.get(Calendar.DAY_OF_MONTH)
            ).show();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_challenge);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        setup();
    }

    private void setup() {
        setupCardListeners();
    }

    private void setupCardListeners() {
        CardView card = findViewById(R.id.monza_card);
        card.setOnClickListener(dateListener);

        card = findViewById(R.id.silverstone_card);
        card.setOnClickListener(dateListener);

        card = findViewById(R.id.hockenheim_card);
        card.setOnClickListener(dateListener);

        card = findViewById(R.id.monaco_card);
        card.setOnClickListener(dateListener);

        card = findViewById(R.id.abudhabi_card);
        card.setOnClickListener(dateListener);

        card = findViewById(R.id.spa_card);
        card.setOnClickListener(dateListener);
    }
}
