package com.algokelvin.pinentryedittext

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.algokelvin.pinentryedittext.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var pinEntry: PinEntry

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Implement PinEntry
        pinEntry = PinEntry(binding.includePinEntry)

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