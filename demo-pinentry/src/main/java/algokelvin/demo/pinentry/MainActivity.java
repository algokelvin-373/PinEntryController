package algokelvin.demo.pinentry;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.EditText;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private int position = 1;
    private EditText edt1, edt2, edt3, edt4, edt5, edt6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edt1 = findViewById(R.id.edt_pin_1);
        edt2 = findViewById(R.id.edt_pin_2);
        edt3 = findViewById(R.id.edt_pin_3);
        edt4 = findViewById(R.id.edt_pin_4);
        edt5 = findViewById(R.id.edt_pin_5);
        edt6 = findViewById(R.id.edt_pin_6);
        EditText[] edtPin = {edt1, edt2, edt3, edt4, edt5, edt6};
        PinEntry pinEntry = new PinEntry(edtPin);

    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        Log.i("keyevent-up", String.valueOf(keyCode));
        return super.onKeyUp(keyCode, event);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        Log.i("keyevent-down", String.valueOf(keyCode));

        return super.onKeyDown(keyCode, event);
    }

    private void edtFocusable(EditText edtNow, EditText edtNext, int num) {
        edtNow.setText(String.valueOf(num));
        edtNext.requestFocus();
    }

}