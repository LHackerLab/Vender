package hacker.l.venderapp.fragments;

import android.app.Dialog;
import android.content.Context;
import android.net.Uri;
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
import hacker.l.venderapp.adapter.DriversAdapter;
import hacker.l.venderapp.adapter.TaxisAdapter;
import hacker.l.venderapp.models.Result;

public class MyDriversFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public static hacker.l.venderapp.fragments.MyDriversFragment newInstance(String param1, String param2) {
        hacker.l.venderapp.fragments.MyDriversFragment fragment = new hacker.l.venderapp.fragments.MyDriversFragment();
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
        view = inflater.inflate(R.layout.fragment_my_drivers, container, false);
        init();
        return view;
    }

    private void init() {
        DashboardActivity dashboardActivity = (DashboardActivity) context;
        dashboardActivity.setTitle("My Drivers");
        dashboardActivity.addCity(true);
        dashboardActivity.setInfo(false);
        dashboardActivity.setHelp(true);
        dashboardActivity.tv_addCity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddDriverFragment fragment = AddDriverFragment.newInstance("", "");
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
        List<Result> resultList = getList();
        DriversAdapter adapter = new DriversAdapter(context, resultList);
        recycleView.setAdapter(adapter);
    }

    private List<Result> getList() {
        List<Result> resultList = new ArrayList<>();
        result = new Result();
        result.setName("Ankit");
        result.setPhone("9917218408");
        result.setDlNumber("3497234907234");
        result.setDlExpirDate("2019/09/11");
        result.setStatus("This driver not activer");
        resultList.add(result);
        result = new Result();
        result.setName("Singh");
        result.setPhone("56845345693");
        result.setDlNumber("3497234907234");
        result.setDlExpirDate("2019/09/16");
        result.setStatus("This driver activer");
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
        tv_header.setText("My Drivers");
        tv_body.setText("This Feature will help you add Drives");
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
