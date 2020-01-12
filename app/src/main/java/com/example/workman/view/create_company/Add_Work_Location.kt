package com.example.workman.view.create_company

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.workman.view.main.MainActivity
import com.example.workman.R
import com.example.workman.view.select_company.Select_company
import kotlinx.android.synthetic.main.activity_add__work__location.*

class Add_Work_Location : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add__work__location)

        // 취소 버튼눌렀을때 지금 화면은 사라지고 회사 선택화면으로 돌아간다.
        button_cancel.setOnClickListener {
            val intent = Intent(this, Select_company::class.java)
            startActivity(intent)
            finish()
        }

        // 생성하기 버튼을 눌렀을때 회사가 생성이 되고 메인 액티비티 화면으로 이동한다.
        button_create_company.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

}
