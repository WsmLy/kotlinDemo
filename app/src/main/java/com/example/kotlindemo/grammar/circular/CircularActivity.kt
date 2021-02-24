package com.example.kotlindemo.grammar.circular

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.kotlindemo.R
import kotlinx.android.synthetic.main.activity_circular.*

class CircularActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_circular)
        for (i in 0..9) {
            var textView : TextView = TextView(this)
            textView.text = "第 $i 项"
            rootView.addView(textView)
        }
        var array = listOf(10,9,8,7,6,5,4,3,2,1)
        for (i: Int in array) {
            var textView = TextView(this)
            textView.text = "Item $i"
            rootView.addView(textView)
        }
        var j = 0
        while (j < 10) {
            var textView = TextView(this)
            textView.text = "第 $j 条"
            rootView.addView(textView)
            j ++
        }
    }
}