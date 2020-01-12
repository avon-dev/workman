package com.example.workman

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.workman.View.LoginActivity

class StartPageActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start_page)

        Handler().postDelayed({
            startActivity(Intent(this, LoginActivity::class.java))

        }, 2000)

    }
}
