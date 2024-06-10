package com.mkandeel.timer

interface TickListener {
    fun onTickListener(hours: String, minutes: String, seconds: String)
}