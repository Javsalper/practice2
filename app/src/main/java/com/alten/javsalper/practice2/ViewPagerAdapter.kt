package com.alten.javsalper.practice2

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle): FragmentStateAdapter(fragmentManager,lifecycle) {
    override fun getItemCount(): Int {
        return itemCount
    }

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0->{
                StudentsFragment.newInstance(Student(dni = ""))//de la posicion del dni del estudiante sin usar when
            }
            1->{
                StudentsFragment.newInstance(Student(dni = ""))
            }
            2->{
                StudentsFragment.newInstance(Student(dni = ""))
            }
            3->{
                StudentsFragment.newInstance(Student(dni = ""))
            }
            4->{
                StudentsFragment.newInstance(Student(dni = ""))
            }
            else->{
                Fragment()
            }
        }
    }
}