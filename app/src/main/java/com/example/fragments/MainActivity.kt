package com.example.fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.FragmentManager

class MainActivity : AppCompatActivity(), BlankFragment.EventListener {

    private lateinit var textView: TextView
    private lateinit var editText: EditText
    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val fragment = BlankFragment.newInstance()
        textView = findViewById(R.id.text_view_activity)
        editText = findViewById(R.id.edit_text_activity)
        button = findViewById(R.id.button_activity)
        supportFragmentManager.beginTransaction().replace(R.id.fragment, fragment).commit()
        button.setOnClickListener { fragment.receive(editText.text.toString()) }
    }

    override fun event(data: String) {
        textView.text = data
    }
}