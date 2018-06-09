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
import android.widget.TextView;

import it.raceup.raceapp.R;
import it.raceup.raceapp.utils.Utils;

import static it.raceup.raceapp.utils.Utils.formatDecimals;

/**
 * Fragment in RealTimeTelemetry activity to show info about throttle/brakes and steering
 */

public class RealTimeTelemetryThrottleFragment extends Fragment {
    final Handler handler = new Handler();
    private static final String TAG = "RealTimeTelemetryThrottleFragment";
    private View mFragmentView;

    public RealTimeTelemetryThrottleFragment() {
        // Required empty public constructor
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mFragmentView = inflater.inflate(R.layout.fragment_real_time_telemetry_throttle, container, false);
        setupButton();

        handler.post(new Runnable() {
            @Override
            public void run() {
                updateValues();
                handler.postDelayed(this, 200); // set time here to refresh textView
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
        //
    }

    private void updateValues() {
        double suspensions[] = Utils.randomsInRange(-25, 25, 4);
        double speeds[] = Utils.randomsInRange(10, 15, 4);
        double wb[] = Utils.randomsInRange(85, 95, 4);
        double ti[] = Utils.randomsInRange(55, 65, 4);

        // front left
        TextView view = getActivity().findViewById(R.id.fl_suspension_value);
        view.setText(formatDecimals(suspensions[0]));

        view = getActivity().findViewById(R.id.fl_speed_value);
        view.setText(formatDecimals(speeds[0]));

        view = getActivity().findViewById(R.id.fl_water_block_value);
        view.setText(formatDecimals(wb[0]));

        view = getActivity().findViewById(R.id.fl_ti_value);
        view.setText(formatDecimals(ti[0]));


        // front right
        view = getActivity().findViewById(R.id.fr_suspension_value);
        view.setText(formatDecimals(suspensions[1]));

        view = getActivity().findViewById(R.id.fr_speed_value);
        view.setText(formatDecimals(speeds[1]));

        view = getActivity().findViewById(R.id.fr_water_block_value);
        view.setText(formatDecimals(wb[1]));

        view = getActivity().findViewById(R.id.fr_ti_value);
        view.setText(formatDecimals(ti[1]));


        // rear left
        view = getActivity().findViewById(R.id.rl_suspension_value);
        view.setText(formatDecimals(suspensions[2]));

        view = getActivity().findViewById(R.id.rl_speed_value);
        view.setText(formatDecimals(speeds[2]));

        view = getActivity().findViewById(R.id.rl_water_block_value);
        view.setText(formatDecimals(wb[2]));

        view = getActivity().findViewById(R.id.rl_ti_value);
        view.setText(formatDecimals(ti[2]));


        // rear right
        view = getActivity().findViewById(R.id.rr_suspension_value);
        view.setText(formatDecimals(suspensions[3]));

        view = getActivity().findViewById(R.id.rr_speed_value);
        view.setText(formatDecimals(speeds[3]));

        view = getActivity().findViewById(R.id.rr_water_block_value);
        view.setText(formatDecimals(wb[3]));

        view = getActivity().findViewById(R.id.rr_ti_value);
        view.setText(formatDecimals(ti[3]));
    }
}
