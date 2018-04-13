package hacker.l.venderapp.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import hacker.l.venderapp.R;
import hacker.l.venderapp.activity.DashboardActivity;


public class AddDriverFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    // TODO: Rename and change types and number of parameters
    public static AddDriverFragment newInstance(String param1, String param2) {
        AddDriverFragment fragment = new AddDriverFragment();
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

    Context context;
    View view;
    Spinner spinner_type, spinner_carName, spinner_carModel, spinner_carYear;
    TextView tv_submit;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        context = getActivity();
        view = inflater.inflate(R.layout.fragment_add_driver, container, false);
        init();
        return view;
    }

    private void init() {
        DashboardActivity dashboardActivity = (DashboardActivity) context;
        dashboardActivity.setTitle("Add Drivers");
        dashboardActivity.addCity(false);
        dashboardActivity.setInfo(false);
        dashboardActivity.setHelp(false);
        spinner_type = (Spinner) view.findViewById(R.id.spinner_type);
        spinner_carName = (Spinner) view.findViewById(R.id.spinner_carName);
        spinner_carModel = (Spinner) view.findViewById(R.id.spinner_carModel);
        spinner_carYear = (Spinner) view.findViewById(R.id.spinner_carYear);
        tv_submit = (TextView) view.findViewById(R.id.tv_submit);
        tv_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().popBackStack();
            }
        });
        setSpinnerAdapter();
    }

    private void setSpinnerAdapter() {
        List<String> carNameList = new ArrayList<>();
        carNameList.add("Tata");
        carNameList.add("honda");
        carNameList.add("toyota");
        ArrayAdapter<String> name = new ArrayAdapter<String>(context, android.R.layout.simple_spinner_dropdown_item, carNameList);
        spinner_carName.setAdapter(name);
        List<String> carModelList = new ArrayList<>();
        carModelList.add("Alto");
        carModelList.add("brio");
        carModelList.add("beta");
        carModelList.add("indica");
        carModelList.add("ritz");
        ArrayAdapter<String> model = new ArrayAdapter<String>(context, android.R.layout.simple_spinner_dropdown_item, carModelList);
        spinner_carModel.setAdapter(model);
        List<String> carYearList = new ArrayList<>();
        carYearList.add("2010");
        carYearList.add("2015");
        carYearList.add("2013");
        carYearList.add("2014");
        ArrayAdapter<String> year = new ArrayAdapter<String>(context, android.R.layout.simple_spinner_dropdown_item, carYearList);
        spinner_carYear.setAdapter(year);

        List<String> cartypeList = new ArrayList<>();
        cartypeList.add("Cab Business");
        cartypeList.add("Cab Economy");
        cartypeList.add("Cab Primium");
        ArrayAdapter<String> type = new ArrayAdapter<String>(context, android.R.layout.simple_spinner_dropdown_item, cartypeList);
        spinner_type.setAdapter(type);
    }
}
