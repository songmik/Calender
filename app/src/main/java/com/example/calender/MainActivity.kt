package com.example.calender

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import com.example.calender.databinding.ActivityMainBinding
import com.example.calender.databinding.CalendarDayLayoutBinding
import com.kizitonwose.calendarview.model.CalendarDay
import com.kizitonwose.calendarview.ui.DayBinder
import com.kizitonwose.calendarview.ui.ViewContainer
import java.time.YearMonth
import java.time.temporal.WeekFields
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    @SuppressLint("NewApi")
    override fun onCreate(savedInstanceState: Bundle?) {

        binding = ActivityMainBinding.inflate(layoutInflater)

        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.calendarView.dayBinder = object : DayBinder<DayViewContainer>{
            @SuppressLint("NewApi")
            override fun bind(container: DayViewContainer, day: CalendarDay) {
                container.textView.text = day.date.dayOfMonth.toString()
            }

            override fun create(view: View) = DayViewContainer(view)

        }

        val currentMonth = YearMonth.now()
        val firstMonth = currentMonth.minusMonths(10)
        val lastMonth = currentMonth.plusMonths(10)
        val firstDayOfWeek = WeekFields.of(Locale.getDefault()).firstDayOfWeek

        binding.calendarView.setup(firstMonth, lastMonth, firstDayOfWeek)
        binding.calendarView.scrollToMonth(currentMonth)



    }

    @SuppressLint("NewApi")
    inner class DayViewContainer(view: View) :ViewContainer(view) {
        val textView = CalendarDayLayoutBinding.bind(view).calendarDayText



    }


}