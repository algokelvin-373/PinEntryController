package com.algokelvin.pinentryedittext

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.algokelvin.pinentryedittext.databinding.ActivityMainBinding
import com.algokelvin.pinentryedittext.databinding.IncludePinBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var listEdtPin: Array<EditText>
    private lateinit var pinEntry: PinEntry

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        listEdtPin = arrayOf(
            binding.includePinEntry.edtPin1,
            binding.includePinEntry.edtPin2,
            binding.includePinEntry.edtPin3,
            binding.includePinEntry.edtPin4,
            binding.includePinEntry.edtPin5,
            binding.includePinEntry.edtPin6,
        )
        pinEntry = PinEntry(listEdtPin)

        includePinBinding.edtPin1.addTextChangedListener(inputPinController(includePinBinding.edtPin1))
        includePinBinding.edtPin2.addTextChangedListener(inputPinController(includePinBinding.edtPin2))
        includePinBinding.edtPin3.addTextChangedListener(inputPinController(includePinBinding.edtPin3))
        includePinBinding.edtPin4.addTextChangedListener(inputPinController(includePinBinding.edtPin4))
        includePinBinding.edtPin5.addTextChangedListener(inputPinController(includePinBinding.edtPin5))
        includePinBinding.edtPin6.addTextChangedListener(inputPinController(includePinBinding.edtPin6))
    }

    private fun inputPinController(view: View) = object : TextWatcher {
        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) { }
        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            val numberOne = includePinBinding.edtPin1.text.toString().trim()
            val numberTwo = includePinBinding.edtPin2.text.toString().trim()
            val numberThree = includePinBinding.edtPin3.text.toString().trim()
            val numberFour = includePinBinding.edtPin4.text.toString().trim()
            val numberFive = includePinBinding.edtPin5.text.toString().trim()
            val numberSix = includePinBinding.edtPin6.text.toString().trim()

            when(view.id) {
                R.id.edt_pin_1 -> {
                    if (numberOne.length == 1) {
                        includePinBinding.edtPin2.requestFocus()
                    }
                }
                R.id.edt_pin_2 -> {
                    if (numberTwo.length == 1) {
                        includePinBinding.edtPin3.requestFocus()
                    } else if (numberTwo.isEmpty()) {
                        includePinBinding.edtPin1.requestFocus()
                    }
                }
                R.id.edt_pin_3 -> {
                    if (numberThree.length == 1) {
                        includePinBinding.edtPin4.requestFocus()
                    } else if (numberThree.isEmpty()) {
                        includePinBinding.edtPin2.requestFocus()
                    }
                }
                R.id.edt_pin_4 -> {
                    if (numberFour.length == 1) {
                        includePinBinding.edtPin5.requestFocus()
                    } else if (numberFour.isEmpty()) {
                        includePinBinding.edtPin3.requestFocus()
                    }
                }
                R.id.edt_pin_5 -> {
                    if (numberFive.length == 1) {
                        includePinBinding.edtPin6.requestFocus()
                    } else if (numberFive.isEmpty()) {
                        includePinBinding.edtPin4.requestFocus()
                    }
                }
                R.id.edt_pin_6 -> {
                    if (numberSix.isNotEmpty()) {
                        val number = numberOne + numberTwo + numberThree + numberFour + numberFive + numberSix
                        Toast.makeText(this@MainActivity, "Input : $number", Toast.LENGTH_LONG).show()
                    } else {
                        includePinBinding.edtPin5.requestFocus()
                    }
                }
            }
        }

        override fun afterTextChanged(p0: Editable?) { }
    }
}