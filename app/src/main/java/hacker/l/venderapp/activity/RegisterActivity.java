package hacker.l.venderapp.activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import hacker.l.venderapp.R;
import hacker.l.venderapp.database.DbHelper;
import hacker.l.venderapp.models.MyPojo;
import hacker.l.venderapp.models.Result;
import hacker.l.venderapp.utilities.Contants;
import hacker.l.venderapp.utilities.Utility;

public class RegisterActivity extends AppCompatActivity {
    Button id_bt_signup;
    ProgressDialog pd;
    EditText edt_name, edt_phone, edt_email, edt_password;
    TextInputLayout layout_phone, layout_name, layout_email, layout_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        init();
    }

    private void init() {
        id_bt_signup = (Button) findViewById(R.id.id_bt_signup);
        edt_name = (EditText) findViewById(R.id.id_et_userName);
        edt_phone = (EditText) findViewById(R.id.id_phone);
        edt_password = (EditText) findViewById(R.id.id_password);
        edt_email = (EditText) findViewById(R.id.id_email);
        layout_phone = (TextInputLayout) findViewById(R.id.laout_phone);
        layout_name = (TextInputLayout) findViewById(R.id.laout_name);
        layout_email = (TextInputLayout) findViewById(R.id.laout_email);
        layout_password = (TextInputLayout) findViewById(R.id.laout_password);

        id_bt_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signUp();
//                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
            }
        });

    }

    private void signUp() {
        Pattern pattern = Patterns.EMAIL_ADDRESS;
        final String userPhone = edt_phone.getText().toString();
        final String userPass = edt_password.getText().toString();
        final String userEmail = edt_email.getText().toString();
        final String userName = edt_name.getText().toString();
        if (userName.length() == 0) {
            layout_name.setError("Enter Name");
            requestFocus(edt_name);
        } else if (userPhone.length() == 0) {
            layout_phone.setError("Enter  Phone Phone");
            requestFocus(edt_phone);
            layout_name.setHintEnabled(false);
        } else if (userPhone.length() != 10) {
            layout_phone.setError("Enter Valid Phone");
            requestFocus(edt_phone);
        } else if (userEmail.length() == 0) {
            layout_email.setError("Enter Email Address");
            requestFocus(edt_email);
            layout_phone.setHintEnabled(false);
        } else if (!pattern.matcher(userEmail).matches()) {
            layout_email.setError("Enter Valid Email Address");
            requestFocus(edt_email);
        } else if (userPass.length() == 0) {
            layout_password.setError("Enter Password");
            requestFocus(edt_password);
            layout_email.setHintEnabled(false);
        } else

        {
            if (Utility.isOnline(this)) {
                pd = new ProgressDialog(RegisterActivity.this);
                pd.setMessage("Sign up wait...");
                pd.show();
                pd.setCancelable(false);
                StringRequest stringRequest = new StringRequest(Request.Method.POST, Contants.SERVICE_BASE_URL + Contants.Register,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                pd.dismiss();
//                                if (!response.equalsIgnoreCase("no")) {
//                                    MyPojo myPojo = new Gson().fromJson(response, MyPojo.class);
//                                    if (myPojo != null) {
//                                        for (Result result : myPojo.getResult()) {
//                                            if (result != null) {
//                                                new DbHelper(RegisterActivity.this).upsertUserData(result);
                                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                                startActivity(intent);
//                                            }
//                                        }
//                            }

//                        } else{
//                    Toast toast = Toast.makeText(RegisterActivity.this, "Invalid Information", Toast.LENGTH_SHORT);
//                    toast.setGravity(Gravity.CENTER, 0, 0);
//                    toast.show();
//                }
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                pd.dismiss();
                            }
                        }) {
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String, String> params = new HashMap<String, String>();
                        params.put("Username", userName);
                        params.put("UserPhone", userPhone);
                        params.put("EmailId", userEmail);
                        params.put("Password", userPass);
                        return params;
                    }
                };
                RequestQueue requestQueue = Volley.newRequestQueue(this);
                requestQueue.add(stringRequest);
            } else

            {

                Toast.makeText(this, "You are Offline. Please check your Internet Connection.", Toast.LENGTH_SHORT).show();
            }
        }
    }

    //for hid keyboard when tab outside edittext box
    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            View v = getCurrentFocus();
            if (v instanceof EditText) {
                Rect outRect = new Rect();
                v.getGlobalVisibleRect(outRect);
                if (!outRect.contains((int) event.getRawX(), (int) event.getRawY())) {
                    v.clearFocus();
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                }
            }
        }
        return super.dispatchTouchEvent(event);
    }

    private void requestFocus(View view) {
        if (view.requestFocus()) {
            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        }
    }
}
