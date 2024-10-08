package com.example.trainbookingapplication.Screen

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
import androidx.compose.foundation.layout.wrapContentHeight
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.trainbookingapplication.R
import com.example.trainbookingapplication.ShapesInCompose
import com.example.trainbookingapplication.components.LocationDetail
import com.example.trainbookingapplication.ui.theme.darkTeal
import com.example.trainbookingapplication.ui.theme.lightGreen

@Composable
fun MainScreen() {
    Surface(color = Color(233, 239, 236)) {
        ShapesInCompose()
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ShapesInCompose() {
    Column(
        modifier = Modifier
            .wrapContentHeight()
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(20.dp, alignment = Alignment.CenterVertically),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ApplicationName()
        BookTicket()
        CancelTicket()
    }
}


@Composable
fun ApplicationName() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(end = 12.dp, start = 12.dp, top = 30.dp, bottom = 30.dp)
            .background(color = darkTeal)
            .padding(16.dp) // Inner padding for the Text
    ) {
        Text(
            text = "Train Ticket Booking Application",
            color = Color.White,
            fontSize = 30.sp,
            style = TextStyle(textAlign = TextAlign.Center, fontWeight = FontWeight.Bold),
            modifier = Modifier.fillMaxWidth() // To make sure text is centered within the box
        )
    }
}

@Composable
fun BookTicket() {
    val image: Painter = painterResource(id = R.drawable.right_arrow)
    Column {
        Box(
            modifier = Modifier.fillMaxWidth()
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
                    .height(200.dp)
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
                            .padding(top = 10.dp)
                    ) {

                        val fromLocation = createRef()
                        val arrowImage = createRef()
                        val toLocation = createRef()

                        LocationDetail(
                            heading = "From",
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

                        LocationDetail(heading = "To", modifier = Modifier.constrainAs(toLocation) {
                            end.linkTo(parent.end, margin = 16.dp)
                            top.linkTo(parent.top)
                            bottom.linkTo(parent.bottom)
                        })

                    }

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
                            Text("Clear Fields")
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
}

@Composable
fun CancelTicket() {
    Column {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 50.dp)
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
                    .height(170.dp)
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

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 20.dp),
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    Button(
                        onClick = {},
                        colors = ButtonDefaults.buttonColors(containerColor = darkTeal)
                    ) {
                        Text("Clear Fields")
                    }
                    Button(
                        onClick = {},
                        colors = ButtonDefaults.buttonColors(containerColor = darkTeal)
                    ) {
                        Text("Cancel Ticket")
                    }
                }

            }
        }
    }
}