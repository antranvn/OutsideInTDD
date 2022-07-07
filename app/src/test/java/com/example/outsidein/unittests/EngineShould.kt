package com.example.outsidein.unittests

import com.example.outsidein.Engine
import com.example.outsidein.utils.MainCoroutineScopeRule
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Rule
import org.junit.Test

class EngineShould {

    private val engine = Engine()

    @get: Rule
    var coroutinesTestRule = MainCoroutineScopeRule()

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun turnOn() = runTest {
        engine.turnOn()

        assertTrue(engine.isTurnedOn)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun riseTheTemperatureWhenItTurnsOn() = runTest {
        engine.turnOn()

        assertEquals(95, engine.temperature)
    }

}