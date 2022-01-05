package com.algokelvin.pinentryedittext;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

public class PinEntry {
    private EditText[] edtTextPin;
    private String[] digits;
    private String number;

    public PinEntry(EditText[] edtTextPin) {
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

                switch (editText.getId()) {
                    case R.id.edt_pin_1 : {
                        if (digits[0].length() == 1) {
                            edtTextPin[1].requestFocus();
                        }
                    }
                    break;
                    case R.id.edt_pin_2 : {
                        if (digits[1].length() == 1) {
                            edtTextPin[2].requestFocus();
                        } else if (digits[1].isEmpty()) {
                            edtTextPin[0].requestFocus();
                        }
                    }
                    break;
                    case R.id.edt_pin_3 : {
                        if (digits[2].length() == 1) {
                            edtTextPin[3].requestFocus();
                        } else if (digits[2].isEmpty()) {
                            edtTextPin[1].requestFocus();
                        }
                    }
                    break;
                    case R.id.edt_pin_4 : {
                        if (digits[3].length() == 1) {
                            edtTextPin[4].requestFocus();
                        } else if (digits[3].isEmpty()) {
                            edtTextPin[2].requestFocus();
                        }
                    }
                    break;
                    case R.id.edt_pin_5 : {
                        if (digits[4].length() == 1) {
                            edtTextPin[5].requestFocus();
                        } else if (digits[4].isEmpty()) {
                            edtTextPin[3].requestFocus();
                        }
                    }
                    break;
                    case R.id.edt_pin_6 : {
                        if (!digits[5].isEmpty()) {
                            number = digits[0] + digits[1] + digits[2] + digits[3] + digits[4] + digits[5];
                        } else {
                            edtTextPin[4].requestFocus();
                        }
                    }
                    break;
                }
            }

            @Override
            public void afterTextChanged(Editable editable) { }

        });
    }

}
