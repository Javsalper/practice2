package com.alten.javsalper.practice2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide

class StudentsFragment : Fragment() {

    companion object {
        fun newInstance(student: Student): StudentsFragment {
            val args = Bundle()
            args.putString("name", student.name)
            args.putString("surname", student.surname)
            args.putString("email", student.email)
            args.putString("city", student.city)
            args.putString("center", student.center)
            args.putString("tutor", student.tutor)
            args.putString("photoUrl",student.photoUrl)

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
        val studentImageView = view.findViewById<ImageView>(R.id.imgStudentsActivityUserView)



        val studentname = arguments?.getString("name")
        val studentsurname = arguments?.getString("surname")
        val studentemail = arguments?.getString("email")
        val studentcity = arguments?.getString("city")
        val studentcenter = arguments?.getString("center")
        val studenttutor = arguments?.getString("tutor")
        val imageStudent = arguments?.getString("photoUrl")


        studentTextViewName.text=studentname
        studentTextViewSurname.text=studentsurname
        studentTextViewEmail.text=studentemail
        studentTextViewCity.text=studentcity
        studentTextViewCenter.text=studentcenter
        studentTextViewTutor.text=studenttutor

        //Indicas a Glide que imagen cargar y en que vista.
        Glide.with(requireContext())
            .load(imageStudent)
            .into(studentImageView)

        return view
    }

}