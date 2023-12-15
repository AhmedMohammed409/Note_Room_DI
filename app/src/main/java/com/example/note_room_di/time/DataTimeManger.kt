package com.example.note_room_di.time

import android.annotation.SuppressLint
import java.text.SimpleDateFormat
import java.util.Calendar

class DataTimeManger {
    companion object{
        @SuppressLint("SimpleDateFormat", "WeekBasedYear")
        fun CurrentDataTime():String{
            val calander=Calendar.getInstance()
            val datatimeformat=SimpleDateFormat("dd-MM-YYYY hh:mm a")
            return datatimeformat.format(calander.time)
        }
    }
}