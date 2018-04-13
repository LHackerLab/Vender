package hacker.l.venderapp.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import hacker.l.venderapp.R;
import hacker.l.venderapp.activity.DashboardActivity;
import hacker.l.venderapp.adapter.MyBidAdapter;
import hacker.l.venderapp.models.Result;


public class MyBidsFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public static MyBidsFragment newInstance(String param1, String param2) {
        MyBidsFragment fragment = new MyBidsFragment();
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
    RecyclerView recyclerView;
    EditText edt_city;
    LinearLayout laout_clear;
    Result result;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        context = getActivity();
        view = inflater.inflate(R.layout.fragment_my_bids, container, false);
        init();
        return view;
    }

    private void init() {
        DashboardActivity dashboardActivity = (DashboardActivity) context;
        dashboardActivity.setTitle("My Bids");
        dashboardActivity.addCity(false);
        dashboardActivity.setInfo(false);
        dashboardActivity.setHelp(false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recycleView);
        laout_clear = (LinearLayout) view.findViewById(R.id.laout_clear);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        laout_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edt_city.setText("");
            }
        });
        getActivity().getWindow().setSoftInputMode(WindowManager.
                LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        List<Result> resultList = getList();
        MyBidAdapter adapter = new MyBidAdapter(context, resultList);
        recyclerView.setAdapter(adapter);
    }

    private List<Result> getList() {
        List<Result> resultList = new ArrayList<>();
        result = new Result();
        result.setTripType("One Way Trip");
        result.setCabName("Suv");
        result.setDate("4 Aug");
        result.setTripName("Delhi To Bareilly");
        result.setCabtype("Bhatia Cab Premium");
        result.setTime("11:30AM");
        result.setPrice("11000");
        resultList.add(result);
        result = new Result();
        result.setTripType("Two Way Trip");
        result.setCabName("SEDAN");
        result.setDate("14 Aug");
        result.setTripName("Bareilly to Delhi");
        result.setCabtype("Bhatia Cab COMFORT");
        result.setTime("11:30AM");
        result.setPrice("3000");
        resultList.add(result);
        result = new Result();
        result.setTripType("One Way Trip");
        result.setDistance("140");
        result.setCabName("Suv");
        result.setDate("4 Aug");
        result.setTripName("Delhi To Bareilly");
        result.setCabtype("Bhatia Cab Premium");
        result.setTime("11:30AM");
        result.setPrice("4000");
        resultList.add(result);
        result = new Result();
        result.setTripType("Two Way Trip");
        result.setDistance("170");
        result.setCabName("SEDAN");
        result.setDate("14 Aug");
        result.setTripName("Bareilly to Delhi");
        result.setCabtype("Bhatia Cab COMFORT");
        result.setTime("11:30AM");
        result.setPrice("11000");
        resultList.add(result);
        result = new Result();
        result.setTripType("One Way Trip");
        result.setDistance("160");
        result.setCabName("Suv");
        result.setDate("4 Aug");
        result.setTripName("Delhi To Bareilly");
        result.setCabtype("Bhatia Cab Premium");
        result.setTime("11:30AM");
        result.setPrice("3090");
        resultList.add(result);
        result = new Result();
        result.setTripType("Two Way Trip");
        result.setDistance("170");
        result.setCabName("SEDAN");
        result.setDate("14 Aug");
        result.setTripName("Bareilly to Delhi");
        result.setCabtype("Bhatia Cab COMFORT");
        result.setTime("11:30AM");
        result.setPrice("2200");
        resultList.add(result);
        result = new Result();
        result.setTripType("One Way Trip");
        result.setDistance("100");
        result.setCabName("Suv");
        result.setDate("4 Aug");
        result.setTripName("Delhi To Bareilly");
        result.setCabtype("Bhatia Cab Premium");
        result.setTime("11:30AM");
        result.setPrice("23450");
        resultList.add(result);
        result = new Result();
        result.setTripType("Two Way Trip");
        result.setDistance("110");
        result.setCabName("SEDAN");
        result.setDate("14 Aug");
        result.setTripName("Bareilly to Delhi");
        result.setCabtype("Bhatia Cab COMFORT");
        result.setTime("11:30AM");
        result.setPrice("23411");
        resultList.add(result);
        return resultList;

    }

}
