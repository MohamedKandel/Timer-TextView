package com.mkandeel.timer

interface StatusListener {
    fun onTimerStarted()
    fun onTimerStopped()
    fun onTimerReset()
}