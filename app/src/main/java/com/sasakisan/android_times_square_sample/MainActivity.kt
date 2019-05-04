package com.sasakisan.android_times_square_sample

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.squareup.timessquare.CalendarPickerView
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val calendar = findViewById<CalendarPickerView>(R.id.calendar_view)
        val maxDate = Calendar.getInstance()
        val minDate = Calendar.getInstance()
        val today = Date()

        maxDate.set(2100, 12, 1, 0, 0)
        minDate.set(1900, 0, 1, 0, 0)

        calendar.init(minDate.time, maxDate.time)
            .withSelectedDate(today)
//            .inMode(CalendarPickerView.SelectionMode.RANGE) // <- これをつけると範囲指定できる
        calendar.setOnDateSelectedListener(object : CalendarPickerView.OnDateSelectedListener {
            override fun onDateSelected(date: Date?) {
                val simpleDateFormat = SimpleDateFormat("yyyy年MM月dd日", Locale.JAPAN)
                date?.let {
                    Toast.makeText(this@MainActivity, simpleDateFormat.format(it.time), Toast.LENGTH_SHORT).show()
                }
            }

            override fun onDateUnselected(date: Date?) {
            }
        })
    }
}
