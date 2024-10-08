package com.example.trainbookingapplication.api

import com.example.trainbookingapplication.model.BookMetaData
import com.example.trainbookingapplication.model.CancelMetaData
import com.example.trainbookingapplication.model.SeatId
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface Api {

    @GET("getAllSeats")
    suspend fun getSeatList(@Query("from") from: Char, @Query("to") to: Char): List<Int>

    @POST("book")
    suspend fun bookTicket(@Body bookMetaData: BookMetaData): Response<BookMetaData>

    @POST("cancelSeat")
    suspend fun cancelTicket(@Body cancelMetaData: CancelMetaData): Response<CancelMetaData>

    companion object {
        const val BASE_URL = "https://xyz/TCApp/"
    }

}