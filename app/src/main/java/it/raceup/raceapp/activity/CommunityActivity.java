package it.raceup.raceapp.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;

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
        showFragment(new SlidingSearchResultsExampleFragment());
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

    private void showFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, fragment).commit();
    }
}
