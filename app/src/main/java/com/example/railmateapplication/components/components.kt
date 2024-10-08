package com.example.trainbookingapplication.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Card
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.trainbookingapplication.R
import com.example.trainbookingapplication.ui.theme.disable
import com.example.trainbookingapplication.ui.theme.lightGreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DropDownBox() {
    val stops = listOf("A", "B", "C", "D", "E")
    var expanded by remember { mutableStateOf(false) }
    var selectedText by remember { mutableStateOf("") }

    ExposedDropdownMenuBox(modifier = Modifier
        .width(50.dp)
        .height(50.dp),
        expanded = expanded,
        onExpandedChange = { expanded = !expanded }) {
        Box(
            modifier = Modifier
                .background(color = lightGreen)
                .fillMaxWidth()
                .height(50.dp),
            contentAlignment = Alignment.Center
        ) {
            BasicTextField(
                modifier = Modifier
                    .menuAnchor()
                    .background(color = lightGreen)
                    .width(50.dp)
                    .fillMaxWidth(),
                value = selectedText,
                onValueChange = {},
                singleLine = true,
                readOnly = true,
                textStyle = LocalTextStyle.current.copy(
                    textAlign = TextAlign.Center, fontSize = 30.sp
                )

            )

        }
        ExposedDropdownMenu(
            modifier = Modifier.background(lightGreen),
            expanded = expanded,
            onDismissRequest = { expanded = false },
        ) {
            stops.forEach { stop ->
                DropdownMenuItem(
                    text = { Text(text = stop, color = Color.Black) },
                    onClick = {
                        selectedText = stop
                        expanded = false
                    },
                )
            }
        }
    }
}

@Composable
fun LocationDetail(heading: String, modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .wrapContentSize()
            .padding(10.dp)
    ) {
        Text(
            text = heading,
            color = lightGreen,
            fontSize = 20.sp,
            style = TextStyle(fontWeight = FontWeight.Bold)
        )
        Spacer(modifier = Modifier.height(20.dp))
        DropDownBox()
    }
}

@Composable
fun count(top: Int) {

    var count by remember { mutableStateOf(0) }

    val incrementPainter = painterResource(R.drawable.add)
    val decrementPainter = painterResource(R.drawable.minus)

    Row(
        modifier = Modifier.padding(top = top.dp)
    ) {
        IconButton(onClick = {}) {
            Icon(
                decrementPainter,
                contentDescription = "Decrement Count",
                modifier = Modifier.size(27.dp),
                tint = lightGreen
            )
        }
        Spacer(modifier = Modifier.width(10.dp))
        Text(
            text = count.toString(),
            color = lightGreen,
            style = TextStyle(fontSize = 25.sp),
            modifier = Modifier.align(Alignment.CenterVertically)
        )
        Spacer(modifier = Modifier.width(10.dp))
        IconButton(onClick = {}) {
            Icon(
                incrementPainter,
                contentDescription = "Increment Count",
                modifier = Modifier.size(27.dp),
                tint = lightGreen
            )
        }
    }

}

@Composable
fun passengerCounter(top: Int) {
    Box(modifier = Modifier.fillMaxWidth()) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.Center)
                .padding(top = top.dp)
        ) {
            Text(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(top = 8.dp),
                text = "Enter the Passengers Count",
                fontSize = 20.sp,
                color = lightGreen,
            )
            Box(modifier = Modifier.align(Alignment.CenterHorizontally)) {
                count(5)
            }
        }
    }
}

@Preview
@Composable
fun seat(id: String = "0", color: Color = disable) {
    Card(
        modifier = Modifier.size(50.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(color), contentAlignment = Alignment.Center
        ) {
            Text(
                text = "$id", fontSize = 20.sp, color = Color.Black
            )
        }
    }
}