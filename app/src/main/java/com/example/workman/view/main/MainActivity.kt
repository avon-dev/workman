package com.example.workman.view.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.workman.*
import com.example.workman.view.alarm.AlarmFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

/**
 * 프래그먼트들의 베이스인 MainActivity
 */
class MainActivity : AppCompatActivity() {

    private val navListener = BottomNavigationView.OnNavigationItemSelectedListener {

        var selectedFragment: Fragment? = null

        when(it.itemId) {
            R.id.navigation_home -> selectedFragment =
                HomeFragment()
            R.id.navigation_schedule -> selectedFragment =
                ScheduleFragment()
            R.id.navigation_time -> selectedFragment =
                TimeFragment()
            R.id.navigation_alarm -> selectedFragment =
                AlarmFragment()
            R.id.navigation_menu -> selectedFragment =
                MenuFragment()
        }

        selectedFragment?.let { it1 ->
            supportFragmentManager.beginTransaction().replace(
                R.id.container,
                it1
            ).commit()
        }

        true

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNav = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        bottomNav.setOnNavigationItemSelectedListener(navListener)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction().replace(
                R.id.container,
                HomeFragment()
            ).commit()
        }
    }
}
