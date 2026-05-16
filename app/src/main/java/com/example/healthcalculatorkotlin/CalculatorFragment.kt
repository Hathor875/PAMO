package com.example.healthcalculatorkotlin

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import kotlin.math.pow
import kotlin.math.roundToInt

class CalculatorFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_calculator, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val etWeight = view.findViewById<EditText>(R.id.etWeight)
        val etHeight = view.findViewById<EditText>(R.id.etHeight)
        val etAge = view.findViewById<EditText>(R.id.etAge)
        val btnBmi = view.findViewById<Button>(R.id.btnBmi)
        val tvBmiResult = view.findViewById<TextView>(R.id.tvBmiResult)
        val rbMale = view.findViewById<RadioButton>(R.id.rbMale)
        val spinnerActivity = view.findViewById<Spinner>(R.id.spinnerActivity)
        val btnBmr = view.findViewById<Button>(R.id.btnBmr)
        val tvBmrResult = view.findViewById<TextView>(R.id.tvBmrResult)

        btnBmi.setOnClickListener {
            val weightStr = etWeight.text.toString()
            val heightStr = etHeight.text.toString()

            if (weightStr.isNotEmpty() && heightStr.isNotEmpty()) {
                val weight = weightStr.toDouble()
                val heightM = heightStr.toDouble() / 100.0
                val bmi = weight / heightM.pow(2)

                val interpretation = when {
                    bmi < 18.5 -> "Niedowaga"
                    bmi < 25.0 -> "W normie"
                    bmi < 30.0 -> "Nadwaga"
                    else -> "Otyłość"
                }

                tvBmiResult.text = "Wynik BMI: ${String.format("%.2f", bmi)} ($interpretation)"
            } else {
                Toast.makeText(requireContext(), "Podaj wagę i wzrost!", Toast.LENGTH_SHORT).show()
            }
        }

        btnBmr.setOnClickListener {
            val weightStr = etWeight.text.toString()
            val heightStr = etHeight.text.toString()
            val ageStr = etAge.text.toString()

            if (weightStr.isNotEmpty() && heightStr.isNotEmpty() && ageStr.isNotEmpty()) {
                val weight = weightStr.toDouble()
                val height = heightStr.toDouble()
                val age = ageStr.toInt()

                val bmr = if (rbMale.isChecked) {
                    66.5 + (13.75 * weight) + (5.0 * height) - (6.75 * age)
                } else {
                    655.1 + (9.56 * weight) + (1.85 * height) - (4.68 * age)
                }

                val activityMultiplier = when (spinnerActivity.selectedItemPosition) {
                    0 -> 1.2
                    1 -> 1.375
                    2 -> 1.55
                    3 -> 1.725
                    else -> 1.9
                }

                tvBmrResult.text = "Zapotrzebowanie: ${(bmr * activityMultiplier).roundToInt()} kcal/dzień"
            } else {
                Toast.makeText(requireContext(), "Podaj wagę, wzrost i wiek!", Toast.LENGTH_SHORT).show()
            }
        }

        setupBmiChart(view)
    }

    private fun setupBmiChart(view: View) {
        val chart = view.findViewById<LineChart>(R.id.bmiChart)

        val entries = listOf(
            Entry(1f, 28.4f),
            Entry(2f, 26.5f),
            Entry(3f, 27.9f),
            Entry(4f, 27.1f),
            Entry(5f, 25.8f),
            Entry(6f, 24.9f),
        )

        val dataSet = LineDataSet(entries, "BMI").apply {
            color = Color.BLUE
            valueTextColor = Color.BLACK
            lineWidth = 2f
            circleRadius = 4f
            setDrawFilled(true)
        }

        chart.data = LineData(dataSet)
        chart.description.text = "Ostatnie 6 miesięcy"
        chart.xAxis.granularity = 1f
        chart.invalidate()
    }
}
