package com.alten.javsalper.practice2

interface MonthItemListener {

    fun onClickListener(position: Int)

    fun onLongClickListener(position: Int) : Boolean = true

}