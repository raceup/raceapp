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

package it.raceup.raceapp.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import it.raceup.raceapp.R;
import it.raceup.raceapp.dialog.AboutDialog;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            openSettingsActivity();
        }

        return super.onOptionsItemSelected(item);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_real_time) {
            Drawable alert = getDrawable(R.drawable.ic_alert_octagram_black_24dp);  // todo color
            item.setIcon(alert);
            openRealTimeTelemetryActivity();
        } else if (id == R.id.nav_community) {
            openCommunityActivity();
        } else if (id == R.id.nav_profile) {
            openProfileActivity();
        } else if (id == R.id.nav_training) {
            openTrainingActivity();
        } else if (id == R.id.nav_webpage) {
            openWebpage("http://www.raceup.it");
        } else if (id == R.id.nav_manage) {
            openSettingsActivity();
        } else if (id == R.id.nav_share) {
            openShareActivity();
        } else if (id == R.id.nav_about) {
            openAboutDialog();
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void openRealTimeTelemetryActivity() {
        openActivityByClass(RealTimeTelemetryActivity.class);
    }

    private void openCommunityActivity() {
        openActivityByClass(CommunityActivity.class);
    }

    private void openProfileActivity() {
        openActivityByClass(ProfileActivity.class);
    }

    private void openTrainingActivity() {
        openActivityByClass(TrainingActivity.class);
    }

    private void openWebpage(String url) {
        Intent openActivity = new Intent(
                "android.intent.action.VIEW",
                Uri.parse(url)
        );
        startActivity(openActivity);
    }

    private void openSettingsActivity() {
        openActivityByClass(SettingsActivity.class);
    }

    private void openShareActivity() {
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, "Hey! Have you checked out the official Race UP android app?" +
                "Download it from here: https://github.com/raceup/raceapp/blob/master/app/build/outputs/apk/app-debug.apk?raw=true");
        sendIntent.setType("text/plain");
        startActivity(sendIntent);
    }

    public void openActivityByClass(Class activityClass) {
        Intent openActivity = new Intent(MainActivity.this, activityClass);
        startActivity(openActivity);
    }

    private void openAboutDialog() {
        LayoutInflater inflater = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        try {
            assert inflater != null;
            View aboutDialogView = inflater.inflate(R.layout.about_dialog, null);
            TextView infoText = aboutDialogView.findViewById(R.id.info_text_about_dialog);
            infoText.setText(
                    Html.fromHtml(
                            "<h3>" +
                                    "RaceApp: the official Race UP android app to build your racing car" +
                                    "</h3>\n" +
                                    "<i>Build. Invite friends. Challenge them.</i><br>\n" +
                                    "Version 0.0.1<br>\n" +
                                    "Copyright (C) 2018<br>\n" +
                                    "<b>Race UP</b><br><br>\n" +
                                    "info@raceup.it"
                    )
            );

            // set legal text
            TextView legalText = aboutDialogView.findViewById(R.id.legal_text_about_dialog);
            legalText.setText(Html.fromHtml(
                    "Copyright (C) Race UP Electric Division 2018. <b>All rights reserved.</b>\n" +
                            "Unauthorized copying of this file, via any medium is strictly prohibited."));
            AboutDialog dialog = new AboutDialog(MainActivity.this, "", aboutDialogView);
            dialog.show();
        } catch (Exception e) {
            // todo get current view showToastMessage("Ooops! Cannot open the about dialog!");
        }
    }

    private void showToastMessage(View view, String message) {
        Snackbar.make(view, message, Snackbar.LENGTH_LONG).setAction("Action", null).show();
    }
}
