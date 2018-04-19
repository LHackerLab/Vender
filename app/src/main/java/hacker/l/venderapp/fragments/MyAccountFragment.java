package hacker.l.venderapp.fragments;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import hacker.l.venderapp.R;
import hacker.l.venderapp.activity.DashboardActivity;
import hacker.l.venderapp.utilities.Utility;


public class MyAccountFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public static MyAccountFragment newInstance(String param1, String param2) {
        MyAccountFragment fragment = new MyAccountFragment();
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
    Spinner spinnerMonth, spinnerYear;
    public String[] MONTHS = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        context = getActivity();
        view = inflater.inflate(R.layout.fragment_my_account, container, false);
        init();
        return view;
    }

    private void init() {
        DashboardActivity dashboardActivity = (DashboardActivity) context;
        dashboardActivity.setTitle("My Account");
        dashboardActivity.addCity(true);
        dashboardActivity.setInfo(false);
        dashboardActivity.setHelp(true);
        spinnerMonth = (Spinner) view.findViewById(R.id.spinnerMonth);
        spinnerYear = (Spinner) view.findViewById(R.id.spinnerYear);
        List<String> monthList = getMonthList();
        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(context, android.R.layout.simple_spinner_dropdown_item, monthList);
        spinnerMonth.setAdapter(stringArrayAdapter);
        List<String> yearList = getYearList();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(context, android.R.layout.simple_spinner_dropdown_item, yearList);
        spinnerYear.setAdapter(adapter);
        dashboardActivity.tv_help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPoPUp();
            }
        });
        dashboardActivity.tv_addCity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                VerifiyPaymentFragment fragment = VerifiyPaymentFragment.newInstance("", "");
                moveFragment(fragment);
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
        tv_header.setText("My Account");
        tv_body.setText("This Feature will help you to know the history of your trips and settlement amount with Bhatia Cab.");
        tv_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

    }

    private List<String> getYearList() {
        List<String> stringList = new ArrayList<>();
        stringList.add(" January");
        stringList.add(" February");
        stringList.add(" March");
        stringList.add(" April");
        stringList.add(" May");
        stringList.add(" June");
        stringList.add(" July");
        stringList.add(" August");
        stringList.add(" September");
        stringList.add(" October");
        stringList.add(" November");
        stringList.add(" December");

        return stringList;
    }

    private List<String> getMonthList() {
        List<String> stringList = new ArrayList<>();
        stringList.add("2010");
        stringList.add("2011");
        stringList.add("2012");
        stringList.add("2013");
        stringList.add("2014");
        stringList.add("2015");
        stringList.add("2016");
        stringList.add("2017");
        stringList.add("2018");
        stringList.add("2019");

        return stringList;
    }
}
