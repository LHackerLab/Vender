package hacker.l.venderapp.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import hacker.l.venderapp.R;
import hacker.l.venderapp.activity.DashboardActivity;
import hacker.l.venderapp.adapter.AvailabilityAdapter;
import hacker.l.venderapp.adapter.TripManagerAdapter;
import hacker.l.venderapp.models.Result;

public class TripManagerFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public static TripManagerFragment newInstance(String param1, String param2) {
        TripManagerFragment fragment = new TripManagerFragment();
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
    Result result;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        context = getActivity();
        view = inflater.inflate(R.layout.fragment_trip_manager, container, false);
        init();
        return view;
    }

    private void init() {
        DashboardActivity dashboardActivity = (DashboardActivity) context;
        dashboardActivity.setTitle("Trip Manager");
        dashboardActivity.addCity(false);
        recycleView = (RecyclerView) view.findViewById(R.id.recycleView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
        recycleView.setLayoutManager(linearLayoutManager);
        List<Result> resultList = getList();
        TripManagerAdapter adapter = new TripManagerAdapter(context, resultList);
        recycleView.setAdapter(adapter);
    }

    private List<Result> getList() {
        List<Result> resultList = new ArrayList<>();
        result = new Result();
        result.setName("Lalit Singh");
        result.setPhone("9917218408");
        resultList.add(result);
        result = new Result();
        result.setName("Bilal");
        result.setPhone("9917218408");
        resultList.add(result);
        result = new Result();
        result.setName("Krishna Singh");
        result.setPhone("9917218408");
        resultList.add(result);
        result = new Result();
        result.setName("Ankit");
        result.setPhone("9917218408");
        resultList.add(result);
        return resultList;
    }
}
