package hacker.l.venderapp.fragments;

import android.app.DatePickerDialog;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import hacker.l.venderapp.R;
import hacker.l.venderapp.activity.DashboardActivity;
import hacker.l.venderapp.adapter.OpenBookingAdapter;
import hacker.l.venderapp.models.Result;
import hacker.l.venderapp.utilities.FontManager;
import hacker.l.venderapp.utilities.Utility;


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
    EditText edt_city;
    TextView tv_date;
    LinearLayout layout_date, laout_clear;
    public String[] MONTHS = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
    private String CreatedOn;
    Result result;

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
        DashboardActivity dashboardActivity = (DashboardActivity) context;
        dashboardActivity.setTitle("Open Booking");
        dashboardActivity.addCity(false);
        dashboardActivity.setInfo(false);
        dashboardActivity.setHelp(false);
        Typeface nova = FontManager.getFontTypeface(context, "fonts/ProximaNova-Regular.otf");
        recycleView = (RecyclerView) view.findViewById(R.id.recycleView);
        edt_city = (EditText) view.findViewById(R.id.edt_city);
        tv_date = (TextView) view.findViewById(R.id.tv_date);
        layout_date = (LinearLayout) view.findViewById(R.id.layout_date);
        laout_clear = (LinearLayout) view.findViewById(R.id.laout_clear);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
        recycleView.setLayoutManager(linearLayoutManager);
        List<Result> resultList = getAllOpenBookDataList();
        OpenBookingAdapter openBookingAdapter = new OpenBookingAdapter(context, resultList);
        recycleView.setAdapter(openBookingAdapter);
        layout_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setDate();
            }
        });
        laout_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edt_city.setText("");
                tv_date.setText("");
                setCurrentDate();
            }
        });
        setCurrentDate();
        getActivity().getWindow().setSoftInputMode(WindowManager.
                LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
    }

    //set current date
    private void setCurrentDate() {
        Calendar calendar = Calendar.getInstance();
        Date currentdate = calendar.getTime();
        int d = calendar.get(Calendar.DATE);
        int m = calendar.get(Calendar.MONTH) + 1;
        int y = calendar.get(Calendar.YEAR);
        CreatedOn = y + "-" + m + "-" + d;
        String sdateTime = Utility.convertDate(currentdate);
        if (sdateTime != null) {
            String[] startArray = sdateTime.split(",");
            tv_date.setText(startArray[1] + "-" + startArray[2] + "-" + startArray[6]);
        }
    }

    public void setDate() {

        Calendar calendar = Calendar.getInstance();
        Date currentdate = calendar.getTime();
        String sdateTime = Utility.convertDate(currentdate);
        if (sdateTime != null) {
            String[] startArray = sdateTime.split(",");
            tv_date.setText(startArray[1] + "-" + startArray[2] + "-" + startArray[6]);
        }
        int d = calendar.get(Calendar.DATE);
        int m = calendar.get(Calendar.MONTH);
        int y = calendar.get(Calendar.YEAR);
        DatePickerDialog dp = new DatePickerDialog(context, new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                String mon = MONTHS[month];
                String date = dayOfMonth + "-" + mon + "-" + year;
                tv_date.setText(date);
                int newmonth = month + 1;
                CreatedOn = year + "-" + newmonth + "-" + dayOfMonth;
//                getAllCustomerList();
            }
        }, y, m, d);
        dp.show();
//
    }

    private List<Result> getAllOpenBookDataList() {
        List<Result> resultList = new ArrayList<>();
        result = new Result();
        result.setTripType("One Way Trip");
        result.setDistance("140");
        result.setCabName("Suv");
        result.setDate("4 Aug");
        result.setTripName("Delhi To Bareilly");
        result.setCabtype("Bhatia Cab Premium");
        result.setTime("11:30AM");
        resultList.add(result);
        result = new Result();
        result.setTripType("Two Way Trip");
        result.setDistance("170");
        result.setCabName("SEDAN");
        result.setDate("14 Aug");
        result.setTripName("Bareilly to Delhi");
        result.setCabtype("Bhatia Cab COMFORT");
        result.setTime("11:30AM");
        resultList.add(result);
        result = new Result();
        result.setTripType("One Way Trip");
        result.setDistance("140");
        result.setCabName("Suv");
        result.setDate("4 Aug");
        result.setTripName("Delhi To Bareilly");
        result.setCabtype("Bhatia Cab Premium");
        result.setTime("11:30AM");
        resultList.add(result);
        result = new Result();
        result.setTripType("Two Way Trip");
        result.setDistance("170");
        result.setCabName("SEDAN");
        result.setDate("14 Aug");
        result.setTripName("Bareilly to Delhi");
        result.setCabtype("Bhatia Cab COMFORT");
        result.setTime("11:30AM");
        resultList.add(result);
        result = new Result();
        result.setTripType("One Way Trip");
        result.setDistance("160");
        result.setCabName("Suv");
        result.setDate("4 Aug");
        result.setTripName("Delhi To Bareilly");
        result.setCabtype("Bhatia Cab Premium");
        result.setTime("11:30AM");
        resultList.add(result);
        result = new Result();
        result.setTripType("Two Way Trip");
        result.setDistance("170");
        result.setCabName("SEDAN");
        result.setDate("14 Aug");
        result.setTripName("Bareilly to Delhi");
        result.setCabtype("Bhatia Cab COMFORT");
        result.setTime("11:30AM");
        resultList.add(result);
        result = new Result();
        result.setTripType("One Way Trip");
        result.setDistance("100");
        result.setCabName("Suv");
        result.setDate("4 Aug");
        result.setTripName("Delhi To Bareilly");
        result.setCabtype("Bhatia Cab Premium");
        result.setTime("11:30AM");
        resultList.add(result);
        result = new Result();
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
