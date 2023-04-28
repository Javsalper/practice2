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
        val studentMap = mapOf(
            "302542130S" to 0,
            "302214409A" to 1,
            "302102102X" to 2,
            "302908523C" to 3,
            "301231760G" to 4,
            "302536840B" to 5,
            "30244710D" to 6,
            "30274910H" to 7,
            "30255117M" to 8,
            "30397320N" to 9,
            "20104431Q" to 10,
            "10199699P" to 11,
            "30588332Z" to 12,
        )

        val dni = "" // DNI del estudiante que desea encontrar

        val studentPosition = studentMap[dni] ?: -1 // Obtiene la posición del estudiante si se encuentra en el mapa, de lo contrario devuelve -1

        return if (studentPosition >= 0) {
            StudentsFragment.newInstance(Student(dni = dni, name = dni, surname = dni,email =dni,center =dni,city =dni, photoUrl = dni,tutor =dni))
        } else {
            Fragment()
        }
    }

}