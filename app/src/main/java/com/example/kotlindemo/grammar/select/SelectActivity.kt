package com.example.kotlindemo.grammar.select

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlindemo.R
import kotlinx.android.synthetic.main.activity_select.*

class SelectActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select)

        sure.setOnClickListener {
            var startNum: Int = start.text.toString().toInt()
            when(startNum) {
                0, 1 -> print("x是0或1\n")
                2 -> print("x是2\n")
                in 3..11 -> print("x在3到11之间\n")
                !in 12..18 -> print("x不在12到18之间\n")
//                is String -> print("x是字符串格式\n")
                else -> print("其他\n")
            }
            var endNum: Int = end.text.toString().toInt()
            if (startNum > endNum) {
                var i = startNum
                startNum = endNum
                endNum = i
            }
            if (10 in startNum..endNum) {
                print("10在输入的两个数字中间\n")
            } else {
                print("10不在输入的两个数字中间\n")
            }
            if (100 < startNum) {
                print("100小于左边\n")
            }
            if (100 > endNum) {
                print("100大于右边\n")
            }
        }
    }
}