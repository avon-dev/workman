package com.example.workman.view.create_company

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import com.example.workman.R
import com.example.workman.view.select_company.Select_company
import kotlinx.android.synthetic.main.activity_create__company.*

class Create_Company : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create__company)

        // 회사 인원수를 정하는 스피너 셋팅
        val spinner_personnel = findViewById<Spinner>(R.id.spinner_personnel)
        val spinner_adapter = ArrayAdapter.createFromResource(this,R.array.Number_of_people,android.R.layout.simple_spinner_item)

        // 인원수 스피너에 아답터 연결
        spinner_personnel.adapter = spinner_adapter
        spinner_personnel.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {

            }

        }

        // 취소 버튼 눌렀을떄 회사 선택화면으로 이동하고 지금 화면은 없어진다.
        button_cancel.setOnClickListener {
            val intent = Intent(this,Select_company::class.java)
            startActivity(intent)
            finish()
        }

        // 다음 버튼 눌렀을때 직장위치 추가하기 화면으로 이동한다.
        button_next.setOnClickListener {
            val intent = Intent(this,Add_Work_Location::class.java)
            startActivity(intent)
        }
    }
}
