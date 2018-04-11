package hacker.l.venderapp.fragments;

import android.app.Dialog;
import android.content.Context;
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
import hacker.l.venderapp.adapter.TaxisAdapter;
import hacker.l.venderapp.models.Result;

public class MyAllTasixFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public static MyAllTasixFragment newInstance(String param1, String param2) {
        MyAllTasixFragment fragment = new MyAllTasixFragment();
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
        view = inflater.inflate(R.layout.fragment_my_all_taxis, container, false);
        init();
        return view;
    }

    private void init() {
        DashboardActivity dashboardActivity = (DashboardActivity) context;
        dashboardActivity.setTitle("My Taxis");
        dashboardActivity.addCity(true);
        dashboardActivity.setInfo(false);
        dashboardActivity.setHelp(true);
        dashboardActivity.tv_addCity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddTaxisFragment fragment = AddTaxisFragment.newInstance("", "");
                moveFragment(fragment);
            }
        });
        dashboardActivity.tv_help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPoPUp();
            }
        });
        recycleView = (RecyclerView) view.findViewById(R.id.recycleView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
        recycleView.setLayoutManager(linearLayoutManager);
        List<Result> resultList = getAvailablityList();
        TaxisAdapter adapter = new TaxisAdapter(context, resultList);
        recycleView.setAdapter(adapter);
    }

    private List<Result> getAvailablityList() {
        List<Result> resultList = new ArrayList<>();
        result = new Result();
        result.setCabName("Maruti");
        result.setCarNumber("Up25Bt4590");
        result.setCarModel("2016");
        result.setCabtype("maruti(Business");
        result.setRs("10");
        resultList.add(result);
        result = new Result();
        result.setCabName("TaTa");
        result.setCarNumber("Up25Bt4590");
        result.setCarModel("2010");
        result.setCabtype("maruti(Business");
        result.setRs("10");
        resultList.add(result);
        result = new Result();
        result.setCabName("Maruti");
        result.setCarNumber("Up25Bt4590");
        result.setCarModel("2016");
        result.setCabtype("maruti(Business");
        result.setRs("10");
        resultList.add(result);
        result = new Result();
        result.setCabName("TaTa");
        result.setCarNumber("Up25Bt4590");
        result.setCarModel("2010");
        result.setCabtype("maruti(Business");
        result.setRs("10");
        resultList.add(result);
        result = new Result();
        result.setCabName("Maruti");
        result.setCarNumber("Up25Bt4590");
        result.setCarModel("2016");
        result.setCabtype("maruti(Business");
        result.setRs("10");
        resultList.add(result);
        result = new Result();
        result.setCabName("TaTa");
        result.setCarNumber("Up25Bt4590");
        result.setCarModel("2010");
        result.setCabtype("maruti(Business");
        result.setRs("10");
        resultList.add(result);
        return resultList;
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
        tv_header.setText("My Taxis");
        tv_body.setText("This Feature will help you add taxis");
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
}
