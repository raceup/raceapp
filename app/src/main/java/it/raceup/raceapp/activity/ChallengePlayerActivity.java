package it.raceup.raceapp.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import it.raceup.raceapp.R;

public class ChallengePlayerActivity extends AppCompatActivity {
    public static final String ARG_PARAM_NAME = "name";
    public static final String ARG_PARAM_INDUSTRY = "industry";
    public static final String ARG_PARAM_AGE = "age";
    public static final String ARG_PARAM_EMAIL = "email";
    public static final String ARG_PARAM_RECORD_0 = "record_0";
    public static final String ARG_PARAM_RECORD_1 = "record_1";
    private String name, industry, age, email, record_0, record_1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_challenge_player);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        getArgsFromBundle(getIntent().getExtras());
        populate();
    }

    protected void getArgsFromBundle(Bundle args) {
        name = args.getString(ARG_PARAM_NAME);
        industry = args.getString(ARG_PARAM_INDUSTRY);
        age = args.getString(ARG_PARAM_AGE);
        email = args.getString(ARG_PARAM_EMAIL);
        record_0 = args.getString(ARG_PARAM_RECORD_0);
        record_1 = args.getString(ARG_PARAM_RECORD_1);
    }

    protected void populate() {
        System.out.println("--------------------- populating with "
                + name + ", "
                + industry + ", "
                + age + ", "
                + email + ", "
                + record_0 + ", "
                + record_1 + ".\n");
        // todo set text fields with class data attrs
    }
}
