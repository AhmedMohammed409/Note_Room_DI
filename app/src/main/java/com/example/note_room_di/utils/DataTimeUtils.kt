package com.example.note_room_di.utils

import java.text.SimpleDateFormat
import java.util.Locale

fun currentDateTime(): String {
    val currentTime = System.currentTimeMillis()
    val formatter = SimpleDateFormat("dd-MM-yyyy hh:mm a", Locale.ENGLISH)
    return formatter.format(currentTime)
}