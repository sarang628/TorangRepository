package com.sarang.torang.util

import java.text.SimpleDateFormat
import java.time.Duration
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId
import java.util.Locale


/* 시간을 방금, 분, 시간, 주 단위로 보여줌 */
object DateConverter {
    val sdf = SimpleDateFormat("yyyy-MM-dd hh:mm:ss")
    val sdf1 = SimpleDateFormat("MMM dd, YYYY", Locale.US)
    fun transformDate(createDate: String): DateDiffType {
        try {
            val ldt = LocalDateTime.now()
            val date = sdf.parse(createDate)
            val instant: Instant = date.toInstant()
            val local = LocalDateTime.ofInstant(instant, ZoneId.systemDefault())

            val duration = Duration.between(local, ldt);

            if (duration.seconds < 60) {
                return DateDiffType.SECOND(duration.seconds)
            } else if (duration.seconds > 60 && duration.toMinutes() < 1) {
                return DateDiffType.MINUTE(duration.toMinutes())
            } else if (duration.toHours() in 1..23) {
                return DateDiffType.HOUR(duration.toHours())
            } else if (duration.toDays() in 1..6) {
                return DateDiffType.DATE(duration.toDays())
            } else {
                return DateDiffType.WEEK(duration.toDays() / 7)
            }

        } catch (e: Exception) {

        }
        return DateDiffType.SECOND(0)
    }

    fun formattedDate(createDate: String): String {
        val date = transformDate(createDate = createDate)
        return when (date) {
            is DateDiffType.SECOND -> "${date.second}s"
            is DateDiffType.MINUTE -> "${date.minute}m"
            is DateDiffType.HOUR -> "${date.hour}h"
            is DateDiffType.DATE -> "${date.date}d"
            is DateDiffType.WEEK -> "${date.week}w"
        }
    }
}


sealed interface DateDiffType {
    data class SECOND(val second: Long) : DateDiffType
    data class MINUTE(val minute: Long) : DateDiffType
    data class HOUR(val hour: Long) : DateDiffType
    data class DATE(val date: Long) : DateDiffType
    data class WEEK(val week: Long) : DateDiffType
}