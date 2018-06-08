package it.raceup.raceapp.activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import it.raceup.raceapp.R;

public class ChallengePlayerActivity extends AppCompatActivity {
    public static final String ARG_PARAM_NAME = "name";
    public static final String ARG_PARAM_NAME_IMAGE = "nameImage";
    public static final String ARG_PARAM_INDUSTRY = "industry";
    public static final String ARG_PARAM_INDUSTRY_IMAGE = "industryImage";
    public static final String ARG_PARAM_AGE = "age";
    public static final String ARG_PARAM_EMAIL = "email";
    public static final String ARG_PARAM_RECORD_0 = "record_0";
    public static final String ARG_PARAM_RECORD_1 = "record_1";
    private String name, industry, age, email, record_0, record_1;
    private int profileImage, industryImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_challenge_player);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button button = findViewById(R.id.start_challenge);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openNewChallengeActivity();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        getArgsFromBundle(getIntent().getExtras());
        populate();
    }

    protected void getArgsFromBundle(Bundle args) {
        name = args.getString(ARG_PARAM_NAME);
        profileImage = args.getInt(ARG_PARAM_NAME_IMAGE);
        industry = args.getString(ARG_PARAM_INDUSTRY);
        industryImage = args.getInt(ARG_PARAM_INDUSTRY_IMAGE);
        age = args.getString(ARG_PARAM_AGE);
        email = args.getString(ARG_PARAM_EMAIL);
        record_0 = args.getString(ARG_PARAM_RECORD_0);
        record_1 = args.getString(ARG_PARAM_RECORD_1);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    protected void populate() {
        TextView textView = findViewById(R.id.text_name);
        textView.setText(name);

        textView = findViewById(R.id.text_age);
        textView.setText(age);

        textView = findViewById(R.id.text_spa);
        textView.setText(industry);

        textView = findViewById(R.id.text_email);
        textView.setText(email);

        textView = findViewById(R.id.text_record_0);
        textView.setText(record_0);

        textView = findViewById(R.id.text_record_1);
        textView.setText(record_1);

        ImageView imageView = findViewById(R.id.icon_profile);
        imageView.setImageDrawable(getDrawable(profileImage));

        imageView = findViewById(R.id.icon_business);
        imageView.setImageDrawable(getDrawable(industryImage));
    }

    private void openNewChallengeActivity() {
        Intent openActivity = new Intent(ChallengePlayerActivity.this, NewChallengeActivity.class);
        startActivity(openActivity);
    }
}
