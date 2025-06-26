package com.example.open_sourcepart2

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.open_sourcepart2.databinding.ActivityPiechartBinding
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.utils.ColorTemplate


class Piechart : AppCompatActivity() {


        private lateinit var binding: ActivityPiechartBinding
        private lateinit var pieChart: PieChart

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)

            // Setup view binding
            binding = ActivityPiechartBinding.inflate(layoutInflater)
            setContentView(binding.root)

            // Reference the pie chart
            pieChart = binding.ViewPieChart

            // 1. Get expenses from your DB (replace this with real DB call)
            val expenses = getExpensesFromDB()

            // 2. Group by category name and sum the amounts
            val grouped = expenses.groupBy { it.categoryName }
                .mapValues { entry -> entry.value.sumOf { it.amount } }

            // 3. Create Pie Entries
            val pieEntries = ArrayList<PieEntry>()
            for ((category, total) in grouped) {
                pieEntries.add(PieEntry(total.toFloat(), category))
            }

            // 4. Setup PieDataSet
            val dataSet = PieDataSet(pieEntries, "Expenses by Category")
            dataSet.colors = ColorTemplate.COLORFUL_COLORS.toList()
            dataSet.valueTextColor = Color.BLACK
            dataSet.valueTextSize = 14f

            // 5. Set Data on Chart
            val pieData = PieData(dataSet)
            pieChart.data = pieData
            pieChart.description.isEnabled = false
            pieChart.centerText = "Expense Breakdown"
            pieChart.animateY(1000)
            pieChart.invalidate() // refresh chart
        }

        // Replace this with your actual database fetch logic
        private fun getExpensesFromDB(): List<ExpenseWithCategory> {
            // Example static data — replace with real DB query
            return listOf(
                ExpenseWithCategory(1, 200.0, "", "", 1, 1, null, "", "#FF0000"),
                ExpenseWithCategory(2, 100.0, "", "", 2, 1, null, "", "#00FF00"),
                ExpenseWithCategory(3, 50.0, "", "", 3, 1, null, "", "#0000FF"),
                ExpenseWithCategory(4, 75.0, "", "", 2, 1, null, "", "#00FF00")
            )
        }
    }
