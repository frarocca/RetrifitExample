package com.example.myretrofitexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnSetCurrentTime = findViewById<Button>(R.id.setCurrentTime)
    // set on-click listener
        btnSetCurrentTime.setOnClickListener {
            setNewText("Click")
        }

    }
    private fun setNewText(input: String) {
        val textView = findViewById<TextView>(R.id.textView)
        textView.text = input
    }
}