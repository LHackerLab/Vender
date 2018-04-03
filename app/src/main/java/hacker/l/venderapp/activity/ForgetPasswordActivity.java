package hacker.l.venderapp.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import hacker.l.venderapp.R;

public class ForgetPasswordActivity extends AppCompatActivity {
    LinearLayout layout_singup;
    EditText edt_phone;
    Button id_bt_forget;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);
        init();
    }

    private void init() {
        layout_singup = (LinearLayout) findViewById(R.id.layout_singup);
        edt_phone = (EditText) findViewById(R.id.edt_phone);
        id_bt_forget = (Button) findViewById(R.id.id_bt_forget);
        layout_singup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ForgetPasswordActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
        id_bt_forget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phone = edt_phone.getText().toString();
                if (phone.length() == 0) {
                    edt_phone.setError("Enter Phone Number");
                } else if (phone.length() != 10) {
                    edt_phone.setError("Enter valid Phone");
                } else {
                    Toast.makeText(ForgetPasswordActivity.this, "Done", Toast.LENGTH_SHORT).show();
                }
            }
        });
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
