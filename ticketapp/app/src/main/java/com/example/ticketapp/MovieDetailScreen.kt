package com.example.ticketapp

import android.content.Intent
import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MovieDetailScreen(navController: NavController, movie: Movie) {
    val context = LocalContext.current

    Scaffold {
        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            item {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(300.dp)
                ) {
                    Image(
                        painter = painterResource(id = movie.imageRes),
                        contentDescription = movie.title,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(300.dp),
                        contentScale = ContentScale.Crop
                    )
                    IconButton(
                        onClick = { navController.navigateUp() },
                        modifier = Modifier
                            .padding(16.dp)
                            .size(48.dp)
                            .background(Color.Gray.copy(alpha = 0.5f), shape = CircleShape)
                            .align(Alignment.TopStart)
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.lets_icons__back),
                            contentDescription = "Back",
                            tint = Color.White,
                            modifier = Modifier.size(24.dp)
                        )
                    }
                }
            }
            item {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp)
                ) {
                    MovieInfoSection(movie)
                    Spacer(modifier = Modifier.height(16.dp))
                    SynopsisSection()
                    Spacer(modifier = Modifier.height(16.dp))
                }
            }
            items(3) {
                ShowTimesCard {
                    val intent = Intent(context, SelectSeatActivity::class.java)
                    context.startActivity(intent)
                }
            }
        }
    }
}

@Composable
fun MovieInfoSection(movie: Movie) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = movie.imageRes),
                contentDescription = movie.title,
                modifier = Modifier
                    .size(100.dp)
                    .padding(end = 16.dp),
                contentScale = ContentScale.Crop
            )
            Column {
                Text(
                    text = movie.title,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
                Text(
                    text = "Slice of Life, Komedi",
                    fontSize = 14.sp,
                    color = Color.Gray
                )
                Spacer(modifier = Modifier.height(8.dp))
                Row(
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    Column {
                        Text(
                            text = "Length",
                            fontSize = 14.sp,
                            color = Color.Black
                        )
                        Text(
                            text = "1h 34min",
                            fontSize = 14.sp,
                            color = Color.Black
                        )
                    }
                    Column {
                        Text(
                            text = "Language",
                            fontSize = 14.sp,
                            color = Color.Black
                        )
                        Text(
                            text = "Japanese",
                            fontSize = 14.sp,
                            color = Color.Black
                        )
                    }
                    Column {
                        Text(
                            text = "Released",
                            fontSize = 14.sp,
                            color = Color.Black
                        )
                        Text(
                            text = "09 Oct 2023",
                            fontSize = 14.sp,
                            color = Color.Black
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun SynopsisSection() {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = "Sinopsis",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )
        Text(
            text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
            fontSize = 14.sp,
            color = Color.Gray
        )
    }
}

@Composable
fun ShowTimesCard(onClick: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .background(Color(0xFFF0F0F0), shape = MaterialTheme.shapes.medium)
            .padding(16.dp)
    ) {
        Text(
            text = "MALL ABC",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            for (i in 1..4) {
                Button(
                    onClick = onClick,
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF1B5E20))
                ) {
                    Text("12:00", color = Color.White)
                }
            }
        }
    }
}
