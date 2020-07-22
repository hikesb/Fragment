package com.example.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment

class BlankFragment : Fragment() {

    var listener: EventListener? = null
    private lateinit var editText: EditText
    private lateinit var textView: TextView
    private lateinit var button: Button

    companion object {
        @JvmStatic
        fun newInstance(): BlankFragment {
            val fragment = BlankFragment()
            val bundle = Bundle()
            fragment.arguments = bundle
            return fragment
        }
    }

    fun receive(data: String){
        if(isAdded)
            textView.text = data
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            listener = context as EventListener
        } catch (e: ClassCastException){
            e.stackTrace
        }
    }

    override fun onDetach() {
        listener = null
        super.onDetach()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_blank, container, false)
        editText = view.findViewById(R.id.edit_text_fragment)
        textView = view.findViewById(R.id.text_view_fragment)
        button = view.findViewById(R.id.button_fragment)
        button.setOnClickListener { listener?.event(editText.text.toString()) }
        return view
    }

    interface EventListener{
        fun event(data: String)
    }

}