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

    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_student)

        val viewPager = findViewById<ViewPager2>(R.id.StudentsActivityViewPager)
        val tabLayout = findViewById<TabLayout>(R.id.StudentsActivityTabLayout)

        val adapter = ViewPagerAdapter(supportFragmentManager, lifecycle, students)
        viewPager.adapter = adapter
        val calendarButton = findViewById<ImageView>(R.id.imgcalendarButtonActivityStudentsView)
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = students[position].name + "." + students[position].surname
        }.attach()

        calendarButton.setOnClickListener {
            val position=viewPager.currentItem
            val intent = Intent(this, AttendanceActivity::class.java)
            intent.putExtra( EXTRA_STUDENT_POSITION, position)
            startActivity(intent)
        }
    }

}


