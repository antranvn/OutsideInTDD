package com.example.outsidein

import android.util.Log

class Engine(var temperature: Int = 15,
             var isTurnedOn: Boolean = false) {


    fun turnOn() {
        isTurnedOn = true
        Thread.sleep(6000)
        temperature = 95

        Log.d("COURSE", "Engine has turned on")
    }
}