package com.example.workman

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.prolificinteractive.materialcalendarview.CalendarDay
import com.prolificinteractive.materialcalendarview.MaterialCalendarView
import com.prolificinteractive.materialcalendarview.MaterialCalendarView.*
import com.prolificinteractive.materialcalendarview.OnDateSelectedListener
import com.prolificinteractive.materialcalendarview.OnRangeSelectedListener
import kotlinx.android.synthetic.main.activity_reqvacation.*

class ReqvacationActivity : AppCompatActivity(), OnDateSelectedListener, OnRangeSelectedListener {
    override fun onDateSelected(
        widget: MaterialCalendarView,
        date: CalendarDay,
        selected: Boolean
    ) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onRangeSelected(widget: MaterialCalendarView, dates: MutableList<CalendarDay>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private val sundayDecorator:SundayDecorator = SundayDecorator()
    private val saturdayDecorator:SaturdayDecorator = SaturdayDecorator()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reqvacation)

        RV_calendarView.selectionMode = SELECTION_MODE_RANGE
        RV_calendarView.addDecorators(sundayDecorator,saturdayDecorator)
        RV_calendarView.setOnRangeSelectedListener(this)
        RV_calendarView.setOnDateChangedListener(this)
    }
}
