package com.example.kotlindemo.navigation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.kotlindemo.R
import kotlinx.android.synthetic.main.navigation_fragment_menu1.*

class Menu1Fragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?)
    : View? {
        return inflater.inflate(R.layout.navigation_fragment_menu1, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        clickableText.setOnClickListener {
            findNavController().navigate(R.id.navigation_fragment_menu2)
        }
    }
}