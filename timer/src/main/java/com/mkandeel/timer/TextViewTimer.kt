package com.mkandeel.timer

import android.content.Context
import android.os.Handler
import android.os.Looper
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView
import java.util.Timer
import java.util.TimerTask

class TextViewTimer(context: Context, attrs: AttributeSet?) :
    AppCompatTextView(context, attrs) {

    private var timer = Timer()
    private lateinit var task: TimerTask
    private var time = 0.0
    private val handler = Handler(Looper.getMainLooper())
    private var updateInterval: Long
    private lateinit var tickListener: TickListener
    private lateinit var statusListener: StatusListener
    private var hours = ""
    private var mins = ""
    private var sec = ""
    private var timerStarted = false

    init {
        context.theme.obtainStyledAttributes(
            attrs,
            R.styleable.TextViewTimer,
            0, 0
        ).apply {
            try {
                updateInterval = getInt(R.styleable.TextViewTimer_updateInterval, 10000).toLong()
            } finally {
                recycle()
            }
        }
        setText("00:00:00")
    }

    fun setOnTimerTickListener(tickListener: TickListener) {
        this.tickListener = tickListener
    }

    fun setOnTimerStatusChangedListener(statusListener: StatusListener) {
        this.statusListener = statusListener
    }

    fun startTimer() {
        if (!timerStarted) {
            task = object : TimerTask() {
                override fun run() {
                    handler.post {
                        time++
                        this@TextViewTimer.text = getTimerText()
                    }
                }
            }
            statusListener.onTimerStarted()
            timerStarted = true
            timer.scheduleAtFixedRate(task, 0, updateInterval)
        }
    }

    fun stopTimer() {
        if (timerStarted) {
            if (::task.isInitialized) {
                handler.post {
                    task.cancel()
                    timerStarted = false
                    statusListener.onTimerStopped()
                }
            }
        }
    }

    fun resetTimer() {
        stopTimer()
        time = 0.0
        statusListener.onTimerReset()
        this.text = getTimerText()
    }

    private fun getTimerText(): String {
        val rounded = Math.round(time).toInt()
        val seconds = rounded % 86400 % 3600 % 60
        val minutes = rounded % 86400 % 3600 / 60
        val hours = rounded % 86400 / 3600

        return formatTime(seconds, minutes, hours)
    }

    private fun formatTime(seconds: Int, minutes: Int, hours: Int): String {
        this.hours = String.format("%02d", hours)
        this.mins = String.format("%02d", minutes)
        this.sec = String.format("%02d", seconds)

        if (hours > 0 || minutes > 0 || seconds > 0) {
            tickListener.onTickListener(this.hours, this.mins, this.sec)
        }

        return this.hours + ":" + this.mins +
                ":" + this.sec
    }
}