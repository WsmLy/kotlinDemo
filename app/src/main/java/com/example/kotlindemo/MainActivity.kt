package com.example.kotlindemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlindemo.grammar.circular.CircularActivity
import com.example.kotlindemo.grammar.select.SelectActivity
import com.example.kotlindemo.navigation.NavigationActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navigationDemo?.setOnClickListener {
            startActivity(Intent(this, NavigationActivity::class.java))
        }
        circularDemo?.setOnClickListener {
            startActivity(Intent(this, CircularActivity::class.java))
        }
        selectDemo?.setOnClickListener {
            startActivity(Intent(this, SelectActivity::class.java))
        }
    }
}