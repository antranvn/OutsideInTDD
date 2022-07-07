package com.example.outsidein

import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class Car(val engine: Engine, var fuel: Double) {
    fun turnOn() {
        fuel -= 0.5
        CoroutineScope(Dispatchers.Main).launch {
            engine.turnOn().collect { temperature ->
                Log.d("COURSE", "collect engine temperature: $temperature")
            }
        }
    }
}