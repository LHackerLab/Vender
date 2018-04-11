package hacker.l.venderapp.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.MotionEvent;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import hacker.l.venderapp.R;
import hacker.l.venderapp.database.DbHelper;
import hacker.l.venderapp.fragments.AssignedBookingFragment;
import hacker.l.venderapp.fragments.AvaillabilityFragment;
import hacker.l.venderapp.fragments.CompletedTripFragment;
import hacker.l.venderapp.fragments.InformationFragment;
import hacker.l.venderapp.fragments.MyAccountFragment;
import hacker.l.venderapp.fragments.MyAllTasixFragment;
import hacker.l.venderapp.fragments.MyBidsFragment;
import hacker.l.venderapp.fragments.MyCitiesFragment;
import hacker.l.venderapp.fragments.MyDriversFragment;
import hacker.l.venderapp.fragments.OpenBookingFragment;
import hacker.l.venderapp.fragments.SettingsFragment;
import hacker.l.venderapp.fragments.TripManagerFragment;
import hacker.l.venderapp.fragments.TutorialsFragment;
import hacker.l.venderapp.utilities.FontManager;

public class DashboardActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {
    public TextView tv_information, tv_tripmanager, tv_addCity, tv_settings, tv_drivres, tv_taxi, tv_city, tv_account, tv_toturial, tv_completeTrip,
            tv_avality, tv_bids, tv_booking, tv_opnebooking, tv_title, tv_info,tv_help;
    LinearLayout layout_information, layout_tripmanager, layout_settings, layout_driverList, layout_taxi, layout_city,
            layout_completeTrip, layout_account, layout_toturial, layout_avality, layout_vids, layout_booking, layout_opnebooking;
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
        tv_title = (TextView) findViewById(R.id.tv_title);
        tv_addCity = (TextView) findViewById(R.id.tv_addCity);
        tv_info = (TextView) findViewById(R.id.tv_info);
        tv_help = (TextView) findViewById(R.id.tv_help);
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
        OpenBookingFragment openBookingFragment = OpenBookingFragment.newInstance("", "");
        moveHomeFragment(openBookingFragment);
    }

    public void addCity(boolean bb) {
        if (bb) {
            tv_addCity.setVisibility(View.VISIBLE);
        } else {
            tv_addCity.setVisibility(View.GONE);
        }
    }

    public void setInfo(boolean bb) {
        if (bb) {
            tv_info.setVisibility(View.VISIBLE);
        } else {
            tv_info.setVisibility(View.GONE);
        }
    }
    public void setHelp(boolean bb) {
        if (bb) {
            tv_help.setVisibility(View.VISIBLE);
        } else {
            tv_help.setVisibility(View.GONE);
        }
    }

    public void setTitle(String title) {
        tv_title.setText(title);
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
                .addToBackStack(null)
                .commit();
    }

    private void moveHomeFragment(Fragment fragment) {
        FragmentManager fragmentManager = ((FragmentActivity) this).getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.container, fragment)
//                .addToBackStack(null)
                .commit();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.layout_information:
                InformationFragment infomation = InformationFragment.newInstance("", "");
                moveFragment(infomation);
                navHide();
                break;
            case R.id.layout_tripmanager:
                TripManagerFragment tripManagerFragment = TripManagerFragment.newInstance("", "");
                moveFragment(tripManagerFragment);
                navHide();
                break;
            case R.id.layout_settings:
                SettingsFragment settingsFragment = SettingsFragment.newInstance("", "");
                moveFragment(settingsFragment);
                navHide();
                break;
            case R.id.layout_driverList:
                MyDriversFragment myDriversFragment = MyDriversFragment.newInstance("", "");
                moveFragment(myDriversFragment);
                navHide();
                break;
            case R.id.layout_taxi:
                MyAllTasixFragment myAllTasixFragment = MyAllTasixFragment.newInstance("", "");
                moveFragment(myAllTasixFragment);
                navHide();
                break;
            case R.id.layout_city:
                MyCitiesFragment myCitiesFragment = MyCitiesFragment.newInstance("", "");
                moveFragment(myCitiesFragment);
                navHide();
                break;
            case R.id.layout_account:
                MyAccountFragment myAccountFragment = MyAccountFragment.newInstance("", "");
                moveFragment(myAccountFragment);
                navHide();
                break;
            case R.id.layout_toturial:
                TutorialsFragment tutorialsFragment = TutorialsFragment.newInstance("", "");
                moveFragment(tutorialsFragment);
                navHide();
                break;
            case R.id.layout_completeTrip:
                CompletedTripFragment completedTripFragment = CompletedTripFragment.newInstance("", "");
                moveFragment(completedTripFragment);
                navHide();
                break;
            case R.id.layout_avality:
                AvaillabilityFragment availlabilityFragment = AvaillabilityFragment.newInstance("", "");
                moveFragment(availlabilityFragment);
                navHide();
                break;
            case R.id.layout_vids:
                MyBidsFragment myBidsFragment = MyBidsFragment.newInstance("", "");
                moveFragment(myBidsFragment);
                navHide();
                break;
            case R.id.layout_booking:
                AssignedBookingFragment assignedBookingFragment = AssignedBookingFragment.newInstance("", "");
                moveFragment(assignedBookingFragment);
                navHide();
                break;
            case R.id.layout_opnebooking:
                OpenBookingFragment openBookingFragment = OpenBookingFragment.newInstance("", "");
                moveFragment(openBookingFragment);
                navHide();
                break;


        }
    }

    //for hid keyboard when tab outside edittext box
    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            View v = getCurrentFocus();
            if (v instanceof EditText) {
                Rect outRect = new Rect();
                v.getGlobalVisibleRect(outRect);
                if (!outRect.contains((int) event.getRawX(), (int) event.getRawY())) {
                    v.clearFocus();
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                }
            }
        }
        return super.dispatchTouchEvent(event);
    }

    private void requestFocus(View view) {
        if (view.requestFocus()) {
            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        }
    }
}
