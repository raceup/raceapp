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
 * Fragment in RealTimeTelemetry activity to show info about telemetry
 */
public class RealTimeTelemetryTemperaturesFragment extends Fragment {
    private static final String TAG = "RealTimeTelemetryTemperaturesFragment";
    final Handler handler = new Handler();
    private View mFragmentView;

    public RealTimeTelemetryTemperaturesFragment() {
        // Required empty public constructor
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mFragmentView = inflater.inflate(R.layout.fragment_real_time_telemetry_temperatures, container, false);

        handler.post(new Runnable() {
            @Override
            public void run() {
                try {
                    updateTemperatures();
                    handler.postDelayed(this, 1000); // set time here to refresh textView
                } catch (Exception e) {
                }

            }
        });

        return mFragmentView;
    }

    private void updateTemperatures() {
        double[] engines = Utils.randomsInRange(75, 77, 2);
        double[] tyres = Utils.randomsInRange(90, 92, 4);

        TextView view = getActivity().findViewById(R.id.engines_value_0);
        view.setText(formatDecimals(engines[0]));

        view = getActivity().findViewById(R.id.engines_value_1);
        view.setText(formatDecimals(engines[1]));

        view = getActivity().findViewById(R.id.tyres_value_fl);
        view.setText(formatDecimals(tyres[0]));

        view = getActivity().findViewById(R.id.tyres_value_fr);
        view.setText(formatDecimals(tyres[1]));

        view = getActivity().findViewById(R.id.tyres_value_rl);
        view.setText(formatDecimals(tyres[2]));

        view = getActivity().findViewById(R.id.tyres_value_rr);
        view.setText(formatDecimals(tyres[3]));
    }
}
