package com.alten.javsalper.practice2

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
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
       //val shortDay = DayOfWeekState(day, month,year)

      //  val colapsingtoolbar = findViewById<CollapsingToolbarLayout>(R.id.collapsingToolbar)
        val textView = findViewById<TextView>(R.id.AttendenceActivityTextviewNameAndSurname)
        textView.text= " "+ students [studentPosition].name+" "+ students [studentPosition].surname
      val calendarModeButton = findViewById<ImageView>(R.id.imgVerticalButtonActivityAttendanceActivityView)
      val studentPhoto = findViewById<ImageView>(R.id.imgAttendanceActivityUserView)
      val recycler = findViewById<RecyclerView>(R.id.recyclerView)
      val returnButton = findViewById<ImageView>(R.id.imgAttendanceActivityReturn)
        var islinearMode: Boolean = true
        val linearLayoutManager = LinearLayoutManager(this)
        recycler.layoutManager = linearLayoutManager

        val monthItemListener = object: MonthItemListener {
            override fun onClickListener(position: Int) {
                //return onClickListener(position)
            }

            override fun onLongClickListener(position: Int): Boolean {
                //  return super.onLongClickListener(position)
                return true
            }

        }

        recycler.adapter = MonthAdapter(daysCalendar,islinearMode, monthItemListener)

        calendarModeButton.setOnClickListener {

            if (islinearMode) {

                val gridLayoutManager = GridLayoutManager(this, 5)
                recycler.layoutManager = gridLayoutManager
               // VerticalButton.text = "Cambiar a Linear"
            } else {

                val linearLayoutManager = LinearLayoutManager(this)
                recycler.layoutManager = linearLayoutManager
                //VerticalButton.text = "Cambiar a Grid"
            }

            islinearMode = !islinearMode
            recycler.adapter = MonthAdapter(daysCalendar,islinearMode, monthItemListener)
        }

        // recycler.layoutManager= LinearLayoutManager(this)



        //recycler.adapter = MonthAdapter(students)

       // colapsingtoolbar.title = Student.creatUser() [StudentPosition].name + Student.creatUser()[StudentPosition].lastName
        Glide.with(studentPhoto.context)
            .load(students[studentPosition].photoUrl)
            .into(studentPhoto)

        returnButton.setOnClickListener {

            val intent = Intent(this, StudentsActivity::class.java)
            startActivity(intent)
            finish()
        }
        }



}