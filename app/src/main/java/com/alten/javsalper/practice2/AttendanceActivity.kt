package com.alten.javsalper.practice2

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.alten.javsalper.practice2.Month.Companion.CadizCalendar
import com.alten.javsalper.practice2.Month.Companion.SevilleCalendar
import com.bumptech.glide.Glide

const val EXTRA_STUDENT_POSITION = "position_student"
class AttendanceActivity : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.O)
    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
      super.onCreate(savedInstanceState)
      supportActionBar?.hide()
      setContentView(R.layout.activity_attendance)

     // recyclerView =findViewById(R.id.recyclerView>()


     //  val colapsedtoolbarbutton = findViewById<FloatingActionButton>(R.id.fooColapsed2)
     //  val toolbar = findViewById<Toolbar>(R.id.toolbarLayout)
     //  val tab = findViewById<FloatingActionButton>(R.id.tabColapsed2)
     //  val appBarLayout = findViewById<AppBarLayout>(R.id.coordinatorlayout)
     //  val btncalendar = findViewById<FloatingActionButton>(R.id.floatingActionButton)
     //  val coordinatorLayout = findViewById<CoordinatorLayout>(com.google.android.material.R.id.coordinatorlayout)
       val studentPosition = intent.getIntExtra(  EXTRA_STUDENT_POSITION, 0)
       val student = students[studentPosition]
       val daysCalendar = SevilleCalendar()
       val dayCalendar = CadizCalendar()

     //  val colapsingtoolbar = findViewById<CollapsingToolbarLayout>(R.id.collapsingToolbar)
        val textView = findViewById<TextView>(R.id.student_name_textview)
        textView.text= " "+ students [studentPosition].name+" "+ students [studentPosition].surname

      val studentPhoto = findViewById<ImageView>(R.id.imgAttendanceActivityUserView)
      val recycler = findViewById<RecyclerView>(R.id.recyclerView)
        recycler.layoutManager= LinearLayoutManager(this)
        recycler.adapter = MonthAdapter(daysCalendar)
        //recycler.adapter = MonthAdapter(students)

       // colapsingtoolbar.title = Student.creatUser() [StudentPosition].name + Student.creatUser()[StudentPosition].lastName
        Glide.with(studentPhoto.context)
            .load(students[studentPosition].photoUrl)
            .into(studentPhoto)

      }
     // val volverButton = findViewById<Button> (R.id.buttonregresar)




}