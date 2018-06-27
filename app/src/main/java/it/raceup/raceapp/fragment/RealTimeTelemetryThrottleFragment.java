/*
 * Copyright 2017 Race UP Electric Division
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package it.raceup.raceapp.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import it.raceup.raceapp.R;
import it.raceup.raceapp.activity.HelpActivity;

import static it.raceup.raceapp.utils.Utils.openActivityByClass;

/**
 * Fragment in RealTimeTelemetry activity to show info about tyres
 */

public class RealTimeTelemetryThrottleFragment extends Fragment {
    private static final String TAG = "RealTimeTelemetryThrottleFragment";
    final Handler handler = new Handler();

    public RealTimeTelemetryThrottleFragment() {
        //
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View mFragmentView = inflater.inflate(R.layout.fragment_real_time_telemetry_throttle, container, false);
        handler.post(new Runnable() {
            @Override
            public void run() {
                try {
                    setupButton();  // todo move in setup
                    handler.postDelayed(this, 200); // set time here to refresh textView
                } catch (Exception e) {
                }
            }
        });

        return mFragmentView;
    }

    private void setupButton() {
        ImageButton button = getActivity().findViewById(R.id.alert_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openHelpActivity();
            }
        });
    }

    private void openHelpActivity() {
        openActivityByClass(getContext(), HelpActivity.class);
    }
}
