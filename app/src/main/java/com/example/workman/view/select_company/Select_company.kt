package com.example.workman.view.select_company

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.workman.R
import com.example.workman.view.Joining_Work.Joining_Work
import com.example.workman.view.create_company.Create_Company
import kotlinx.android.synthetic.main.activity_select_company.*

class Select_company : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_company)


        // 회사 만들기 클릭하였을때 회사 만들기 화면으로 이동한다.
        button_create_company.setOnClickListener {
            val intent = Intent(this, Create_Company::class.java)
            startActivity(intent)
        }

        // 직장 합류하기 버튼 눌렀을때 직장 합류하기 화면으로 이동한다.
        button_joining_work.setOnClickListener {
            val intent = Intent(this, Joining_Work::class.java)
            startActivity(intent)
        }
    }
}
