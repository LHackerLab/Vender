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
    TextView tv_help, tv_about, tv_changepass, tv_serviceZone, tv_vehicle, tv_driverslist, tv_home;
    LinearLayout layout_help, layout_about, layout_chagepass, layout_servicezone, layout_vehiclelist, layout_driverList, layout_home;
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
        layout_help = (LinearLayout) findViewById(R.id.layout_help);
        layout_about = (LinearLayout) findViewById(R.id.layout_about);
        layout_chagepass = (LinearLayout) findViewById(R.id.layout_chagepass);
        layout_servicezone = (LinearLayout) findViewById(R.id.layout_servicezone);
        layout_vehiclelist = (LinearLayout) findViewById(R.id.layout_vehiclelist);
        layout_driverList = (LinearLayout) findViewById(R.id.layout_driverList);
        layout_home = (LinearLayout) findViewById(R.id.layout_home);
        tv_help = (TextView) findViewById(R.id.tv_help);
        tv_about = (TextView) findViewById(R.id.tv_about);
        tv_changepass = (TextView) findViewById(R.id.tv_changepass);
        tv_serviceZone = (TextView) findViewById(R.id.tv_serviceZone);
        tv_vehicle = (TextView) findViewById(R.id.tv_vehicle);
        tv_driverslist = (TextView) findViewById(R.id.tv_driverslist);
        tv_home = (TextView) findViewById(R.id.tv_home);
        tv_help.setTypeface(nova);
        tv_about.setTypeface(nova);
        tv_changepass.setTypeface(nova);
        tv_serviceZone.setTypeface(nova);
        tv_vehicle.setTypeface(nova);
        tv_driverslist.setTypeface(nova);
        tv_home.setTypeface(nova);
        setOnclick();
        HomeFragment homeFragment = HomeFragment.newInstance("", "");
        moveFragment(homeFragment);
    }

    private void setOnclick() {
        layout_help.setOnClickListener(this);
        layout_about.setOnClickListener(this);
        layout_chagepass.setOnClickListener(this);
        layout_servicezone.setOnClickListener(this);
        layout_vehiclelist.setOnClickListener(this);
        layout_driverList.setOnClickListener(this);
        layout_home.setOnClickListener(this);
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

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

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
            case R.id.layout_home:
                HomeFragment homeFragment = HomeFragment.newInstance("", "");
                moveFragment(homeFragment);
                navHide();
                break;
        }
    }
}
