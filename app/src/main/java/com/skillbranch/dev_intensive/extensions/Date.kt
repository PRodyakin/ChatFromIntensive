package com.skillbranch.dev_intensive.extensions

import android.text.format.DateUtils
import java.text.SimpleDateFormat
import java.time.Duration
import java.util.*
import java.util.jar.JarEntry
import java.util.regex.Pattern

const val SECOND = 1000L
const val MINUTE = 60 * SECOND
const val HOUR = 60 * MINUTE
const val DAY = 24 * HOUR


fun Date.doFormat(pattern: String ="HH:mm:ss dd.mm.yy"):String{
    val dateFormat = SimpleDateFormat(pattern, Locale("ru"))
    return dateFormat.format(this)
}

fun Date.add(value:Int, units:TimeUnits):Date{
    var time = this.time

    time += when(units){
        TimeUnits.SECOND -> value * SECOND
        TimeUnits.MINUTE -> value * MINUTE
        TimeUnits.HOUR -> value * HOUR
        TimeUnits.DAY-> value * DAY
    }
    this.time = time
    return this
}

enum class TimeUnits() {
    SECOND,
    DAY,
    MINUTE,
    HOUR


}

class TimeParse(
    val milSec:Long){
   val seconds = milSec / SECOND
   val minutes = milSec / MINUTE
   val hours = milSec / HOUR
   val days = milSec / DAY
}


fun Date.humanizeDiff():String?{

    val diff:TimeParse = TimeParse(Date().time - this.time);

    fun getTimeAddition(value:Long, caseOne:String, caseTwo:String, caseFive:String):String{

       return when{
           ((value % 10) == 1L) && ((value % 100) != 11L) -> caseOne
           ((value % 10) >= 2L) && ((value % 10) <= 4L) && ((value % 100) < 10L || (value % 100) >= 20L) -> caseTwo
            else -> caseFive
        }

    }

    val answer:String = when{
        diff.days > 336  -> "${diff.days/336} ${getTimeAddition(diff.days /336,"год","года","лет")} назад"
        diff.days > 28 -> "${diff.days/28} ${getTimeAddition(diff.days /28,"месяц","месяца","месяцев")} назад"
        diff.days > 6 -> "${diff.days/6} ${getTimeAddition(diff.days /6,"неделю","недели","недель")} назад"
        diff.days > 0 -> "${diff.days} ${getTimeAddition(diff.days,"день","дня","дней")} назад"
        diff.hours > 0 -> "${diff.hours} ${getTimeAddition(diff.hours,"час","часа","часов")} назад"
        diff.minutes > 0 -> "${diff.minutes} ${getTimeAddition(diff.minutes,"минуту","минуты","минут")} назад"
        diff.seconds > 0 -> "${diff.seconds} ${getTimeAddition(diff.seconds,"секунду","секунды","секунд")} назад"
        else -> "только что"
    }

    return answer;
}