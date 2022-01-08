package com.algokelvin.pinentryedittext

import algokelvin.app.pinentrycontroller.PinEntry
import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.algokelvin.pinentryedittext.databinding.ActivityMainBinding

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

        binding.apply {
            bindingApply()
        }
    }

    private fun ActivityMainBinding.bindingApply() {
        btnOk.setOnClickListener {
            txtPin.text = ("Your Pin is ${pinEntry.number}")
        }
    }
}