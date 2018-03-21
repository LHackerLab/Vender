package hacker.l.venderapp.activity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.TextView;

import hacker.l.venderapp.R;
import hacker.l.venderapp.fragments.HomeFragment;
import hacker.l.venderapp.utilities.FontManager;

public class DashboardActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {
    TextView tv_information,tv_tripmanager,tv_settings,tv_drivres,tv_taxi,tv_city,tv_account,tv_toturial,tv_completeTrip,
            tv_avality,tv_bids,tv_booking,tv_opnebooking;
    LinearLayout layout_information ,layout_tripmanager,layout_settings,layout_driverList,layout_taxi,layout_city,
            layout_completeTrip,layout_account,layout_toturial,layout_avality,layout_vids,layout_booking,layout_opnebooking;
    DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        init();
    }

    private void init() {
        Typeface nova = FontManager.getFontTypeface(this, "fonts/ProximaNova-Regular.otf");
        layout_information = (LinearLayout) findViewById(R.id.layout_information);
        layout_tripmanager = (LinearLayout) findViewById(R.id.layout_tripmanager);
        layout_settings = (LinearLayout) findViewById(R.id.layout_settings);
        layout_driverList = (LinearLayout) findViewById(R.id.layout_driverList);
        layout_taxi = (LinearLayout) findViewById(R.id.layout_taxi);
        layout_driverList = (LinearLayout) findViewById(R.id.layout_driverList);
        layout_city = (LinearLayout) findViewById(R.id.layout_city);
        layout_account = (LinearLayout) findViewById(R.id.layout_account);
        layout_toturial = (LinearLayout) findViewById(R.id.layout_toturial);
        layout_avality = (LinearLayout) findViewById(R.id.layout_avality);
        layout_completeTrip = (LinearLayout) findViewById(R.id.layout_completeTrip);
        layout_vids = (LinearLayout) findViewById(R.id.layout_vids);
        layout_booking = (LinearLayout) findViewById(R.id.layout_booking);
        layout_opnebooking = (LinearLayout) findViewById(R.id.layout_opnebooking);
        tv_information = (TextView) findViewById(R.id.tv_information);
        tv_tripmanager = (TextView) findViewById(R.id.tv_tripmanager);
        tv_settings = (TextView) findViewById(R.id.tv_settings);
        tv_drivres = (TextView) findViewById(R.id.tv_drivres);
        tv_taxi = (TextView) findViewById(R.id.tv_taxi);
        tv_city = (TextView) findViewById(R.id.tv_city);
        tv_account = (TextView) findViewById(R.id.tv_account);
        tv_toturial = (TextView) findViewById(R.id.tv_toturial);
        tv_completeTrip = (TextView) findViewById(R.id.tv_completeTrip);
        tv_avality = (TextView) findViewById(R.id.tv_avality);
        tv_bids = (TextView) findViewById(R.id.tv_bids);
        tv_booking = (TextView) findViewById(R.id.tv_booking);
        tv_opnebooking = (TextView) findViewById(R.id.tv_opnebooking);
        tv_information.setTypeface(nova);
        tv_tripmanager.setTypeface(nova);
        tv_settings.setTypeface(nova);
        tv_drivres.setTypeface(nova);
        tv_taxi.setTypeface(nova);
        tv_city.setTypeface(nova);
        tv_account.setTypeface(nova);
        tv_toturial.setTypeface(nova);
        tv_completeTrip.setTypeface(nova);
        tv_avality.setTypeface(nova);
        tv_bids.setTypeface(nova);
        tv_booking.setTypeface(nova);
        tv_opnebooking.setTypeface(nova);
        setOnclick();
        HomeFragment homeFragment = HomeFragment.newInstance("", "");
        moveFragment(homeFragment);
    }

    private void setOnclick() {
        layout_information.setOnClickListener(this);
        layout_tripmanager.setOnClickListener(this);
        layout_settings.setOnClickListener(this);
        layout_driverList.setOnClickListener(this);
        layout_taxi.setOnClickListener(this);
        layout_city.setOnClickListener(this);
        layout_account.setOnClickListener(this);
        layout_toturial.setOnClickListener(this);
        layout_completeTrip.setOnClickListener(this);
        layout_avality.setOnClickListener(this);
        layout_vids.setOnClickListener(this);
        layout_booking.setOnClickListener(this);
        layout_opnebooking.setOnClickListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.dashboard, menu);
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
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

//        if (id == R.id.nav_camera) {
//            // Handle the camera action
//        } else if (id == R.id.nav_gallery) {
//
//        } else if (id == R.id.nav_slideshow) {
//
//        } else if (id == R.id.nav_manage) {
//
//        } else if (id == R.id.nav_share) {
//
//        } else if (id == R.id.nav_send) {
//
//        }

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    //hide navigation view
    public void navHide() {
        drawer.closeDrawer(GravityCompat.START);
    }


    private void moveFragment(Fragment fragment) {
        FragmentManager fragmentManager = ((FragmentActivity) this).getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.container, fragment)
                //.addToBackStack(null)
                .commit();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.layout_information:
                HomeFragment homeFragment = HomeFragment.newInstance("", "");
                moveFragment(homeFragment);
                navHide();
                break;
        }
    }
}
