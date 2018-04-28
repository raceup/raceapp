package it.raceup.raceapp.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.arlib.floatingsearchview.FloatingSearchView;

import java.util.List;

import it.raceup.raceapp.R;
import it.raceup.raceapp.fragment.BaseExampleFragment;
import it.raceup.raceapp.fragment.ChallengePlayerFragment;
import it.raceup.raceapp.fragment.SlidingSearchResultsExampleFragment;

public class CommunityActivity extends AppCompatActivity
        implements BaseExampleFragment.BaseExampleFragmentCallbacks, View.OnClickListener {
    private DrawerLayout mDrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_community);

        mDrawerLayout = findViewById(R.id.drawer_layout);
        replaceFragment(new SlidingSearchResultsExampleFragment());


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

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.card_eleonora:
                openPlayerFragment(
                        getString(R.string.eleonora),
                        getString(R.string.eleonora_spa),
                        getString(R.string.eleonora_age),
                        getString(R.string.eleonora_email),
                        getString(R.string.eleonora_career_record_monza),
                        getString(R.string.eleonora_career_record_spa)
                );
                break;

            case R.id.card_jacopo:
                openPlayerFragment(
                        getString(R.string.jacopo),
                        getString(R.string.jacopo_spa),
                        getString(R.string.jacopo_age),
                        getString(R.string.jacopo_email),
                        getString(R.string.jacopo_career_record_monza),
                        getString(R.string.jacopo_career_record_spa)
                );
                break;
        }
    }

    protected void openPlayerFragment(String name, String industry, String age, String email, String record_0, String record_1) {
        ChallengePlayerFragment fragment = ChallengePlayerFragment.newInstance(
                name,
                industry,
                age,
                email,
                record_0,
                record_1
        );  // create fragment
        replaceFragment(fragment);  // make it visible
    }

    private void replaceFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, fragment).commit();
    }
}
