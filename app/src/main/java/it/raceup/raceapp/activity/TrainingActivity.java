package it.raceup.raceapp.activity;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import it.raceup.raceapp.R;
import it.raceup.raceapp.fragment.TrackFragment;

public class TrainingActivity extends AppCompatActivity {

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
                Bundle args = new Bundle();
                args.putString("title", String.valueOf(R.string.monza_title));
                args.putString("recordLap", String.valueOf(R.string.monza_record_lap));
                args.putString("recordPilot", String.valueOf(R.string.monza_record_pilot));

                Fragment trackFragment = new TrackFragment();
                trackFragment.setArguments(args);
            }
        });


        card = findViewById(R.id.silverstone_card);
        card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle args = new Bundle();
                args.putString("title", String.valueOf(R.string.silverstone_title));
                args.putString("recordLap", String.valueOf(R.string.silverstone_record_lap));
                args.putString("recordPilot", String.valueOf(R.string.silverstone_record_pilot));

                Fragment trackFragment = new TrackFragment();
                trackFragment.setArguments(args);
            }
        });


        card = findViewById(R.id.hockenheim_card);
        card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle args = new Bundle();
                args.putString("title", String.valueOf(R.string.hockenheim_title));
                args.putString("recordLap", String.valueOf(R.string.hockenheim_record_lap));
                args.putString("recordPilot", String.valueOf(R.string.hockenheim_record_pilot));

                Fragment trackFragment = new TrackFragment();
                trackFragment.setArguments(args);
            }
        });


        card = findViewById(R.id.monaco_card);
        card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle args = new Bundle();
                args.putString("title", String.valueOf(R.string.monaco_title));
                args.putString("recordLap", String.valueOf(R.string.monaco_record_lap));
                args.putString("recordPilot", String.valueOf(R.string.monaco_record_pilot));

                Fragment trackFragment = new TrackFragment();
                trackFragment.setArguments(args);
            }
        });


        card = findViewById(R.id.abudhabi_card);
        card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle args = new Bundle();
                args.putString("title", String.valueOf(R.string.abudhabi_title));
                args.putString("recordLap", String.valueOf(R.string.abudhabi_record_lap));
                args.putString("recordPilot", String.valueOf(R.string.abudhabi_record_pilot));

                Fragment trackFragment = new TrackFragment();
                trackFragment.setArguments(args);
            }
        });


        card = findViewById(R.id.spa_card);
        card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle args = new Bundle();
                args.putString("title", String.valueOf(R.string.spa_title));
                args.putString("recordLap", String.valueOf(R.string.spa_record_lap));
                args.putString("recordPilot", String.valueOf(R.string.spa_record_pilot));

                Fragment trackFragment = new TrackFragment();
                trackFragment.setArguments(args);
            }
        });
    }
}
