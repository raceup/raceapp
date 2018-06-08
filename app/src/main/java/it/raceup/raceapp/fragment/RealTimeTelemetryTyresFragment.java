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
import android.widget.TextView;

import com.github.lzyzsd.circleprogress.ArcProgress;

import it.raceup.raceapp.R;
import it.raceup.raceapp.utils.Utils;

import static it.raceup.raceapp.utils.Utils.formatDecimals;

/**
 * Fragment in RealTimeTelemetry activity to show info about tyres
 */

public class RealTimeTelemetryTyresFragment extends Fragment {
    private static final String TAG = "RealTimeTelemetryTyresFragment";
    final Handler handler = new Handler();
    private View mFragmentView;

    public RealTimeTelemetryTyresFragment() {
        // Required empty public constructor
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mFragmentView = inflater.inflate(R.layout.fragment_real_time_telemetry_tyres, container, false);

        handler.post(new Runnable() {
            @Override
            public void run() {
                try {
                    updateValues();
                    handler.postDelayed(this, 200); // set time here to refresh textView
                } catch (Exception e) {
                }
            }
        });

        return mFragmentView;
    }

    private void updateValues() {
        double throttle = Utils.randomInRange(35, 95);
        double brake = 100.0 - throttle;
        double maxBarBrakes = 150.0 * brake / 100.0;
        double[] brakes = Utils.randomsInRange(maxBarBrakes * 0.75, maxBarBrakes, 2);

        ArcProgress arc = getActivity().findViewById(R.id.arc_progress);
        arc.setProgress((int) throttle);

        TextView view = getActivity().findViewById(R.id.front_brake_button);
        view.setText(formatDecimals(brakes[0]));

        view = getActivity().findViewById(R.id.rear_brake_button);
        view.setText(formatDecimals(brakes[1]));
    }
}
