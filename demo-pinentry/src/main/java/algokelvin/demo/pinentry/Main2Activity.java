package algokelvin.demo.pinentry;

import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import algokelvin.app.pinentry.PinEntry2;

public class Main2Activity extends AppCompatActivity {
    private TextView btnBack, btnAction;
    private boolean enBack = false;
    private PinEntry2 pinEntry;

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
        pinEntry = new PinEntry2(edtPin);

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
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
        if (!enBack) {
            pinEntry.textPassword(num);
            btnActionEnable();
        }
    }

    private void removePassword() {
        if (!enBack) {
            pinEntry.removePassword();
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
            if (pinEntry.getDigits() == 6) {
                StringBuilder dt = new StringBuilder();
                for (TextView textView : pinEntry.getPin())
                    dt.append(textView.getText().toString());
                String pin = dt.toString();
                Toast.makeText(this, "Your PIN: "+ pin, Toast.LENGTH_LONG).show();
            }
        } else {
            finish();
        }
    }

    private void btnActionEnable() {
        if (pinEntry.getDigits() == 6) enableBtnNext(R.drawable.bg_btn_action_active, R.color.white);
        else enableBtnNext(R.drawable.bg_btn_action_deactive, R.color.color_grey_9B9B9B);
    }

    private void enableBtnNext(int background, int color) {
        btnAction.setBackground(ContextCompat.getDrawable(this, background));
        btnAction.setTextColor(ContextCompat.getColor(this, color));
    }

}