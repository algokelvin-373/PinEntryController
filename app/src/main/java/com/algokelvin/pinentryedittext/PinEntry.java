package com.algokelvin.pinentryedittext;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import com.algokelvin.pinentryedittext.databinding.IncludePinBinding;

public class PinEntry {
    private IncludePinBinding includePinBinding;
    private String number;

    public PinEntry(IncludePinBinding binding) {
        this.includePinBinding = binding;
        setTransformationMethod();
        actionAddTextChangedListener();
    }

    public String getNumber() {
        return number;
    }

    private void setTransformationMethod() {
        includePinBinding.edtPin1.setTransformationMethod(new AsteriskPasswordTransformationMethod());
        includePinBinding.edtPin2.setTransformationMethod(new AsteriskPasswordTransformationMethod());
        includePinBinding.edtPin3.setTransformationMethod(new AsteriskPasswordTransformationMethod());
        includePinBinding.edtPin4.setTransformationMethod(new AsteriskPasswordTransformationMethod());
        includePinBinding.edtPin5.setTransformationMethod(new AsteriskPasswordTransformationMethod());
        includePinBinding.edtPin6.setTransformationMethod(new AsteriskPasswordTransformationMethod());
    }

    private void actionAddTextChangedListener() {
        setAddTextChangedListener(includePinBinding.edtPin1);
        setAddTextChangedListener(includePinBinding.edtPin2);
        setAddTextChangedListener(includePinBinding.edtPin3);
        setAddTextChangedListener(includePinBinding.edtPin4);
        setAddTextChangedListener(includePinBinding.edtPin5);
        setAddTextChangedListener(includePinBinding.edtPin6);
    }

    private void setAddTextChangedListener(EditText editText) {
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) { }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String numberOne = includePinBinding.edtPin1.getText().toString().trim();
                String numberTwo = includePinBinding.edtPin2.getText().toString().trim();
                String numberThree = includePinBinding.edtPin3.getText().toString().trim();
                String numberFour = includePinBinding.edtPin4.getText().toString().trim();
                String numberFive = includePinBinding.edtPin5.getText().toString().trim();
                String numberSix = includePinBinding.edtPin6.getText().toString().trim();

                switch (editText.getId()) {
                    case R.id.edt_pin_1 : {
                        if (numberOne.length() == 1) {
                            includePinBinding.edtPin2.requestFocus();
                        }
                    }
                    break;
                    case R.id.edt_pin_2 : {
                        if (numberTwo.length() == 1) {
                            includePinBinding.edtPin3.requestFocus();
                        } else if (numberTwo.isEmpty()) {
                            includePinBinding.edtPin1.requestFocus();
                        }
                    }
                    break;
                    case R.id.edt_pin_3 : {
                        if (numberThree.length() == 1) {
                            includePinBinding.edtPin4.requestFocus();
                        } else if (numberThree.isEmpty()) {
                            includePinBinding.edtPin2.requestFocus();
                        }
                    }
                    break;
                    case R.id.edt_pin_4 : {
                        if (numberFour.length() == 1) {
                            includePinBinding.edtPin5.requestFocus();
                        } else if (numberFour.isEmpty()) {
                            includePinBinding.edtPin3.requestFocus();
                        }
                    }
                    break;
                    case R.id.edt_pin_5 : {
                        if (numberFive.length() == 1) {
                            includePinBinding.edtPin6.requestFocus();
                        } else if (numberFive.isEmpty()) {
                            includePinBinding.edtPin4.requestFocus();
                        }
                    }
                    break;
                    case R.id.edt_pin_6 : {
                        if (!numberSix.isEmpty()) {
                            number = numberOne + numberTwo + numberThree + numberFour + numberFive + numberSix;
//                            Toast.makeText(this, "Input : $number", Toast.LENGTH_LONG).show()
                        } else {
                            includePinBinding.edtPin5.requestFocus();
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
