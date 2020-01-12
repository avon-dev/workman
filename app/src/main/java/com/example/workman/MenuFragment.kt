package com.example.workman


import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_menu.*
import kotlinx.android.synthetic.main.fragment_menu.view.*

/**
 * 더보기
 */
class MenuFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val rootView = inflater.inflate(R.layout.fragment_menu, container, false)

        rootView.myprofilebutton.setOnClickListener {
            val nextIntent = Intent(activity, MyprofileActivity::class.java)
            startActivity(nextIntent)
        }

        rootView.companyprofilebutton.setOnClickListener {
            val nextIntent = Intent(activity, CompanyprofileActivity::class.java)
            startActivity(nextIntent)
        }

        rootView.employeebutton.setOnClickListener {
            val nextIntent = Intent(activity, EmployeeActivity::class.java)
            startActivity(nextIntent)
        }

        rootView.vacationbutton.setOnClickListener {
            val nextIntent = Intent(activity, VacationActivity::class.java)
            startActivity(nextIntent)
        }


        return rootView
    }
}
