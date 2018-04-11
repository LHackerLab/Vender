package hacker.l.venderapp.fragments;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import hacker.l.venderapp.R;
import hacker.l.venderapp.activity.DashboardActivity;
import hacker.l.venderapp.adapter.AvailabilityAdapter;
import hacker.l.venderapp.adapter.MyCitiesAdapter;
import hacker.l.venderapp.models.Result;

public class MyCitiesFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public static MyCitiesFragment newInstance(String param1, String param2) {
        MyCitiesFragment fragment = new MyCitiesFragment();
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
        view = inflater.inflate(R.layout.fragment_my_cities, container, false);
        init();
        return view;
    }

    private void init() {
        DashboardActivity dashboardActivity = (DashboardActivity) context;
        dashboardActivity.setTitle("My Cities");
        dashboardActivity.addCity(true);
        dashboardActivity.setInfo(true);
        dashboardActivity.setHelp(true);
        recycleView = (RecyclerView) view.findViewById(R.id.recycleView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
        recycleView.setLayoutManager(linearLayoutManager);
        List<Result> resultList = getList();
        MyCitiesAdapter adapter = new MyCitiesAdapter(context, resultList);
        recycleView.setAdapter(adapter);
        dashboardActivity.tv_addCity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddCityFragment fragment = AddCityFragment.newInstance("", "");
                moveFragment(fragment);
            }
        });
        dashboardActivity.tv_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SuggestCityFragment fragment = SuggestCityFragment.newInstance("", "");
                moveFragment(fragment);
            }
        });
        dashboardActivity.tv_help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPoPUp();
            }
        });
    }

    private void showPoPUp() {
        final Dialog dialog = new Dialog(context);
        dialog.setContentView(R.layout.custom_assigning_dialog);
        dialog.show();
        dialog.setCanceledOnTouchOutside(true);
        dialog.setCancelable(true);
        dialog.setCanceledOnTouchOutside(true);
        Window window = dialog.getWindow();
        window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        TextView tv_close = (TextView) dialog.findViewById(R.id.tv_close);
        TextView tv_header = (TextView) dialog.findViewById(R.id.tv_header);
        TextView tv_body = (TextView) dialog.findViewById(R.id.tv_body);
        tv_header.setText("My Cities");
        tv_body.setText("This Feature will help you to get more and more booking on your dashboard by adding more and more cities.");
        tv_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

    }

    private void moveFragment(Fragment fragment) {
        FragmentManager fragmentManager = ((FragmentActivity) context).getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.container, fragment)
                .addToBackStack(null)
                .commit();
    }

    private List<Result> getList() {
        List<Result> resultList = new ArrayList<>();
        result = new Result();
        result.setCityName("Bareilly");
        resultList.add(result);
        result = new Result();
        result.setCityName("Pilibhit");
        resultList.add(result);
        result = new Result();
        result.setCityName("Moradabad");
        resultList.add(result);
        result = new Result();
        result.setCityName("Solapur");
        resultList.add(result);
        result = new Result();
        result.setCityName("Ranchi");
        resultList.add(result);
        result = new Result();
        result.setCityName("Gwalior");
        resultList.add(result);
        result = new Result();
        result.setCityName("Aurangabad");
        resultList.add(result);
        result = new Result();
        result.setCityName("Amritsar");
        resultList.add(result);
        result = new Result();
        result.setCityName("Nashik");
        resultList.add(result);
        result = new Result();
        result.setCityName("Ludhiana");
        resultList.add(result);
        result = new Result();
        result.setCityName("Agra");
        resultList.add(result);
        result = new Result();
        result.setCityName("Ghaziabad");
        resultList.add(result);
        result = new Result();
        result.setCityName("Vadodara");
        resultList.add(result);
        result = new Result();
        result.setCityName("Patna");
        resultList.add(result);
        result = new Result();
        result.setCityName("Bhopal");
        resultList.add(result);
        result = new Result();
        result.setCityName("Thane");
        resultList.add(result);
        result = new Result();
        result.setCityName("Indore");
        resultList.add(result);
        result = new Result();
        result.setCityName("Nagpur");
        resultList.add(result);
        result = new Result();
        result.setCityName("Kanpur");
        resultList.add(result);
        result = new Result();
        result.setCityName("Lucknow");
        resultList.add(result);
        result = new Result();
        result.setCityName("Jaipur");
        resultList.add(result);
        result = new Result();
        result.setCityName("Pune");
        resultList.add(result);
        result = new Result();
        result.setCityName("Surat");
        resultList.add(result);
        result = new Result();
        result.setCityName("Kolkata");
        resultList.add(result);
        result = new Result();
        result.setCityName("Chennai");
        resultList.add(result);
        result = new Result();
        result.setCityName("Ahmedabad");
        resultList.add(result);
        result = new Result();
        result.setCityName("Hyderabad");
        resultList.add(result);
        result = new Result();
        result.setCityName("Bangalore");
        resultList.add(result);
        result = new Result();
        result.setCityName("Delhi");
        resultList.add(result);
        result = new Result();
        result.setCityName("Mumbai");
        resultList.add(result);
        return resultList;
    }
}
