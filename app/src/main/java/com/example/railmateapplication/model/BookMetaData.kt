package com.example.trainbookingapplication.model

data class BookMetaData(
    var from: String,
    var seatList: List<Int>,
    var to: String
)