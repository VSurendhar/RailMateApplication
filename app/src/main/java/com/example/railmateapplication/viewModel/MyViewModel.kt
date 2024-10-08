package com.example.trainbookingapplication.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.trainbookingapplication.api.ApiResult
import com.example.trainbookingapplication.model.BookMetaData
import com.example.trainbookingapplication.model.CancelMetaData
import com.example.trainbookingapplication.model.SeatMetaData
import com.example.trainbookingapplication.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MyViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {

    private val _seatList = MutableStateFlow<List<Int>>(emptyList())
    val seatList = _seatList.asStateFlow()

    private val _seatMetaList = MutableStateFlow<List<SeatMetaData>>(emptyList())
    val seatMetaList = _seatMetaList.asStateFlow()

    private var from: Char = ' '
    private var to: Char = ' '

    private val _showErrorToastChannel = Channel<Boolean>()
    val showErrorToastChannel = _showErrorToastChannel.receiveAsFlow()


    public fun book(from: Char, to: Char, seatList: List<Int>) {
        viewModelScope.launch {
            repository.bookTicket(BookMetaData(from.toString(), seatList, to.toString()))
        }
    }

    public fun cancel(pnrNo: Int, seatList: List<Int>) {
        viewModelScope.launch {
            repository.cancelTicket(CancelMetaData(pnrNo, seatList))
        }
    }

    public fun getSeatList(from: Char, to: Char) {
        viewModelScope.launch {
            repository.getSeatList(from, to).collectLatest { result ->
                when (result) {
                    is ApiResult.Success -> {
                        result.data?.let { seatList ->
                            _seatList.update { seatList }
                        } ?: run {
                            _showErrorToastChannel.send(true)
                        }
                    }

                    is ApiResult.Error -> {
                        println("Error fetching seats: ${result.message}")
                        _showErrorToastChannel.send(true)
                    }

                    else -> {
                        _showErrorToastChannel.send(true)
                    }

                }
            }
        }
    }


}