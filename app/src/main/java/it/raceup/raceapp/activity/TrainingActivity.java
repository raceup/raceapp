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
                        getString(R.string.pista_azzurra_title),
                        R.drawable.monza,
                        getString(R.string.pista_azzurra_record_lap),
                        getString(R.string.pista_azzurra_record_pilot)
                );
            }
        });

        card = findViewById(R.id.silverstone_card);
        card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTrainingChallengeActivity(
                        getString(R.string.air_title),
                        R.drawable.spa,
                        getString(R.string.air_record_lap),
                        getString(R.string.air_record_pilot)
                );
            }
        });

        card = findViewById(R.id.hockenheim_card);
        card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTrainingChallengeActivity(
                        getString(R.string.franciacorta_title),
                        R.drawable.hockenheim,
                        getString(R.string.franciacorta_record_lap),
                        getString(R.string.franciacorta_record_pilot)
                );
            }
        });

        card = findViewById(R.id.monaco_card);
        card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTrainingChallengeActivity(
                        getString(R.string.salentina_title),
                        R.drawable.monaco,
                        getString(R.string.salentina_record_lap),
                        getString(R.string.salentina_record_pilot)
                );
            }
        });

        card = findViewById(R.id.abudhabi_card);
        card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTrainingChallengeActivity(
                        getString(R.string.aki_title),
                        R.drawable.abudhabi,
                        getString(R.string.aki_record_lap),
                        getString(R.string.aki_record_pilot)
                );
            }
        });

        card = findViewById(R.id.spa_card);
        card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTrainingChallengeActivity(
                        getString(R.string.vallelunga_title),
                        R.drawable.spa,
                        getString(R.string.vallelunga_record_lap),
                        getString(R.string.vallelunga_record_pilot)
                );
            }
        });
    }

    protected void openTrainingChallengeActivity(String circuit, int mapId, String time, String driver) {
        Intent intent = new Intent(this, TrainingChallengeActivity.class);
        Bundle extras = new Bundle();  // create bundle
        extras.putString(TrainingChallengeActivity.ARG_PARAM_CIRCUIT, circuit);
        // todo add map extras.putInt(TrainingChallengeActivity.ARG_PARAM_MAP, mapId);
        extras.putString(TrainingChallengeActivity.ARG_PARAM_RECORD_TIME, time);
        extras.putString(TrainingChallengeActivity.ARG_PARAM_RECORD_DRIVER, driver);

        intent.putExtras(extras);
        startActivity(intent);
    }
}
