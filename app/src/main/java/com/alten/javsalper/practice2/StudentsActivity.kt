package com.alten.javsalper.practice2

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class StudentsActivity : AppCompatActivity() {

    private val NUM_FRAGMENTS = initializeStudents()


    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student)

        val viewPager = findViewById<ViewPager2>(R.id.StudentsActivityViewPager)
        val tabLayout = findViewById<TabLayout>(R.id.StudentsActivityTabLayout)
        val students=initializeStudents()
        val adapter = ViewPagerAdapter(supportFragmentManager,lifecycle, students)
        viewPager.adapter = adapter
        val calendarButton =findViewById<ImageView> (R.id.imgcalendarButtonActivityStudentsView)
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = students[position].name
        }.attach()

        calendarButton.setOnClickListener {

        val intent = Intent(this, AttendanceActivity::class.java)

            startActivity(intent)
        }
    }


        private fun initializeStudents(): List<Student> {
            val  students = mutableListOf<Student>()
            val student1 = Student(
                "Jorge",
                "Fernandez",
                "302542130S",
                "jorge9@gmail.com",
                "San Fernando",
                "Cadiz",
                "https://i.pinimg.com/originals/a9/6f/d4/a96fd473284ea6c3a4ae7dd1f5ba83b4.jpg",
                "Carlos Alberto Dorado"
            )
            val student2 = Student(
                "Nacho",
                "Fernandez",
                "302214409A",
                "Nfernandez@gmail.com",
                "San Fernando",
                "Cadiz",
                "https://static.wikia.nocookie.net/esstarwars/images/9/9b/Princessleiaheadwithgun.jpg/revision/latest?cb=20150117214124",
                "Javier Rodriguez"
            )
            val student3 = Student(
                "Paco",
                "Fernandez",
                "302102102X",
                "Paco12@gmail.com",
                "Fesac",
                "Sevilla",
                "https://us.123rf.com/450wm/jemastock/jemastock1608/jemastock160802715/60756136-hombre-dise%C3%B1o-plano-usando-el-tel%C3%A9fono-celular-de-la-ilustraci%C3%B3n-del-vector-del-icono.jpg",
                "Rafael Pedrós Pérez"
            )
            val student4 = Student(
                "Jesus",
                "Monje",
                "302908523C",
                "jesusmonje@gmail.com",
                "San Fernando",
                "Cadiz",
                "data:image/jpeg;base64,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5fx1xyuQGz2e0PiraA2z5Z+C1ME8uppTl7yr6xaLj7/ispZ75enhdwUodBMvpV7fs0zvEzg/AKLuPu+H91JPQa61RWDnFGfuvcP1KXH9yrn+ypiREWhgEREBERAREQEREBaPTUx2gjfj2RaCGxtJdM65BjuNwtbLjdbxFLG6u0csfVNNPS6ML8JnADG9SBvUb2v9Y+XetwERcuVpjjMfAiIuJCIiAiIgKOenOswaPij4zTsB9ljXSX+81vipGUJ9O+kcVVS04PzUTpXDheZ2FvvAiP3lHLwnxzeUcRoc+iff8SrGtP0c+034qvRTwPrDdln2D/6sfWidphsHAnE02BG7NZpPe2ZX9uuUREWlgdBoqS4Ha0eIyPwWwWi0LN6WEnmW/mP99q3qozmq9Hhy3iodvb7x/vwXc9EFcI9IhhOU8UkY7XttKP6Y3+K4hw3dhutjq9WmGrpZb22c0bnH7GIB/wDSXLmN1Y7yY7xsemkRFqeaIiICIiAiIgIiICIiAiIgIiICIiAiIgLQa66AbWUk0YhifNgeKZ0wts5CCA8PAJb7lv0QecqzUHSkRGKie4AWvCWSA24gMJd4gLFqtQNKzgtiopA62I7XDGCBnYF5AvfgvS6KEwku115srNPJGkNQtLw/OaOn74o9qB3mLFZaCpgfG7DKxzHerI1zT4OXtZUTQtcLPaHDk4AjwKlpS8UseQQQcxmCuqppg9jXDiPArrOkTQkor53/AOGiKBuFsL44GCN7QM3lzQG4ibnM3AsOC5avfTxyNbE95Dh6eMRdcWzYI3OyI+Haqs5b+Grgsx80az3ntXycXaRzyy7clnM0VVFoeKSpwHc/+EqMJ7jhss3R+qGkpyBHRyht83SsMQ77y4cu65VertoueOvKVdB677GmB0rPCZrNc00jZX443wmZhfYYQ8tY42Bscrb7LsdE6SjqImTRXwPvhva+RIzt3LjH6gM/g6e9NTS10cMETnVJmfT3iYxubARiAwWBtld2WZB7XRtDFBG2OGKONjfqQsa2ME5mzRbitTzqykREcEREBERAREQEREBERAREQEREBERAREQEREBERAVOAb7C/OyqRAREQEREBERAREQEREBERAREQEREBERAREQEREBERAREQEREBERAREQEREBERAREQEREH//Z",
                "Juanjo Rejon Cabezas"
            )
            val student5 = Student(
                "Sara",
                "Magallanes",
                "301231760G",
                "saramagallanes@gmail.com",
                "Fesac",
                "Sevilla",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQKAPK7dlhYQ--QPa31d9Hnw2BZYJD3wHiEEQ&usqp=CAU",
                "Isaac de los Reyes Díaz"
            )
            val student6 = Student(
                "Alejandro",
                "Damas",
                "302536840B",
                "alexdamas@gmail.com",
                "Fesac",
                "Sevilla",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTs_mbaU8rV6CQU3aPCowPFfNA2UggJ7f9ztQ&usqp=CAU",
                "Sergio Pérez Lopez"
            )
            val student7 = Student(
                "Javier",
                "Salguero",
                "30244710D",
                "javisalguero@gmail.com",
                "Fesac",
                "Sevilla",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTCufFffBE2RtXm8vuvYKuDWqUEZSeKxdfpYQ&usqp=CAU",
                "Juanjo Rejon Cabezas"
            )
            val student8 = Student(
                "Luis",
                "Sanchez",
                "30274910H",
                "luissanchez@gmail.com",
                "San Fernando",
                "Cadiz",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT2lYkAxNh-1oTWJ5idlvxduSfl4-TppqXV8g&usqp=CAU",
                "Javier Rodriguez"
            )
            val student9 = Student(
                "Javier",
                "Revilla",
                "30255117M",
                "javirevilla@gmail.com",
                "Fesac",
                "Sevilla",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQcBN7pCBnZjessttKbTZ6-ZvjmA3EIiLhICQ&usqp=CAU",
                "Isaac de los Reyes Díaz"
            )
            val student10 = Student(
                "Manuel",
                "Segun Lopez",
                "30397320N",
                "manuelsegun@gmail.com",
                "San Fernando",
                "Cadiz",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRSs_F8UBa53EITsD5DagcC60PHzcNQlca4QA&usqp=CAU",
                "Javier Rodriguez"
            )
            val student11 = Student(
                "David",
                "De la Fuente",
                "20104431Q",
                "DavidFuente@gmail.com",
                "Fesac",
                "Sevilla",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR0_0Z6IE2q_r_mkqjslaKTQ2BBKEMmQw6xeQ&usqp=CAU",
                "Carlos Alberto Dorado"
            )
            val student12 = Student(
                "Lucia",
                "Martinez",
                "10199699P",
                "luciamartinez@gmail.com",
                "San Fernando",
                "Cadiz",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTLIU_PQU2oNF2mS6BX5x08qtnmuN9IQ51ETQ&usqp=CAU",
                "Sergio Pérez Lopez"
            )
            val student13 = Student(
                "Maria",
                "Casado",
                "30588332Z",
                "mariacasado@gmail.com",
                "Fesac",
                "Sevilla",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTLNYlKK96ZIqoN7l3xZ9HjrsePs2X0eB24CQ&usqp=CAU",
                "Rafael Pedrós Pérez"
            )

            students.add(student1)
            students.add(student2)
            students.add(student3)
            students.add(student4)
            students.add(student5)
            students.add(student6)
            students.add(student7)
            students.add(student8)
            students.add(student9)
            students.add(student10)
            students.add(student11)
            students.add(student12)
            students.add(student13)
            return students
        }

}


