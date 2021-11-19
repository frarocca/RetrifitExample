package com.example.myretrofitexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnSetCurrentTime = findViewById<Button>(R.id.setCurrentTime)
    // set on-click listener
        btnSetCurrentTime.setOnClickListener {
            Toast.makeText(this@MainActivity, "You clicked me.", Toast.LENGTH_SHORT).show()
        }

    }
}