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

class Fragment_First : Fragment() {

    private lateinit var textView: TextView
    private lateinit var editName: AppCompatEditText
    private lateinit var editLastName: AppCompatEditText
    private lateinit var editAge: AppCompatEditText
    private var firstListener: FirstListener? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        textView = view.findViewById(R.id.text_first)
        editName = view.findViewById(R.id.editName)
        editLastName = view.findViewById(R.id.editLastName)
        editAge = view.findViewById(R.id.editAge)
        val btn: Button = view.findViewById(R.id.b_first)
        btn.setOnClickListener {
            val name = editName.text.toString().trim()
            val lastName = editLastName.text.toString().trim()
            val age = editAge.text.toString().toInt()
            val user = User(name, lastName, age)
            firstListener?.onFirstSend(user)
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        firstListener = if (context is FirstListener) {
            context
        } else {
            throw  RuntimeException("Error")
        }
    }

    override fun onDetach() {
        super.onDetach()
        firstListener = null
    }

    fun updateTextFirst(user: User){
        textView.text = "${user.name}\n${user.lastName}\n${user.age}"
    }

    interface FirstListener {
        fun onFirstSend(user: User)
    }

}