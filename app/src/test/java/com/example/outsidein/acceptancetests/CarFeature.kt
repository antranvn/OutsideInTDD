package com.example.outsidein.acceptancetests

import com.example.outsidein.Car
import com.example.outsidein.Engine
import com.example.outsidein.utils.MainCoroutineScopeRule
import kotlinx.coroutines.test.advanceTimeBy
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Rule
import org.junit.Test

class CarFeature {

    private val engine = Engine()
    private val car = Car(engine, 6.0)

    @get: Rule
    var coroutinesTestRule = MainCoroutineScopeRule()

    @Test
    fun carIsLoosingFuelWhenItTurnsOn() {
        car.turnOn()

        assertEquals(5.5, car.fuel, 0.0)
    }

    @Test
    fun carIsTurningOnItsEngineAndIncreasesTheTemperatureGradually() {
        car.turnOn()

        coroutinesTestRule.advanceTimeBy(2000)
        assertEquals(25, car.engine.temperature)
        coroutinesTestRule.advanceTimeBy(2000)
        assertEquals(50, car.engine.temperature)
        coroutinesTestRule.advanceTimeBy(2000)
        assertEquals(95, car.engine.temperature)
        assertTrue(car.engine.isTurnedOn)
    }
}