package hacker.l.venderapp.fragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import hacker.l.venderapp.R;
import hacker.l.venderapp.activity.DashboardActivity;

public class TutorialsFragment extends Fragment implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public static TutorialsFragment newInstance(String param1, String param2) {
        TutorialsFragment fragment = new TutorialsFragment();
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
    ImageView image_availity, image_cities, image_account, image_assigned, image_bid;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        context = getActivity();
        view = inflater.inflate(R.layout.fragment_tutorials, container, false);
        init();
        return view;
    }

    private void init() {
        DashboardActivity dashboardActivity = (DashboardActivity) context;
        dashboardActivity.setTitle("Tutorials");
        dashboardActivity.addCity(false);
        image_availity = (ImageView) view.findViewById(R.id.image_availity);
        image_cities = (ImageView) view.findViewById(R.id.image_cities);
        image_account = (ImageView) view.findViewById(R.id.image_account);
        image_assigned = (ImageView) view.findViewById(R.id.image_assigned);
        image_bid = (ImageView) view.findViewById(R.id.image_bid);
        image_availity.setOnClickListener(this);
        image_cities.setOnClickListener(this);
        image_account.setOnClickListener(this);
        image_assigned.setOnClickListener(this);
        image_bid.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.image_bid:
                openYoutube();
                break;
            case R.id.image_cities:
                openYoutube();
                break;
            case R.id.image_account:
                openYoutube();
                break;
            case R.id.image_assigned:
                openYoutube();
                break;
            case R.id.image_availity:
                openYoutube();
                break;
        }
    }

    void openYoutube() {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("https://www.youtube.com/watch?v=cOi2OpFcDlQ"));
        intent.setPackage("com.google.android.youtube");
        startActivity(intent);
    }
}
