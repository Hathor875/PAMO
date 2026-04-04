package com.example.healthcalculatorkotlin

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.hamcrest.CoreMatchers.containsString
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class CalculatorUITest {
    @get:Rule
    val activityRule = ActivityScenarioRule(CalculatorActivity::class.java)

    @Test
    fun testBmiCalculationFlow() {
        onView(withId(R.id.etWeight)).perform(typeText("70"), closeSoftKeyboard())
        onView(withId(R.id.etHeight)).perform(typeText("175"), closeSoftKeyboard())
        onView(withId(R.id.btnBmi)).perform(click())
        onView(withId(R.id.tvBmiResult)).check(matches(withText(containsString("W normie"))))
    }

    @Test
    fun testBmrCalculationFlow() {
        onView(withId(R.id.etWeight)).perform(typeText("80"), closeSoftKeyboard())
        onView(withId(R.id.etHeight)).perform(typeText("180"), closeSoftKeyboard())
        onView(withId(R.id.etAge)).perform(typeText("30"), closeSoftKeyboard())
        onView(withId(R.id.btnBmr)).perform(scrollTo(), click())
        onView(withId(R.id.tvBmrResult)).check(matches(withText(containsString("kcal"))))
    }
}