package com.alten.javsalper.practice2

import android.content.DialogInterface.OnClickListener
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class MonthAdapter(private val days: List<Month>, private val islinearmode:Boolean, private val listener: MonthItemListener): RecyclerView.Adapter<MonthAdapter.MonthViewHolder>() {

    class MonthViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val textView: TextView

        init {

            textView = view.findViewById(R.id.itemAttendanceDayTextView)
        }

        fun bind(month: Month,islinearmode: Boolean,listener: MonthItemListener){
            textView.setOnClickListener{
                listener.onClickListener(adapterPosition)
            }
            textView.setOnLongClickListener{
                listener.onLongClickListener(adapterPosition)
            }
            if (islinearmode) {
                textView.text = month.day + " " + month.month + " " + month.dayType
                //textView.setTextColor()
            }else{
                textView.text = month.shortDay
            }
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MonthViewHolder {
        val user: View = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_attendance_day, parent, false)
        return MonthViewHolder(user)
    }

   override fun onBindViewHolder(holder: MonthViewHolder, position: Int) {
        holder.bind(days[position],islinearmode,listener)
    }

    override fun getItemCount(): Int {
        return days.size
    }
}
