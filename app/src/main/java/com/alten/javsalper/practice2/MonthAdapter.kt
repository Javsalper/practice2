package com.alten.javsalper.practice2

import android.view.LayoutInflater
import android.view.ViewGroup

class MonthAdapter (
    private val month: List<com.example.studentsactivity.Month>) {
    RecyclerView.Adapter<MonthAdapter.MonthViewHolder>()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MonthAdapter.MonthViewHolder {
        val view = LayoutInflater.from(parent.context).inflate()
        return MonthViewHolder(view)
    }



}