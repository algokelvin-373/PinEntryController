package algokelvin.demo.pinentry;

import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class MainActivity extends AppCompatActivity {
    private int position = 1;
    private TextView edt1, edt2, edt3, edt4, edt5, edt6, btnBack, btnAction;
    private boolean enBack = false, endDigits = false;
    private String number = "";
    private TextView[] edtTextPin;
    private String[] digits;
    private int dgt = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnBack = findViewById(R.id.btn_back);
        btnAction = findViewById(R.id.btn_action);
        edt1 = findViewById(R.id.edt_pin_1);
        edt2 = findViewById(R.id.edt_pin_2);
        edt3 = findViewById(R.id.edt_pin_3);
        edt4 = findViewById(R.id.edt_pin_4);
        edt5 = findViewById(R.id.edt_pin_5);
        edt6 = findViewById(R.id.edt_pin_6);
        TextView[] edtPin = {edt1, edt2, edt3, edt4, edt5, edt6};
        setEdtTextPin(edtPin);
        setTransformationMethod();
        actionAddTextChangedListener();

    }

    private void setEdtTextPin(TextView[] edtTextPin) {
        this.edtTextPin = edtTextPin;
        this.digits = new String[edtTextPin.length];
    }

    private void setTransformationMethod() {
        for (TextView edt: edtTextPin) {
            edt.setTransformationMethod(new AsteriskPasswordTransformationMethod());
        }
    }

    private void actionAddTextChangedListener() {
        for (TextView edt: edtTextPin) {
            setAddTextChangedListener(edt);
        }
    }

    private void setAddTextChangedListener(TextView editText) {
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) { }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                for (int x = 0; x < edtTextPin.length; x++) {
                    digits[x] = edtTextPin[x].getText().toString().trim();
                }

                int id = editText.getId();
                if (id == R.id.edt_pin_1) {
                    if (digits[dgt].length() == 1) {
                        edtTextPin[dgt++].setFocusable(false);
                        edtTextPin[dgt].requestFocus();
                        edtTextPin[dgt].setFocusable(true);
                    }
                } else if (id == R.id.edt_pin_2) {
                    if (digits[dgt].length() == 1) {
                        edtTextPin[dgt++].setFocusable(false);
                        edtTextPin[dgt].requestFocus();
                        edtTextPin[dgt].setFocusable(true);
                    }
                } else if (id == R.id.edt_pin_3) {
                    if (digits[dgt].length() == 1) {
                        edtTextPin[dgt++].setFocusable(false);
                        edtTextPin[dgt].requestFocus();
                        edtTextPin[dgt].setFocusable(true);
                    }
                } else if (id == R.id.edt_pin_4) {
                    if (digits[dgt].length() == 1) {
                        edtTextPin[dgt++].setFocusable(false);
                        edtTextPin[dgt].requestFocus();
                        edtTextPin[dgt].setFocusable(true);
                    }
                } else if (id == R.id.edt_pin_5) {
                    if (digits[dgt].length() == 1) {
                        edtTextPin[dgt++].setFocusable(false);
                        edtTextPin[dgt].requestFocus();
                        edtTextPin[dgt].setFocusable(true);
                    }
                } else if (id == R.id.edt_pin_6) {
                    if (digits[dgt].length() == 1) {
                        enableBtnNext(R.drawable.bg_btn_action_active, R.color.white);
                        endDigits = true;
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable editable) { }

        });
    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        Log.i("keyevent-up", String.valueOf(keyCode));
        switch (keyCode) {
            case 67: {
                Log.i("keyevent-up", "enback " + enBack);
                if (!enBack) {
                    if (dgt != 0) {
                        edtTextPin[dgt].setFocusable(false);
                        edtTextPin[dgt].setText("");
                        edtTextPin[dgt - 1].setFocusable(true);
                        dgt -= 1;
                    } else {
                        edtTextPin[dgt].setText("");
                    }
                }
            }
        }
        return super.onKeyUp(keyCode, event);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        Log.i("keyevent-down", String.valueOf(keyCode));
        switch (keyCode) {
            case 61: {
                if (!enBack) {
                    enBack = true;
                } else {
                    enBack = false;
                }
                btnBack.setFocusable(enBack);
                break;
            }
        }
        return super.onKeyDown(keyCode, event);
    }

    private void enableBtnNext(int background, int color) {
        btnAction.setBackground(ContextCompat.getDrawable(this, background));
        btnAction.setTextColor(ContextCompat.getColor(this, color));
    }

}