package hacker.l.venderapp.fragments;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import hacker.l.venderapp.R;
import hacker.l.venderapp.adapter.OpenBookingAdapter;
import hacker.l.venderapp.models.Result;
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
    RecyclerView recycleView;

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
        recycleView = (RecyclerView) view.findViewById(R.id.recycleView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
        recycleView.setLayoutManager(linearLayoutManager);
        List<Result> resultList = getAllOpenBookDataList();
        OpenBookingAdapter openBookingAdapter = new OpenBookingAdapter(context, resultList);
        recycleView.setAdapter(openBookingAdapter);

    }

    private List<Result> getAllOpenBookDataList() {
        List<Result> resultList = new ArrayList<>();
        Result result = new Result();
        result.setTripType("One Way Trip");
        result.setDistance("140");
        result.setCabName("Suv");
        result.setDate("4 Aug");
        result.setTripName("Delhi To Bareilly");
        result.setCabtype("Bhatia Cab Premium");
        result.setTime("11:30AM");
        resultList.add(result);
        result.setTripType("Two Way Trip");
        result.setDistance("170");
        result.setCabName("SEDAN");
        result.setDate("14 Aug");
        result.setTripName("Bareilly to Delhi");
        result.setCabtype("Bhatia Cab COMFORT");
        result.setTime("11:30AM");
        resultList.add(result);
        result.setTripType("One Way Trip");
        result.setDistance("140");
        result.setCabName("Suv");
        result.setDate("4 Aug");
        result.setTripName("Delhi To Bareilly");
        result.setCabtype("Bhatia Cab Premium");
        result.setTime("11:30AM");
        resultList.add(result);
        result.setTripType("Two Way Trip");
        result.setDistance("170");
        result.setCabName("SEDAN");
        result.setDate("14 Aug");
        result.setTripName("Bareilly to Delhi");
        result.setCabtype("Bhatia Cab COMFORT");
        result.setTime("11:30AM");
        resultList.add(result);
        result.setTripType("One Way Trip");
        result.setDistance("160");
        result.setCabName("Suv");
        result.setDate("4 Aug");
        result.setTripName("Delhi To Bareilly");
        result.setCabtype("Bhatia Cab Premium");
        result.setTime("11:30AM");
        resultList.add(result);
        result.setTripType("Two Way Trip");
        result.setDistance("170");
        result.setCabName("SEDAN");
        result.setDate("14 Aug");
        result.setTripName("Bareilly to Delhi");
        result.setCabtype("Bhatia Cab COMFORT");
        result.setTime("11:30AM");
        resultList.add(result);
        result.setTripType("One Way Trip");
        result.setDistance("100");
        result.setCabName("Suv");
        result.setDate("4 Aug");
        result.setTripName("Delhi To Bareilly");
        result.setCabtype("Bhatia Cab Premium");
        result.setTime("11:30AM");
        resultList.add(result);
        result.setTripType("Two Way Trip");
        result.setDistance("110");
        result.setCabName("SEDAN");
        result.setDate("14 Aug");
        result.setTripName("Bareilly to Delhi");
        result.setCabtype("Bhatia Cab COMFORT");
        result.setTime("11:30AM");
        resultList.add(result);
        return resultList;

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
