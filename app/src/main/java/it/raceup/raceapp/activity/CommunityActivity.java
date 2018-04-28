package it.raceup.raceapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;

import com.arlib.floatingsearchview.FloatingSearchView;

import java.util.List;

import it.raceup.raceapp.R;
import it.raceup.raceapp.fragment.BaseExampleFragment;
import it.raceup.raceapp.fragment.SlidingSearchResultsExampleFragment;

public class CommunityActivity extends AppCompatActivity
        implements BaseExampleFragment.BaseExampleFragmentCallbacks {
    private DrawerLayout mDrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_community);

        mDrawerLayout = findViewById(R.id.drawer_layout);
        replaceFragment(new SlidingSearchResultsExampleFragment());

        setupClickListeners();
    }

    @Override
    public void onAttachSearchViewToDrawer(FloatingSearchView searchView) {
        searchView.attachNavigationDrawerToMenuButton(mDrawerLayout);
    }

    @Override
    public void onBackPressed() {
        List fragments = getSupportFragmentManager().getFragments();
        BaseExampleFragment currentFragment = (BaseExampleFragment) fragments.get(fragments.size() - 1);

        if (!currentFragment.onActivityBackPress()) {
            super.onBackPressed();
        }
    }

    private void setupClickListeners() {
        CardView card = getWindow().getDecorView().findViewById(R.id.card_eleonora);
        card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openPlayerActivity(
                        getString(R.string.eleonora),
                        getString(R.string.eleonora_spa),
                        getString(R.string.eleonora_age),
                        getString(R.string.eleonora_email),
                        getString(R.string.eleonora_career_record_monza),
                        getString(R.string.eleonora_career_record_spa)
                );
            }
        });

        card = getWindow().getDecorView().findViewById(R.id.card_jacopo);
        card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openPlayerActivity(
                        getString(R.string.jacopo),
                        getString(R.string.jacopo_spa),
                        getString(R.string.jacopo_age),
                        getString(R.string.jacopo_email),
                        getString(R.string.jacopo_career_record_monza),
                        getString(R.string.jacopo_career_record_spa)
                );
            }
        });
    }

    protected void openPlayerActivity(String name, String industry, String age, String email, String record_0, String record_1) {
        Intent intent = new Intent(this, ChallengePlayerActivity.class);

        Bundle extras = new Bundle();  // create bundle
        extras.putString(ChallengePlayerActivity.ARG_PARAM_NAME, name);
        extras.putString(ChallengePlayerActivity.ARG_PARAM_INDUSTRY, industry);
        extras.putString(ChallengePlayerActivity.ARG_PARAM_AGE, age);
        extras.putString(ChallengePlayerActivity.ARG_PARAM_EMAIL, email);
        extras.putString(ChallengePlayerActivity.ARG_PARAM_RECORD_0, record_0);
        extras.putString(ChallengePlayerActivity.ARG_PARAM_RECORD_1, record_1);

        intent.putExtras(extras);
        startActivity(intent);
    }

    private void replaceFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, fragment).commit();
    }
}
