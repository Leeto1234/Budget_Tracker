package com.example.open_sourcepart2


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.open_sourcepart2.databinding.FragmentAnalyticsBinding
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.components.LimitLine
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter
import android.graphics.Color

class AnalyticsFragment : Fragment() {

    private var _binding: FragmentAnalyticsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAnalyticsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val db = DatabaseHelper(requireContext())
        val expenses = db.getAllExpenses()

        Log.d("BudgetDebug", "Expenses loaded: ${expenses.size}")

        val categoryTotals = expenses.groupBy { it.categoryName }
            .mapValues { it.value.sumOf { it.amount } }

        if (categoryTotals.isNotEmpty()) {
            setupBarChart(binding.barChart, categoryTotals)
        } else {
            Log.d("BudgetDebug", "No data to display in chart")
        }
    }

    private fun setupBarChart(barChart: BarChart, categoryExpenses: Map<String, Double>) {
        val entries = categoryExpenses.entries.mapIndexed { index, entry ->
            BarEntry(index.toFloat(), entry.value.toFloat())
        }

        val dataSet = BarDataSet(entries, "Expenses by Category")
        dataSet.color = Color.parseColor("#2196F3")

        val barData = BarData(dataSet)
        barData.barWidth = 0.8f

        barChart.data = barData
        barChart.setFitBars(true)
        barChart.description.isEnabled = false
        barChart.axisRight.isEnabled = false

        val xAxis = barChart.xAxis
        xAxis.valueFormatter = IndexAxisValueFormatter(categoryExpenses.keys.toList())
        xAxis.position = XAxis.XAxisPosition.BOTTOM
        xAxis.setDrawGridLines(false)
        xAxis.granularity = 1f
        xAxis.labelRotationAngle = -45f

        val yAxis = barChart.axisLeft
        yAxis.axisMinimum = 0f

        // Highlight max and min
        val maxValue = categoryExpenses.maxOf { it.value }.toFloat()
        val minValue = categoryExpenses.minOf { it.value }.toFloat()

        val maxLine = LimitLine(maxValue, "Max: $maxValue")
        maxLine.lineColor = Color.RED
        maxLine.lineWidth = 2f
        maxLine.textColor = Color.RED

        val minLine = LimitLine(minValue, "Min: $minValue")
        minLine.lineColor = Color.GREEN
        minLine.lineWidth = 2f
        minLine.textColor = Color.GREEN

        yAxis.removeAllLimitLines()
        yAxis.addLimitLine(maxLine)
        yAxis.addLimitLine(minLine)

        barChart.invalidate()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}