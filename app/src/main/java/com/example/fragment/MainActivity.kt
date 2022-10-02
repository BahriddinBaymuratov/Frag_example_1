package com.example.fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.fragment.fragment.Fragment_First
import com.example.fragment.fragment.Fragment_Second
import com.example.fragment.model.User

class MainActivity : AppCompatActivity(), Fragment_First.FirstListener,
Fragment_Second.SecondListener{
    private lateinit var firstFragment: Fragment_First
    private lateinit var secondFragment: Fragment_Second

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        firstFragment = Fragment_First()
        secondFragment = Fragment_Second()
        updateFragments()
    }

    override fun onFirstSend(user: User) {
        secondFragment.updateTextSecond(user)
    }

    override fun onSecondSend(user: User) {
        firstFragment.updateTextFirst(user)
    }

    private fun  updateFragments(){
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.frameFirst, firstFragment)
            replace(R.id.frameSecond, secondFragment)
            commit()
        }
    }
}