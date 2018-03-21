package hacker.l.venderapp.fragments;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import hacker.l.venderapp.R;
import hacker.l.venderapp.utilities.FontManager;


public class OpenBookingFragment extends Fragment implements View.OnClickListener {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public static OpenBookingFragment newInstance(String param1, String param2) {
        OpenBookingFragment fragment = new OpenBookingFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    View view;
    Context context;
    TextView tv_freeCars, tv_account, tv_drivres, tv_myCabs, tv_addcabs, tv_addDrivrs, tv_triphistory, profile, tv_trip, tv_accept;
    LinearLayout layout_accept, layout_trip, layout_profile, layout_triphistory, layout_adddriver, layout_addcabs, layout_mycabs,
            layout_mydrivers, layout_myaccount, layout_freecars;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        context = getActivity();
        view = inflater.inflate(R.layout.fragment_open_booking, container, false);
        init();
        return view;
    }

    private void init() {
        Typeface nova = FontManager.getFontTypeface(context, "fonts/ProximaNova-Regular.otf");
        layout_accept = (LinearLayout) view.findViewById(R.id.layout_accept);
        layout_trip = (LinearLayout) view.findViewById(R.id.layout_trip);
        layout_profile = (LinearLayout) view.findViewById(R.id.layout_profile);
        layout_triphistory = (LinearLayout) view.findViewById(R.id.layout_triphistory);
        layout_adddriver = (LinearLayout) view.findViewById(R.id.layout_adddriver);
        layout_addcabs = (LinearLayout) view.findViewById(R.id.layout_addcabs);
        layout_mycabs = (LinearLayout) view.findViewById(R.id.layout_mycabs);
        layout_mydrivers = (LinearLayout) view.findViewById(R.id.layout_mydrivers);
        layout_myaccount = (LinearLayout) view.findViewById(R.id.layout_myaccount);
        layout_freecars = (LinearLayout) view.findViewById(R.id.layout_freecars);
        tv_freeCars = (TextView) view.findViewById(R.id.tv_freeCars);
        tv_account = (TextView) view.findViewById(R.id.tv_account);
        tv_drivres = (TextView) view.findViewById(R.id.tv_drivres);
        tv_myCabs = (TextView) view.findViewById(R.id.tv_myCabs);
        tv_addcabs = (TextView) view.findViewById(R.id.tv_addcabs);
        tv_addDrivrs = (TextView) view.findViewById(R.id.tv_addDrivrs);
        tv_triphistory = (TextView) view.findViewById(R.id.tv_triphistory);
        profile = (TextView) view.findViewById(R.id.tv_profile);
        tv_trip = (TextView) view.findViewById(R.id.tv_trip);
        tv_accept = (TextView) view.findViewById(R.id.tv_accept);
        tv_freeCars.setTypeface(nova);
        tv_account.setTypeface(nova);
        tv_drivres.setTypeface(nova);
        tv_myCabs.setTypeface(nova);
        tv_addcabs.setTypeface(nova);
        tv_addDrivrs.setTypeface(nova);
        tv_triphistory.setTypeface(nova);
        profile.setTypeface(nova);
        tv_trip.setTypeface(nova);
        tv_accept.setTypeface(nova);
        setOnclick();
    }

    private void setOnclick() {
        layout_accept.setOnClickListener(this);
        layout_trip.setOnClickListener(this);
        layout_profile.setOnClickListener(this);
        layout_triphistory.setOnClickListener(this);
        layout_adddriver.setOnClickListener(this);
        layout_addcabs.setOnClickListener(this);
        layout_mycabs.setOnClickListener(this);
        layout_mydrivers.setOnClickListener(this);
        layout_myaccount.setOnClickListener(this);
        layout_freecars.setOnClickListener(this);
    }

    private void moveFragment(Fragment fragment) {
        FragmentManager fragmentManager = ((FragmentActivity) context).getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.container, fragment)
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
        }
    }
}
