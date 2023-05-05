package com.alten.javsalper.practice2

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.DayOfWeek
import java.time.LocalDate
import java.time.format.DateTimeFormatter
/*
data class Month (
    val day: String,
    val month: String,
    val dayType: String,
    val textColor: String
    ){

    companion object {
        @RequiresApi(Build.VERSION_CODES.O)
        fun mo(): List<Month> {
            val startDate = LocalDate.of(2023,3,27)
            val endDate = LocalDate.of(2023,6,14)
            val formatter = DateTimeFormatter.ofPattern("dd MM YYYY")
            val months = mutableListOf<Month>()
            var currentDate = startDate
            var currenMonth = " "
            var sweekCount=0

            while (!currentDate.isAfter(endDate)) {
                val dayOfWeek = currentDate.dayOfWeek
                val dayType: String
                val textColor : String
                when{
                    dayOfWeek == DayOfWeek.SATURDAY || dayOfWeek == DayOfWeek.SUNDAY -> {
                        dayType = "Descanso"
                        textColor = "Blue"
                    }
                    currentDate in LocalDate.of(2023,4,3)..LocalDate.of(2023,4,14)
                        dayType =
                }
            }
        }
    }

}*/
