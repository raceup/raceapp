package it.raceup.raceapp.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;

/**
 * Shows track challenge
 */
public class TrackFragment extends Fragment {
    private String recordLap;
    private String title;
    private String recordPilot;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setup(savedInstanceState);
    }

    private void setup(Bundle args) {
        populate(args);
        populateView();
    }

    private void populate(Bundle args) {
        this.title = args.getString("title");
        this.recordLap = args.getString("recordLap");
        this.recordPilot = args.getString("recordPilot");
    }

    private void populateView() {
        // todo get this.feats and show them on screen
    }
}
