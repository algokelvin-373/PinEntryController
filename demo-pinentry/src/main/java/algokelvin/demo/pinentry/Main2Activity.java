package algokelvin.demo.pinentry;

import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class Main2Activity extends AppCompatActivity {
    private TextView btnBack, btnAction;
    private boolean enBack = false;
    private TextView[] edtTextPin;
    private int dgt = 0;
    private String pin = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnBack = findViewById(R.id.btn_back);
        btnAction = findViewById(R.id.btn_action);
        TextView[] edtPin = {
                findViewById(R.id.edt_pin_1),
                findViewById(R.id.edt_pin_2),
                findViewById(R.id.edt_pin_3),
                findViewById(R.id.edt_pin_4),
                findViewById(R.id.edt_pin_5),
                findViewById(R.id.edt_pin_6)
        };
        setEdtTextPin(edtPin);
        setTransformationMethod();

    }

    private void setEdtTextPin(TextView[] edtTextPin) {
        this.edtTextPin = edtTextPin;
    }

    private void setTransformationMethod() {
        for (TextView edt: edtTextPin) {
            edt.setTransformationMethod(new AsteriskPasswordTransformationMethod());
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        Log.i("keyevent-down", String.valueOf(keyCode));
        switch (keyCode) {
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 16: textPassword(keyCode - 7);
                break;
            case 61: btnBackEnable();
                break;
            case 66: btnActionController();
                break;
            case 67: removePassword();
                break;
        }
        return super.onKeyDown(keyCode, event);
    }

    private void textPassword(int num) {
        if (dgt < edtTextPin.length && !enBack) {
            edtTextPin[dgt++].setText(String.valueOf(num));
            btnActionEnable();
        }
    }

    private void removePassword() {
        if (dgt > 0 && !enBack) {
            edtTextPin[--dgt].setText("");
            btnActionEnable();
        }
    }

    private void btnBackEnable() {
        if (!enBack) {
            btnBack.setFocusable(true);
            enBack = true;
        } else {
            btnBack.setFocusable(false);
            enBack = false;
        }
    }

    private void btnActionController() {
        if (!enBack) {
            if (dgt == edtTextPin.length) {
                StringBuilder dt = new StringBuilder();
                for (TextView textView : edtTextPin)
                    dt.append(textView.getText().toString());
                pin = dt.toString();
                Toast.makeText(this, "Your PIN: "+ pin, Toast.LENGTH_LONG).show();
            }
        } else {
            finish();
        }
    }

    private void btnActionEnable() {
        if (dgt == 6) enableBtnNext(R.drawable.bg_btn_action_active, R.color.white);
        else enableBtnNext(R.drawable.bg_btn_action_deactive, R.color.color_grey_9B9B9B);
    }

    private void enableBtnNext(int background, int color) {
        btnAction.setBackground(ContextCompat.getDrawable(this, background));
        btnAction.setTextColor(ContextCompat.getColor(this, color));
    }

}