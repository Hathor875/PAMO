package com.example.healthcalculatorkotlin

import org.junit.Assert.assertEquals
import org.junit.Test

class BmiCalculatorTest {

    private fun calcBmi(weightKg: Double, heightCm: Double): Double {
        val heightM = heightCm / 100.0
        return weightKg / (heightM * heightM)
    }

    private fun interpret(bmi: Double): String = when {
        bmi < 18.5 -> "Niedowaga"
        bmi < 25.0 -> "W normie"
        bmi < 30.0 -> "Nadwaga"
        else -> "Otyłość"
    }

    @Test
    fun bmi_norma() {
        val bmi = calcBmi(70.0, 175.0)
        assertEquals("W normie", interpret(bmi))
    }

    @Test
    fun bmi_niedowaga() {
        val bmi = calcBmi(50.0, 175.0)
        assertEquals("Niedowaga", interpret(bmi))
    }

    @Test
    fun bmi_nadwaga() {
        val bmi = calcBmi(90.0, 175.0)
        assertEquals("Nadwaga", interpret(bmi))
    }

    @Test
    fun bmi_otylosc() {
        val bmi = calcBmi(110.0, 175.0)
        assertEquals("Otyłość", interpret(bmi))
    }
}
