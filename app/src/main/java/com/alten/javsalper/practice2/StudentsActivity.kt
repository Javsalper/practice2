package com.alten.javsalper.practice2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout

class StudentsActivity : AppCompatActivity() {

    private val NUM_FRAGMENTS = initializeStudents()
    val  students = mutableListOf<Student>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student)

        val view_pager = findViewById<ViewPager2>(R.id.view_pager)
        val tabLayout:TabLayout=findViewById(R.id.tabLayout)
        val adapter = ViewPagerAdapter(supportFragmentManager,lifecycle)
        view_pager.adapter = adapter

        val fragmentManager: FragmentManager = supportFragmentManager
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()

        for (i in 0 until NUM_FRAGMENTS) {
            val fragment: StudentsFragment = StudentsFragment.newInstance(student = [i])
            fragmentTransaction.add(androidx.fragment.R.id.fragment_container_view_tag, fragment)
        }

        fragmentTransaction.commit()
    }


        private fun initializeStudents() {

            val student1 = Student(
                "Jorge",
                "Fernandez",
                "302542130S",
                "jorge9@gmail.com",
                "San Pablo",
                "Huelva",
                "https://mir-s3-cdn-cf.behance.net/project_modules/max_1200/b826e129797915.560414c48512e.jpg",
                "Carlos Alberto Dorado"
            )
            val student2 = Student(
                "Nacho",
                "Fernandez",
                "302214409A",
                "Nfernandez@gmail.com",
                "San Fernando",
                "Huelva",
                "https://static.wikia.nocookie.net/esstarwars/images/9/9b/Princessleiaheadwithgun.jpg/revision/latest?cb=20150117214124",
                "Javier Rodriguez"
            )
            val student3 = Student(
                "Paco",
                "Fernandez",
                "302102102X",
                "Paco12@gmail.com",
                "CEU",
                "Sevilla",
                "https://us.123rf.com/450wm/jemastock/jemastock1608/jemastock160802715/60756136-hombre-dise%C3%B1o-plano-usando-el-tel%C3%A9fono-celular-de-la-ilustraci%C3%B3n-del-vector-del-icono.jpg",
                "Rafael Pedrós Pérez"
            )
            val student4 = Student(
                "Jesus",
                "Monje",
                "302908523C",
                "jesusmonje@gmail.com",
                "Las pitonisas",
                "Huelva",
                "https://lumiere-a.akamaihd.net/v1/images/ch-24--slide-mobile_53e6135a.jpeg?region=0,0,1024,626&width=960",
                "Juanjo Rejon Cabezas"
            )
            val student5 = Student(
                "Sara",
                "Magallanes",
                "301231760G",
                "saramagallanes@gmail.com",
                "Los Pajaritos",
                "Sevilla",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQKAPK7dlhYQ--QPa31d9Hnw2BZYJD3wHiEEQ&usqp=CAU",
                "Isaac de los Reyes Díaz"
            )
            val student6 = Student(
                "Alejandro",
                "Damas",
                "302536840B",
                "alexdamas@gmail.com",
                "Los gorriones",
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
                "https://s1.abcstatics.com/media/play/2020/04/03/228908-kxP--1200x630@abc.jpg",
                "Juanjo Rejon Cabezas"
            )
            val student8 = Student(
                "Luis",
                "Sanchez",
                "30274910H",
                "luissanchez@gmail.com",
                "Leones",
                "Huelva",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT2lYkAxNh-1oTWJ5idlvxduSfl4-TppqXV8g&usqp=CAU",
                "Javier Rodriguez"
            )
            val student9 = Student(
                "Javier",
                "Revilla",
                "30255117M",
                "javirevilla@gmail.com",
                "Los gatos Salvajes",
                "Sevilla",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQcBN7pCBnZjessttKbTZ6-ZvjmA3EIiLhICQ&usqp=CAU",
                "Isaac de los Reyes Díaz"
            )
            val student10 = Student(
                "Manuel",
                "Segun Lopez",
                "30397320N",
                "manuelsegun@gmail.com",
                "Las Pitonisas",
                "Huelva",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRSs_F8UBa53EITsD5DagcC60PHzcNQlca4QA&usqp=CAU",
                "Javier Rodriguez"
            )
            val student11 = Student(
                "David",
                "De la Fuente",
                "20104431Q",
                "DavidFuente@gmail.com",
                "Fuentes",
                "Sevilla",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR0_0Z6IE2q_r_mkqjslaKTQ2BBKEMmQw6xeQ&usqp=CAU",
                "Carlos Alberto Dorado"
            )
            val student12 = Student(
                "Lucia",
                "Martinez",
                "10199699P",
                "luciamartinez@gmail.com",
                "Las palomas",
                "Huelva",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTLIU_PQU2oNF2mS6BX5x08qtnmuN9IQ51ETQ&usqp=CAU",
                "Sergio Pérez Lopez"
            )
            val student13 = Student(
                "Maria",
                "Casado",
                "30588332Z",
                "mariacasado@gmail.com",
                "Los Salesianos",
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
        }



    }


