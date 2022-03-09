package algokelvin.app.pinentry;

import android.widget.TextView;

public class PinEntry2 {
    private TextView[] edtTextPin;
    private int dgt = 0;

    public PinEntry2(TextView[] edtText) {
        this.edtTextPin = edtText;
        setTransformationMethod();
    }

    private void setTransformationMethod() {
        for (TextView edt: edtTextPin) {
            edt.setTransformationMethod(new AsteriskPasswordTransformationMethod());
        }
    }

    public void textPassword(int num) {
        if (dgt < edtTextPin.length) {
            edtTextPin[dgt++].setText(String.valueOf(num));
        }
    }

    public void removePassword() {
        if (dgt > 0) {
            edtTextPin[--dgt].setText("");
        }
    }

    public int getDigits() {
        return dgt;
    }

    public TextView[] getPin() {
        return edtTextPin;
    }


}
