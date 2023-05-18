package com.alten.javsalper.practice2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
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

            }else{
                textView.text = month.shortDay
            }

            val textColor = when (month.dayType) {
                "Formación" -> ContextCompat.getColor(textView.context, R.color.green)
                "Vacaciones" -> ContextCompat.getColor(textView.context, R.color.red)
                "Centro" -> ContextCompat.getColor(textView.context, R.color.yellow)
                "Descanso" -> ContextCompat.getColor(textView.context, R.color.blue)
                else -> ContextCompat.getColor(textView.context, R.color.black)
            }

            textView.setTextColor(textColor)
        }

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MonthViewHolder {
        val user: View = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_attendance_day, parent, false)
        return MonthViewHolder(user)
    }

    private val undoneChanges: MutableList<Pair<Month, String>> = mutableListOf()
   override fun onBindViewHolder(holder: MonthViewHolder, position: Int) {
       val month = days[position]
       holder.bind(month, islinearmode, listener)

    /*   val undoneChange = undoneChanges.find { it.first == month }
       if (undoneChange != null) {
           month.dayType = undoneChange.second
           undoneChanges.remove(undoneChange)
       }*/
    }

    override fun getItemCount(): Int {
        return days.size
    }
    fun updateDayType(month: Month, newDayType: String) {

        month.dayType = newDayType
        notifyDataSetChanged()
    }
}
