package com.example.trainbookingapplication.Screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.trainbookingapplication.components.seat
import com.example.trainbookingapplication.model.SeatMetaData
import com.example.trainbookingapplication.viewModel.MyViewModel

@Composable
fun TrainDashBoard(viewModel: MyViewModel) {

    val seatList by viewModel.seatMetaList.collectAsState()
    val seatListIterator = seatList.iterator()

    Surface {

        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ReservationSeats(seatListIterator)
            RACSeats(seatListIterator)
            Row {
                Button(onClick = {}) {
                    Text(text = "Clear")
                }
                Spacer(modifier = Modifier.width(30.dp))
                Button(onClick = {}) {
                    Text(text = "Submit")
                }
            }
        }
    }
}

@Composable
fun ReservationSeats(seatListIterator: Iterator<SeatMetaData>) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 40.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            modifier = Modifier.padding(bottom = 30.dp),
            text = "Reservation Seats",
            style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold)
        )
        Row(
            Modifier
                .width(300.dp)
                .padding(bottom = 20.dp),
            horizontalArrangement = Arrangement.Absolute.SpaceEvenly
        ) {
            repeat(4) {
                val seatMetaData: SeatMetaData = seatListIterator.next()
                seat(seatMetaData.seatId.toString(), seatMetaData.Color)
            }
        }

        Row(
            Modifier
                .width(300.dp)
                .padding(bottom = 20.dp),
            horizontalArrangement = Arrangement.Absolute.SpaceEvenly
        ) {
            repeat(4) {
                val seatMetaData: SeatMetaData = seatListIterator.next()
                seat(seatMetaData.seatId.toString(), seatMetaData.Color)
            }
        }

        Row(
            Modifier
                .width(300.dp)
                .padding(bottom = 20.dp),
            horizontalArrangement = Arrangement.Absolute.SpaceEvenly
        ) {
            repeat(4) {
                val seatMetaData: SeatMetaData = seatListIterator.next()
                seat(seatMetaData.seatId.toString(), seatMetaData.Color)
            }
        }

    }
}

@Composable
fun RACSeats(seatListIterator: Iterator<SeatMetaData>) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 40.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            modifier = Modifier.padding(bottom = 30.dp),
            text = "RAC Seats",
            style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold)
        )
        Row(
            Modifier
                .width(300.dp)
                .padding(bottom = 20.dp),
            horizontalArrangement = Arrangement.Absolute.SpaceEvenly
        ) {
            repeat(4) {
                val seatMetaData: SeatMetaData = seatListIterator.next()
                seat(seatMetaData.seatId.toString(), seatMetaData.Color)
            }
        }

        Row(
            Modifier
                .width(300.dp)
                .padding(bottom = 20.dp),
            horizontalArrangement = Arrangement.Absolute.SpaceEvenly
        ) {
            repeat(4) { it ->
                Card(
                    modifier = Modifier.size(50.dp)
                ) {
                    repeat(4) {
                        val seatMetaData: SeatMetaData = seatListIterator.next()
                        seat(seatMetaData.seatId.toString(), seatMetaData.Color)
                    }
                }
            }
        }

    }

}
