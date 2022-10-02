package com.example.fragment.fragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.widget.AppCompatEditText
import androidx.appcompat.widget.AppCompatTextView
import com.example.fragment.R
import com.example.fragment.model.User

class Fragment_Second : Fragment() {

    private lateinit var textView: TextView
    private lateinit var editName: AppCompatEditText
    private lateinit var editLastName: AppCompatEditText
    private lateinit var editAge: AppCompatEditText
    private var secondListener: SecondListener? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment__second, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        textView = view.findViewById(R.id.text_second)
        editName = view.findViewById(R.id.editName)
        editLastName = view.findViewById(R.id.editLastName)
        editAge = view.findViewById(R.id.editAge)
        val btn: Button = view.findViewById(R.id.b_second)
        btn.setOnClickListener {
            val name = editName.text.toString().trim()
            val lastName = editLastName.text.toString().trim()
            val age = editAge.text.toString().toInt()
            val user = User(name, lastName, age)
            secondListener?.onSecondSend(user)
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        secondListener = if (context is SecondListener) {
            context
        } else {
            throw  RuntimeException("Error")
        }
    }

    override fun onDetach() {
        super.onDetach()
        secondListener = null
    }

    fun updateTextSecond(user: User){
        textView.text = "${user.name}\n${user.lastName}\n${user.age}"
    }
    interface SecondListener {
        fun onSecondSend(user: User)
    }


}