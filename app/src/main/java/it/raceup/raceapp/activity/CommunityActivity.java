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
                replaceFragment(new AboutFragment());
                break;

            case R.id.card_jacopo:
                replaceFragment(new PhoneBookFragment());
                break;
        }
    }

    protected void openPlayerFragment(String name, String industry, String age, String email, String record_0, String record_1) {
        //
    }

    private void replaceFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, fragment).commit();
    }
}
