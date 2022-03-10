package algokelvin.app.pinentry;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

public class PinEntry {
    private EditText[] edtTextPin;
    private String[] digits;
    private String number;

    public PinEntry(EditText[] edtTextPin) {
        number = "";
        setEdtTextPin(edtTextPin);
        setTransformationMethod();
        actionAddTextChangedListener();
    }

    private void setEdtTextPin(EditText[] edtTextPin) {
        this.edtTextPin = edtTextPin;
        this.digits = new String[edtTextPin.length];
    }

    private void setTransformationMethod() {
        for (EditText edt: edtTextPin) {
            edt.setTransformationMethod(new AsteriskPasswordTransformationMethod());
        }
    }

    public String getNumber() {
        return number;
    }

    private void actionAddTextChangedListener() {
        for (EditText edt: edtTextPin) {
            setAddTextChangedListener(edt);
        }
    }

    private void setAddTextChangedListener(EditText editText) {
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
                    setFirstDigit(digits[0], edtTextPin[1]);
                } else if (id == R.id.edt_pin_2) {
                    setDigit(digits[1], edtTextPin[2], edtTextPin[0]);
                } else if (id == R.id.edt_pin_3) {
                    setDigit(digits[2], edtTextPin[3], edtTextPin[1]);
                } else if (id == R.id.edt_pin_4) {
                    setDigit(digits[3], edtTextPin[4], edtTextPin[2]);
                } else if (id == R.id.edt_pin_5) {
                    setDigit(digits[4], edtTextPin[5], edtTextPin[3]);
                } else if (id == R.id.edt_pin_6) {
                    setLastDigit(digits[5], edtTextPin[4]);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) { }

        });
    }

    private void setFirstDigit(String digit, EditText editText) {
        if (digit.length() == 1) {
            editText.requestFocus();
        }
    }

    private void setDigit(String digit, EditText edtNext, EditText edtBefore) {
        if (digit.length() == 1) {
            edtNext.requestFocus();
        } else if (digit.isEmpty()) {
            edtBefore.requestFocus();
        }
    }

    private void setLastDigit(String digit, EditText editText) {
        if (!digit.isEmpty()) {
            for (String s : digits) number += s;
        } else {
            editText.requestFocus();
        }
    }

}
