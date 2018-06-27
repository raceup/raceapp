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

import it.raceup.raceapp.R;
import it.raceup.raceapp.utils.Utils;

import static it.raceup.raceapp.utils.Utils.formatDecimals;

/**
 * Fragment in RealTimeTelemetry activity to show info about throttle/brakes and steering
 */

public class RealTimeTelemetryTyresFragment extends Fragment {
    private static final String TAG = "RealTimeTelemetryTyresFragment";
    final Handler handler = new Handler();

    public RealTimeTelemetryTyresFragment() {
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View mFragmentView = inflater.inflate(R.layout.fragment_real_time_telemetry_tyres, container, false);

        handler.post(new Runnable() {
            @Override
            public void run() {
                try {
                    updateValues();
                    handler.postDelayed(this, 1000); // set time here to refresh textView
                } catch (Exception e) {
                }
            }
        });

        return mFragmentView;
    }

    private void updateValues() {
        double wb[] = Utils.randomsInRange(85, 87, 4);
        double ti[] = Utils.randomsInRange(55, 56, 4);

        // front left
        TextView view = getActivity().findViewById(R.id.fl_water_block_value);
        view.setText(formatDecimals(wb[0]));

        view = getActivity().findViewById(R.id.fl_ti_value);
        view.setText(formatDecimals(ti[0]));


        // front right
        view = getActivity().findViewById(R.id.fr_water_block_value);
        view.setText(formatDecimals(wb[1]));

        view = getActivity().findViewById(R.id.fr_ti_value);
        view.setText(formatDecimals(ti[1]));


        // rear left
        view = getActivity().findViewById(R.id.rl_water_block_value);
        view.setText(formatDecimals(wb[2]));

        view = getActivity().findViewById(R.id.rl_ti_value);
        view.setText(formatDecimals(ti[2]));


        // rear right
        view = getActivity().findViewById(R.id.rr_water_block_value);
        view.setText(formatDecimals(wb[3]));

        view = getActivity().findViewById(R.id.rr_ti_value);
        view.setText(formatDecimals(ti[3]));
    }
}
