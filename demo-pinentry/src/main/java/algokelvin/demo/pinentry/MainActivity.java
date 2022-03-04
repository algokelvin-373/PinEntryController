package algokelvin.demo.pinentry;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

import algokelvin.app.pinentrycontroller.PinEntry;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText edt1 = findViewById(R.id.edt_pin_1);
        EditText edt2 = findViewById(R.id.edt_pin_2);
        EditText edt3 = findViewById(R.id.edt_pin_3);
        EditText edt4 = findViewById(R.id.edt_pin_4);
        EditText edt5 = findViewById(R.id.edt_pin_5);
        EditText edt6 = findViewById(R.id.edt_pin_6);

        EditText[] editTexts = {edt1, edt2, edt3, edt4, edt5, edt6};
        PinEntry pin = new PinEntry(editTexts);


    }
}