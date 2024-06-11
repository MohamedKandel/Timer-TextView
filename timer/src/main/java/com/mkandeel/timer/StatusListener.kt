package com.mkandeel.timer

interface StatusListener {
    fun onTimerStarted()
    fun onTimerStopped(hours:String, minutes:String, seconds:String)
    fun onTimerReset()
}