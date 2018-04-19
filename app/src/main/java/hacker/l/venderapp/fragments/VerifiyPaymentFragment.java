package hacker.l.venderapp.fragments;

import android.app.DatePickerDialog;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Date;

import hacker.l.venderapp.R;
import hacker.l.venderapp.activity.DashboardActivity;
import hacker.l.venderapp.utilities.Utility;

public class VerifiyPaymentFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    // TODO: Rename and change types and number of parameters
    public static VerifiyPaymentFragment newInstance(String param1, String param2) {
        VerifiyPaymentFragment fragment = new VerifiyPaymentFragment();
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

    TextView tv_date;
    Spinner spinnerMonth, spinnerYear;
    public String[] MONTHS = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
    Context context;
    View view;
    Button btn_submit;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        context = getActivity();
        view = inflater.inflate(R.layout.fragment_verifiy_payment, container, false);
        init();
        return view;
    }

    private void init() {
        DashboardActivity dashboardActivity = (DashboardActivity) context;
        dashboardActivity.setTitle("Verify Payment");
        dashboardActivity.addCity(false);
        dashboardActivity.setInfo(false);
        dashboardActivity.setHelp(false);
        tv_date = (TextView) view.findViewById(R.id.tv_date);
        btn_submit = (Button) view.findViewById(R.id.btn_submit);
        tv_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setDate();
            }
        });
        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().popBackStack();
            }
        });
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
//                int newmonth = month + 1;
//                CreatedOn = year + "-" + newmonth + "-" + dayOfMonth;
//                getAllCustomerList();
            }
        }, y, m, d);
        dp.show();
//
    }
}

