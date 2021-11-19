package com.example.myretrofitexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.example.myretrofitexample.Network.SimulatorApi
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnSetCurrentTime = findViewById<Button>(R.id.setCurrentTime)
    // set on-click listener
        btnSetCurrentTime.setOnClickListener {
            CoroutineScope(IO).launch {
                val timeResult = SimulatorApi.retrofitService.currentTime()
                println("risultato ${timeResult.body()?.time}")
            }
        }

    }
}