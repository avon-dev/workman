package com.example.workman

import android.content.Context
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.HorizontalScrollView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_schedule_detail.*
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

class ScheduleDetail : AppCompatActivity() {
    val DATE_FORMAT : String = "yyyy MMMM"
    var dateFormat : String = ""
    val currentDate = Calendar.getInstance()
    val cell = arrayListOf<Date>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_schedule_detail)
        dateFormat = DATE_FORMAT

        val calendar = currentDate.clone() as Calendar

        // update 달력 타이틀
        val sdf : DateFormat = SimpleDateFormat(dateFormat)
        calendar_test.setText(sdf.format(currentDate.time))
        calendar_test2.setText("월일수 "+currentDate.getActualMaximum(Calendar.DAY_OF_MONTH))

        // 이전달 클릭
        calendar_prev_text1.setOnClickListener {
            currentDate.add(Calendar.MONTH,-1)
            calendar_test.setText(sdf.format(currentDate.time))
            calendar_test2.setText("월일수 "+currentDate.getActualMaximum(Calendar.DAY_OF_MONTH))
        }

        // 다음달 클릭
        calendar_next_text1.setOnClickListener {
            currentDate.add(Calendar.MONTH,1)
            calendar_test.setText(sdf.format(currentDate.time))
            calendar_test2.setText("월일수 "+currentDate.getActualMaximum(Calendar.DAY_OF_MONTH))
        }

        // 셀채우기
        var i : Int = 0
        while(cell.size < 11) {
            if(i == 0){
                cell.add(currentDate.time)
            }
            else {
                calendar.set(Calendar.DAY_OF_MONTH, i)
                cell.add(calendar.time)
            }
            i++
        }

        calendar_recyclerview1.setHasFixedSize(true)
        calendar_recyclerview1.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        calendar_recyclerview1.adapter = CalendarAdapter(this,cell)

    }
}
class CalendarAdapter(private val context: Context, private val list: ArrayList<Date>) : RecyclerView.Adapter<CalendarAdapter.ViewHolder>(){
    val DATE_FORMAT : String = "d"
    val DATE_FORMAT2 : String = "E"
    var dateFormat : String = ""
    val currentDate = Calendar.getInstance()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(context)
            .inflate(R.layout.item_view_calendar1,parent,false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        dateFormat = DATE_FORMAT
        val sdf : DateFormat = SimpleDateFormat(dateFormat)
        val sdf2 : DateFormat = SimpleDateFormat(DATE_FORMAT2)
        val calendar = currentDate.clone() as Calendar
        calendar.timeInMillis = list[position].time
        //holder.day_of_week.setText(""+sdf.format(list[position].time))
        //holder.day.setText(""+list[position].day)

        // 요일 색깔넣기
        if(sdf2.format(calendar.time).equals("토")) {
            holder.day_of_week.setTextColor(Color.BLUE)
        }else if(sdf2.format(calendar.time).equals("일")){
            holder.day_of_week.setTextColor(Color.RED)
        }else {

        }

        // 날짜&요일 넣기
        if(position == 0) {
            holder.day.setText("일자")
            holder.day_of_week.setText("요일")
        }else{
            holder.day.setText(sdf.format(list[position].time))
            holder.day_of_week.setText(sdf2.format(calendar.time))
        }

    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),View.OnClickListener {
        var day_of_week : TextView
        var day : TextView

        init {
            day_of_week = itemView.findViewById(R.id.ItemViewCalendar1_TextView2)
            day = itemView.findViewById(R.id.ItemViewCalendar1_TextView1)
        }
        override fun onClick(v: View?) {

        }

    }

}

