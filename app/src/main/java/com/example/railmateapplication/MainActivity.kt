package com.example.railmateapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.railmateapplication.ui.theme.RailMateApplicationTheme
import com.example.railmateapplication.ui.theme.darkTeal
import com.example.railmateapplication.ui.theme.lightGreen
import com.example.trainbookingapplication.components.LocationDetail
import com.example.trainbookingapplication.components.passengerCounter

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RailMateApplicationTheme {
                Surface(color = Color(233, 239, 236)) {
                    ShapesInCompose()
                }
            }
        }
    }
}

@Composable
fun ShapesInCompose() {
    Column {
        BookTicket()
        CancelTicket()
    }
}

@Composable
fun BookTicket() {
    val image: Painter = painterResource(id = R.drawable.right_arrow)
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 50.dp)
    ) {
        Text(
            modifier = Modifier.align(Alignment.Center),
            text = "Book Ticket",
            fontSize = 25.sp,
            color = darkTeal,
            style = TextStyle(fontWeight = FontWeight.Bold)
        )
    }
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 25.dp),
        contentAlignment = Alignment.Center,
    ) {

        Card(
            modifier = Modifier
                .height(290.dp)
                .width(350.dp),
            shape = RoundedCornerShape(corner = CornerSize(15.dp)),
            colors = CardDefaults.cardColors(
                containerColor = Color(106, 156, 137)
            )
        ) {
            Column {
                ConstraintLayout(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 15.dp)
                ) {

                    val fromLocation = createRef()
                    val arrowImage = createRef()
                    val toLocation = createRef()

                    LocationDetail(heading = "From",
                        modifier = Modifier.constrainAs(fromLocation) {
                            start.linkTo(parent.start, margin = 16.dp)
                            top.linkTo(parent.top)
                            bottom.linkTo(parent.bottom)
                        })

                    Image(
                        painter = image,
                        contentDescription = "Right Arrow",
                        modifier = Modifier
                            .size(55.dp)
                            .constrainAs(arrowImage) {
                                start.linkTo(fromLocation.end)
                                end.linkTo(toLocation.start)
                                top.linkTo(fromLocation.top, margin = 50.dp)
                                bottom.linkTo(fromLocation.bottom)
                            },
                        contentScale = ContentScale.Fit
                    )

                    LocationDetail(heading = "To",
                        modifier = Modifier.constrainAs(toLocation) {
                            end.linkTo(parent.end, margin = 16.dp)
                            top.linkTo(parent.top)
                            bottom.linkTo(parent.bottom)
                        })

                }

                passengerCounter(5)

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp),
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    Button(
                        onClick = {},
                        colors = ButtonDefaults.buttonColors(containerColor = darkTeal)
                    ) {
                        Text("Clear All")
                    }
                    Button(
                        onClick = {},
                        colors = ButtonDefaults.buttonColors(containerColor = darkTeal)
                    ) {
                        Text("Book Ticket")
                    }
                }

            }
        }
    }
}

@Composable
fun CancelTicket() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 35.dp)
    ) {
        Text(
            modifier = Modifier.align(Alignment.Center),
            text = "Cancel Ticket",
            fontSize = 25.sp,
            color = darkTeal,
            style = TextStyle(fontWeight = FontWeight.Bold)
        )
    }
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 25.dp),
        contentAlignment = Alignment.Center,
    ) {

        Card(
            modifier = Modifier
                .height(270.dp)
                .width(350.dp),
            shape = RoundedCornerShape(corner = CornerSize(15.dp)),
            colors = CardDefaults.cardColors(
                containerColor = Color(106, 156, 137)
            )
        ) {
            Column {

                var pnrNo by remember { mutableStateOf("") }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 30.dp)
                        .align(Alignment.CenterHorizontally),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(text = "Enter the PNR No: ", fontSize = 20.sp, color = lightGreen)
                    Spacer(modifier = Modifier.width(10.dp))
                    BasicTextField(
                        modifier = Modifier
                            .width(50.dp)
                            .height(50.dp)
                            .background(Color.White),
                        value = pnrNo,
                        onValueChange = { pnrNo = it },
                        textStyle = LocalTextStyle.current.copy(
                            textAlign = TextAlign.Center, fontSize = 30.sp
                        ),
                        singleLine = true
                    )
                }
            }

            passengerCounter(20)

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                Button(
                    onClick = {}, colors = ButtonDefaults.buttonColors(containerColor = darkTeal)
                ) {
                    Text("Clear All")
                }
                Button(
                    onClick = {}, colors = ButtonDefaults.buttonColors(containerColor = darkTeal)
                ) {
                    Text("Cancel Ticket")
                }
            }

        }
    }
}