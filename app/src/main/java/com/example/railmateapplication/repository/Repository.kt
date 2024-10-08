package com.example.trainbookingapplication.repository

import com.example.trainbookingapplication.api.ApiResult
import com.example.trainbookingapplication.model.BookMetaData
import com.example.trainbookingapplication.model.CancelMetaData
import kotlinx.coroutines.flow.Flow

interface Repository {
    suspend fun getSeatList(from: Char, to: Char): Flow<ApiResult<List<Int>>>
    suspend fun bookTicket(bookMetaData: BookMetaData)
    suspend fun cancelTicket(cancelMetaData: CancelMetaData)
}