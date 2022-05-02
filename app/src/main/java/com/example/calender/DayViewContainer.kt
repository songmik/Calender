package com.example.calender

import android.view.View
import android.widget.TextView
import com.example.calender.databinding.ActivityMainBinding
import com.kizitonwose.calendarview.ui.ViewContainer

class DayViewContainer(view:View): ViewContainer(view) {

    private lateinit var binding: ActivityMainBinding

    val textView = view.findViewById<TextView>(R.id.calendarDayText)

    
}