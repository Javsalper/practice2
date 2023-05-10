package com.alten.javsalper.practice2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class MonthAdapter(private val days: List<Month>): RecyclerView.Adapter<MonthAdapter.MonthViewHolder>() {

    class MonthViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val textView: TextView

        init {

            textView = view.findViewById(R.id.itemAttendanceDayTextView)
        }

        fun bind(month: Month){
            textView.text = month.day+ " "+ month.month

        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MonthViewHolder {
        val user: View = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_attendance_day, parent, false)
        return MonthViewHolder(user)
    }

   override fun onBindViewHolder(holder: MonthViewHolder, position: Int) {
        holder.bind(days[position])
    }

    override fun getItemCount(): Int {
        return days.size
    }
}
