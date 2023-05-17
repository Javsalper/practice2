package com.alten.javsalper.practice2

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.DayOfWeek
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.format.TextStyle
import java.util.Locale

data class Month (
    val day: String,
    val month: String,
    var dayType: String,
    val textColor: String,
    val shortDay: String
    ){

    companion object {
        @RequiresApi(Build.VERSION_CODES.O)
        fun SevilleCalendar(): List<Month> {
            val startDate = LocalDate.of(2023, 3, 27)
            val endDate = LocalDate.of(2023, 6, 14)
            val formatter = DateTimeFormatter.ofPattern("dd MM YYYY")
            val months = mutableListOf<Month>()
            var currentDate = startDate
            var currentMonth = " "
            var weekCount = 0


            while (!currentDate.isAfter(endDate)) {
                val dayOfWeek = currentDate.dayOfWeek
                val dayType: String
                val textColor: String

                when {
                    dayOfWeek == DayOfWeek.SATURDAY || dayOfWeek == DayOfWeek.SUNDAY -> {
                        dayType = "Descanso"
                        textColor = "Blue"
                    }

                    currentDate in LocalDate.of(2023, 4, 3)..LocalDate.of(
                        2023,
                        4,
                        7
                    ) || currentDate in LocalDate.of(2023, 4, 24)..LocalDate.of(2023, 5, 1) -> {
                        dayType = "Vacaciones"
                        textColor = "Red"
                    }

                    weekCount % 2 == 0 && dayOfWeek == DayOfWeek.THURSDAY -> {
                        dayType = "Centro"
                        textColor = "Yellow"
                    }

                    else -> {
                        dayType = "Formación"
                        textColor = "Green"
                    }

                }


                val formattedDate = currentDate.format(formatter)
                val monthName = currentDate.month.getDisplayName(
                    TextStyle.FULL_STANDALONE,
                    Locale("Spanish", "Spain")
                )

                if (monthName != currentMonth) {
                    months.add(
                        Month(
                            formattedDate,
                            monthName,
                            dayType,
                            textColor,
                            shortDay = DayOfWeekState(currentDate)
                        )
                    )
                    currentMonth = monthName
                } else {
                    months.add(
                        Month(
                            formattedDate,
                            " ",
                            dayType,
                            textColor,
                            shortDay = DayOfWeekState(currentDate)
                        )
                    )
                }

                currentDate =
                    currentDate.plusDays(1)
                if (dayOfWeek == DayOfWeek.SUNDAY) {
                    weekCount++
                }

            }
            return months
        }

        @RequiresApi(Build.VERSION_CODES.O)
        fun CadizCalendar(): List<Month> {
            val startDate = LocalDate.of(2023, 3, 27)
            val endDate = LocalDate.of(2023, 6, 14)
            val formatter = DateTimeFormatter.ofPattern("dd MM YYYY")
            val months = mutableListOf<Month>()
            var currentDate = startDate
            var currentMonth = " "
            var weekCount = 0

            while (!currentDate.isAfter(endDate)) {
                val dayOfWeek = currentDate.dayOfWeek
                val dayType: String
                val textColor: String
                when {
                    dayOfWeek == DayOfWeek.SATURDAY || dayOfWeek == DayOfWeek.SUNDAY -> {
                        dayType = "Rest"
                        textColor = "Blue"
                    }

                    currentDate in LocalDate.of(2023, 4, 3)..LocalDate.of(
                        2023,
                        4,
                        7
                    ) || currentDate in LocalDate.of(2023, 5, 1)..LocalDate.of(2023, 5, 1) -> {
                        dayType = "Holidays"
                        textColor = "Red"
                    }

                    weekCount % 2 == 0 && dayOfWeek == DayOfWeek.THURSDAY -> {
                        dayType = "Center"
                        textColor = "Yellow"
                    }

                    else -> {
                        dayType = "Work"
                        textColor = "Green"
                    }

                }

                val formattedDate = currentDate.format(formatter)
                val monthName = currentDate.month.getDisplayName(
                    TextStyle.FULL_STANDALONE,
                    Locale("Spanish", "Spain")
                )

                if (monthName != currentMonth) {
                    months.add(
                        Month(
                            formattedDate,
                            monthName,
                            dayType,
                            textColor,
                            shortDay = DayOfWeekState(currentDate)
                        )
                    )
                    currentMonth = monthName
                } else {
                    months.add(
                        Month(
                            formattedDate,
                            " ",
                            dayType,
                            textColor,
                            shortDay = DayOfWeekState(currentDate)
                        )
                    )
                }

                currentDate =
                    currentDate.plusDays(1)
                if (dayOfWeek == DayOfWeek.SUNDAY) {
                    weekCount++
                }

            }

            return months
        }
       @RequiresApi(Build.VERSION_CODES.O)
       fun DayOfWeekState(date: LocalDate): String {
           val letterD: String
           val nD: DayOfWeek = date.dayOfWeek
           val dayOfMonth: Int = date.dayOfMonth
           when (nD) {
               DayOfWeek.MONDAY -> letterD = "L"
               DayOfWeek.TUESDAY -> letterD = "M"
               DayOfWeek.WEDNESDAY -> letterD = "X"
               DayOfWeek.THURSDAY -> letterD = "J"
               DayOfWeek.FRIDAY -> letterD = "V"
               DayOfWeek.SATURDAY -> letterD = "S"
               DayOfWeek.SUNDAY -> letterD = "D"
               else -> letterD = " "
           }
           return "$letterD$dayOfMonth"
       }
    }
}

