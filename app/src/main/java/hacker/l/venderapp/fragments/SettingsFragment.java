package hacker.l.venderapp.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import hacker.l.venderapp.R;
import hacker.l.venderapp.activity.DashboardActivity;
import hacker.l.venderapp.activity.LoginActivity;

public class SettingsFragment extends Fragment implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public static SettingsFragment newInstance(String param1, String param2) {
        SettingsFragment fragment = new SettingsFragment();
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
    TextView tv_logout, tv_about, tv_privacy, tv_updateProfile, tv_updateDocs, tv_changePass;
    Switch btn_switch;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        context = getActivity();
        view = inflater.inflate(R.layout.fragment_settings, container, false);
        init();
        return view;
    }

    private void init() {
        DashboardActivity dashboardActivity = (DashboardActivity) context;
        dashboardActivity.setTitle("Settings");
        dashboardActivity.addCity(false);
        dashboardActivity.setInfo(false);
        dashboardActivity.setHelp(false);
        tv_logout = (TextView) view.findViewById(R.id.tv_logout);
        tv_about = (TextView) view.findViewById(R.id.tv_about);
        tv_privacy = (TextView) view.findViewById(R.id.tv_privacy);
        tv_updateProfile = (TextView) view.findViewById(R.id.tv_updateProfile);
        tv_updateDocs = (TextView) view.findViewById(R.id.tv_updateDocs);
        tv_changePass = (TextView) view.findViewById(R.id.tv_changePass);
        btn_switch = (Switch) view.findViewById(R.id.btn_switch);
        tv_logout.setOnClickListener(this);
        tv_about.setOnClickListener(this);
        tv_privacy.setOnClickListener(this);
        tv_updateProfile.setOnClickListener(this);
        tv_updateDocs.setOnClickListener(this);
        tv_changePass.setOnClickListener(this);
        btn_switch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_logout:
                logout();
                break;
            case R.id.tv_about:
                AboutFragment aboutFragment = AboutFragment.newInstance("", "");
                moveFragment(aboutFragment);
                break;
            case R.id.tv_privacy:
                PrivacyPolicyFragment privacyPolicyFragment = PrivacyPolicyFragment.newInstance("", "");
                moveFragment(privacyPolicyFragment);
                break;
            case R.id.tv_updateProfile:
                UpdateProfileFragment updateProfileFragment = UpdateProfileFragment.newInstance("", "");
                moveFragment(updateProfileFragment);
                break;
            case R.id.tv_updateDocs:
                UploadDocsFragment uploadDocsFragment = UploadDocsFragment.newInstance("", "");
                moveFragment(uploadDocsFragment);
                break;
            case R.id.tv_changePass:
                ChangePassFragment changePassFragment = ChangePassFragment.newInstance("", "");
                moveFragment(changePassFragment);
                break;
        }
    }


    private void moveFragment(Fragment fragment) {
        FragmentManager fragmentManager = ((FragmentActivity) context).getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.container, fragment)
                .addToBackStack(null)
                .commit();
    }

    private void logout() {
        Intent intent = new Intent(context, LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }
}
