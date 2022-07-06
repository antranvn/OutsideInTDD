package com.example.outsidein.unittests

import com.example.outsidein.Car
import com.example.outsidein.Engine
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.times
import com.nhaarman.mockitokotlin2.verify
import org.junit.Assert.assertEquals
import org.junit.Test

class CarShould {

    private val engine: Engine = mock()
    private val car = Car(engine, 5.0)

    @Test
    fun loosingFuelWhenItTurnsOn() {
        car.turnOn()

        assertEquals(4.5, car.fuel, 0.0)
    }

    @Test
    fun turnOnItsEngine() {
        car.turnOn()

        verify(engine, times(1)).turnOn()
    }
}