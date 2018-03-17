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

package it.raceup.raceapp.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import it.raceup.raceapp.R;
import it.raceup.raceapp.fragment.RealTimeTelemetryTemperaturesFragment;
import it.raceup.raceapp.fragment.RealTimeTelemetryThrottleFragment;
import it.raceup.raceapp.fragment.RealTimeTelemetryTyresFragment;

/**
 * Pager for RealTimeTelemetry activity
 */
public class RealTimeTelemetryPagerAdapter extends FragmentPagerAdapter {
    private Context context;

    public RealTimeTelemetryPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new RealTimeTelemetryTyresFragment();
        } else if (position == 1) {
            return new RealTimeTelemetryThrottleFragment();
        } else {
            return new RealTimeTelemetryTemperaturesFragment();
        }
    }

    @Override
    public int getCount() {
        // number of pages
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return context.getString(R.string.real_time_telemetry_fragment_tyres);
            case 1:
                return context.getString(R.string.real_time_telemetry_fragment_throttle);
            case 2:
                return context.getString(R.string.real_time_telemetry_fragment_temperatures);
        }
        return null;
    }
}