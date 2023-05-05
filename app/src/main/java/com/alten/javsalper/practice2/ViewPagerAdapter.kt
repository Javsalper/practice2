package com.alten.javsalper.practice2

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle,listStudent:List<Student>): FragmentStateAdapter(fragmentManager,lifecycle) {
    val students=listStudent
    override fun getItemCount(): Int {
        return students.size
    }

    override fun createFragment(position: Int): Fragment {
        return StudentsFragment.newInstance(students[position])
    }

}