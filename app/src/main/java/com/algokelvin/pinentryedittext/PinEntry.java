package com.algokelvin.pinentryedittext;

import android.widget.EditText;

public class PinEntry {
    private EditText[] edtTextPin;

    public PinEntry(EditText[] edtTextPin) {
        setEdtTextPin(edtTextPin);
        setTransformationMethod();
    }

    private void setEdtTextPin(EditText[] edtTextPin) {
        this.edtTextPin = edtTextPin;
    }

    private void setTransformationMethod() {
        for (EditText edt: edtTextPin) {
            edt.setTransformationMethod(new AsteriskPasswordTransformationMethod());
        }
    }

    private void setAddTextChangedListener() {

    }

}
