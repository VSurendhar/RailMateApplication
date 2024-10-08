package com.example.trainbookingapplication.model

data class CancelMetaData(
    val pnrNo: Int,
    val seatList: List<Int>
)