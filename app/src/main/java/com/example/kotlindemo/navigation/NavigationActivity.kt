package com.example.kotlindemo.navigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.ActivityNavigatorDestinationBuilder
import androidx.navigation.findNavController
import com.example.kotlindemo.R

class NavigationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation)
        findNavController(R.id.navigation_home)
    }
}