package com.example.trainbookingapplication.model

import android.graphics.Color
import com.example.trainbookingapplication.ui.theme.disable

data class SeatMetaData(
    var enable: Boolean,
    var selected: Boolean,
    var seatId: Int,
    var Color: Color = disable
)