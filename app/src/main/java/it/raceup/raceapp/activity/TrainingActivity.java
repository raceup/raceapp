package it.raceup.raceapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import it.raceup.raceapp.R;

public class
TrainingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_training);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        setup();
    }

    private void setup() {
        setupCardListeners();
    }

    private void setupCardListeners() {
        CardView card = findViewById(R.id.monza_card);
        card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTrainingChallengeActivity(
                        String.valueOf(R.string.monza_title),
                        R.drawable.monza,
                        String.valueOf(R.string.monza_record_lap),
                        String.valueOf(R.string.monza_record_pilot)
                );
            }
        });

        card = findViewById(R.id.silverstone_card);
        card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTrainingChallengeActivity(
                        String.valueOf(R.string.silverstone_title),
                        R.drawable.spa,
                        String.valueOf(R.string.silverstone_record_lap),
                        String.valueOf(R.string.silverstone_record_pilot)
                );
            }
        });

        card = findViewById(R.id.hockenheim_card);
        card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTrainingChallengeActivity(
                        String.valueOf(R.string.hockenheim_title),
                        R.drawable.hockenheim,
                        String.valueOf(R.string.hockenheim_record_lap),
                        String.valueOf(R.string.hockenheim_record_pilot)
                );
            }
        });

        card = findViewById(R.id.monaco_card);
        card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTrainingChallengeActivity(
                        String.valueOf(R.string.monaco_title),
                        R.drawable.monaco,
                        String.valueOf(R.string.monaco_record_lap),
                        String.valueOf(R.string.monaco_record_pilot)
                );
            }
        });

        card = findViewById(R.id.abudhabi_card);
        card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTrainingChallengeActivity(
                        String.valueOf(R.string.abudhabi_title),
                        R.drawable.abudhabi,
                        String.valueOf(R.string.abudhabi_record_lap),
                        String.valueOf(R.string.abudhabi_record_pilot)
                );
            }
        });

        card = findViewById(R.id.spa_card);
        card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTrainingChallengeActivity(
                        String.valueOf(R.string.spa_title),
                        R.drawable.spa,
                        String.valueOf(R.string.spa_record_lap),
                        String.valueOf(R.string.spa_record_pilot)
                );
            }
        });
    }

    protected void openTrainingChallengeActivity(String circuit, int mapId, String time, String driver) {
        Intent intent = new Intent(this, TrainingChallengeActivity.class);
        Bundle extras = new Bundle();  // create bundle
        extras.putString(TrainingChallengeActivity.ARG_PARAM_CIRCUIT, circuit);
        extras.putInt(TrainingChallengeActivity.ARG_PARAM_MAP, mapId);
        extras.putString(TrainingChallengeActivity.ARG_PARAM_RECORD_TIME, time);
        extras.putString(TrainingChallengeActivity.ARG_PARAM_RECORD_DRIVER, driver);

        intent.putExtras(extras);
        startActivity(intent);
    }
}
