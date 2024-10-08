package com.example.trainbookingapplication.repository

import com.example.trainbookingapplication.api.Api
import com.example.trainbookingapplication.api.ApiResult
import com.example.trainbookingapplication.model.BookMetaData
import com.example.trainbookingapplication.model.CancelMetaData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import retrofit2.Response
import java.io.IOException
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val api: Api
) : Repository {

    override suspend fun getSeatList(from: Char, to: Char): Flow<ApiResult<List<Int>>> {
        return flow {
            val seatListFromApi = try {
                api.getSeatList(from, to)
            } catch (e: IOException) {
                e.printStackTrace()
                emit(ApiResult.Error("Couldn't load data"))
                return@flow
            } catch (e: HttpException) {
                e.printStackTrace()
                emit(ApiResult.Error(message = "Http Exception"))
                return@flow
            } catch (e: Exception) {
                e.printStackTrace()
                emit(ApiResult.Error(message = "Error loading Items"))
                return@flow
            }
            emit(ApiResult.Success(seatListFromApi))
        }
    }

    override suspend fun bookTicket(bookMetaData: BookMetaData) {

        val response: Response<BookMetaData>? = try {
            api.bookTicket(bookMetaData)
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }

        if (response != null && response.isSuccessful) {
            println("bookMetaData posted successfully")
        } else {
            println("Failed to post item")
        }

    }

    override suspend fun cancelTicket(cancelMetaData: CancelMetaData) {

        val response: Response<CancelMetaData>? = try {
            api.cancelTicket(cancelMetaData)
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }

        if (response != null && response.isSuccessful) {
            println("cancelMetaData posted successfully")
        } else {
            println("Failed to post item")
        }

    }

}