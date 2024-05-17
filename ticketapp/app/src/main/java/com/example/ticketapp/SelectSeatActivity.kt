package com.example.ticketapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ticketapp.ui.theme.TicketappTheme

class SelectSeatActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TicketappTheme {
                SelectSeatScreen(onBackClick = { finish() }) // Pass the finish() method to handle back navigation
            }
        }
    }
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun SelectSeatScreen(onBackClick: () -> Unit) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        "SELECT SEAT",
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center,
                        color = Color.White
                    )
                },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(
                            painter = painterResource(id = R.drawable.lets_icons__back),
                            contentDescription = "Back",
                            tint = Color.White,
                            modifier = Modifier.size(24.dp)
                        )
                    }
                },
                backgroundColor = Color(0xFF1B5E20)
            )
        },
        content = {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                SeatSelectionGrid()
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "SCREEN",
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.LightGray)
                        .padding(16.dp),
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.height(16.dp))
                Button(
                    onClick = { /* Handle Buy Ticket Click */ },
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF2E7D32)),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("BUY TICKET", color = Color.White, fontSize = 16.sp)
                }
            }
        }
    )
}

@Composable
fun SeatSelectionGrid() {
    val rows = 10
    val columns = 10
    val selectedSeats = remember { mutableStateListOf<Pair<Int, Int>>() }

    Column {
        for (row in 1..rows) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                for (column in 1..columns) {
                    val isSelected = selectedSeats.contains(Pair(row, column))
                    val isAvailable = (row + column) % 2 == 0 // Sample logic for availability

                    SeatItem(
                        selected = isSelected,
                        available = isAvailable,
                        onClick = {
                            if (isAvailable) {
                                if (isSelected) {
                                    selectedSeats.remove(Pair(row, column))
                                } else {
                                    selectedSeats.add(Pair(row, column))
                                }
                            }
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun SeatItem(selected: Boolean, available: Boolean, onClick: () -> Unit) {
    val color = when {
        selected -> Color.Yellow
        available -> Color.Blue
        else -> Color.Gray
    }

    Box(
        modifier = Modifier
            .size(32.dp)
            .padding(4.dp)
            .background(color, shape = CircleShape)
            .clickable(enabled = available, onClick = onClick)
    )
}
