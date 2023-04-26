package com.alten.javsalper.practice2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class StudentsFragment : Fragment() {

    companion object {
        fun newInstance(student: Student): StudentsFragment {
            val args = Bundle()
            args.putString("dni", student.dni)
            val fragment = StudentsFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_students, container, false)
        val studentTextViewName = view.findViewById<TextView>(R.id.StudentsActivityLabelName)
        val studentTextViewSurname = view.findViewById<TextView>(R.id.StudentsActivityLabelSurname)
        val studentTextViewEmail = view.findViewById<TextView>(R.id.StudentsActivityLabelEmail)
        val studentTextViewCity = view.findViewById<TextView>(R.id.StudentsActivityLabelCity)
        val studentTextViewCenter = view.findViewById<TextView>(R.id.StudentsActivityLabelCenter)
        val studentTextViewTutor = view.findViewById<TextView>(R.id.StudentsActivityLabelTutor)

        val student1 = arguments?.getString("dni")
       // studentTextView.text = student1
        return view
    }

}