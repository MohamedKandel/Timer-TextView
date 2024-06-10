package com.mkandeel.timerlib

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.mkandeel.timer.StatusListener
import com.mkandeel.timer.TickListener
import com.mkandeel.timer.TextViewTimer

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}