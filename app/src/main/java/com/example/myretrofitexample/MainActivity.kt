package com.example.myretrofitexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.myretrofitexample.Network.SimulatorApi
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnSetCurrentTime = findViewById<Button>(R.id.setCurrentTime)
    // set on-click listener
        btnSetCurrentTime.setOnClickListener {
            setNewText("Click")
            CoroutineScope(IO).launch {
                val timeResult = SimulatorApi.retrofitService.currentTime()
                if(timeResult.isSuccessful)
                    setTextOnMainThread("risultato ${timeResult.body()?.time}")
                else
                    setTextOnMainThread("errore chiamata currentTime")
            }
        }

    }
    private fun setNewText(input: String) {
        val textView = findViewById<TextView>(R.id.textView)
        textView.text = input
    }
    private suspend fun setTextOnMainThread(input: String) {
        withContext (Main) {
            setNewText(input)
        }
    }
}