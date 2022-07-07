package com.example.outsidein.unittests

import com.example.outsidein.Car
import com.example.outsidein.Engine
import com.example.outsidein.utils.MainCoroutineScopeRule
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.times
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test

class CarShould {

    private val engine: Engine = mock()
    private val car: Car

    init {
        runTest {
            whenever(engine.turnOn()).thenReturn(flow{
                delay(2000)
                emit(25)
                delay(2000)
                emit(50)
                delay(2000)
                emit(95)
            })

        }
        car = Car(engine, 5.0)
    }

    @get: Rule
    var coroutinesTestRule = MainCoroutineScopeRule()

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun loosingFuelWhenItTurnsOn() = runTest {
        car.turnOn()

        assertEquals(4.5, car.fuel, 0.0)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun turnOnItsEngine(): Unit = runTest {
        car.turnOn()

        verify(engine, times(1)).turnOn()
    }
}