/*
 * Copyright 2018 Race UP
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

package it.raceup.raceapp.dialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;

/**
 * Show a simple about dialog about your app.
 */

public class AboutDialog {
    private AlertDialog dialog;
    private LayoutInflater inflater;
    private View view;

    public AboutDialog(Activity parentActivity, String title, int layout) {
        dialog = new AlertDialog.Builder(parentActivity).create();
        dialog.setTitle(title);
        dialog.setCanceledOnTouchOutside(true);
        setLayout(parentActivity, layout);
    }

    public AboutDialog(Activity parentActivity, String title, View view) {
        dialog = new AlertDialog.Builder(parentActivity).create();
        dialog.setTitle(title);
        dialog.setCanceledOnTouchOutside(true);
        dialog.setView(view);
    }

    private void setLayout(Activity parentActivity, int layout) {
        inflater = parentActivity.getLayoutInflater();
        view = inflater.inflate(layout, null);  // inflate
        dialog.setView(view);  // set view
    }

    public void show() {
        dialog.show();
    }
}
