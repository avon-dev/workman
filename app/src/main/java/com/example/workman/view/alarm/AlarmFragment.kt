package com.example.workman.view.alarm


import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.workman.R
import com.example.workman.view.Create_Alarm.Create_Alarm
import kotlinx.android.synthetic.main.fragment_alarm.*

/**
 * 알람
 */
class AlarmFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_alarm, container, false)



    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        floatingActionButton_Create_Alarm.setOnClickListener (object : View.OnClickListener{
            override fun onClick(v: View?) {
                val intent = Intent(context,Create_Alarm::class.java)
                startActivity(intent)
            }

        })
    }


}
