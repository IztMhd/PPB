package com.example.ticketapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.ticketapp.ui.theme.TicketappTheme

data class Movie(val title: String, val imageRes: Int)

val movies = listOf(
    Movie("Laskar Pelangi", R.drawable.laskar_pelangi),
    Movie("Suzume", R.drawable.suzume),
    Movie("Laskar Pelangi", R.drawable.laskar_pelangi),
    Movie("Suzume", R.drawable.suzume)
)

@Composable
fun MainScreen(navController: NavController) {
    Scaffold(
        topBar = { CustomTopBar() },
        bottomBar = { BottomNavigationBar() }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .background(Color.White),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            item {
                SearchBar()
            }
            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = "Now Showing", fontSize = 20.sp, color = Color.Black)
                    TextButton(onClick = { /* Handle more click */ }) {
                        Text(text = "MORE", color = Color.Black)
                    }
                }
            }
            items(movies.chunked(2)) { rowMovies ->
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    rowMovies.forEach { movie ->
                        Box(
                            modifier = Modifier
                                .weight(1f)
                                .border(1.dp, Color.Gray, shape = RoundedCornerShape(8.dp))
                                .padding(8.dp)
                                .clickable {
                                    navController.navigate("movie_detail/${movie.title}")
                                }
                        ) {
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Image(
                                    painter = painterResource(id = movie.imageRes),
                                    contentDescription = movie.title,
                                    modifier = Modifier
                                        .height(180.dp)
                                        .fillMaxWidth()
                                )
                                Spacer(modifier = Modifier.height(8.dp))
                                Text(
                                    text = movie.title,
                                    fontSize = 14.sp,
                                    color = Color.Black,
                                    textAlign = TextAlign.Center
                                )
                            }
                        }
                    }
                }
            }
            item {
                QuickAccess()
            }
        }
    }
}

@Composable
fun CustomTopBar() {
    TopAppBar(
        backgroundColor = Color(0xFF008000), // Green color to match the original design
        contentColor = Color.White,
        title = {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.cinema_xxi),
                    contentDescription = "Cinema XXI",
                    modifier = Modifier
                        .height(40.dp)
                )
            }
        },
        navigationIcon = {
            IconButton(onClick = { /* Handle navigation icon click */ }) {
                Icon(
                    painter = painterResource(id = R.drawable.ic__round_menu),
                    contentDescription = "Menu",
                    modifier = Modifier.size(24.dp)
                )
            }
        }
    )
}

@Composable
fun SearchBar() {
    TextField(
        value = "",
        onValueChange = {},
        placeholder = { Text("Search") },
        leadingIcon = {
            Icon(
                painter = painterResource(id = R.drawable.iconamoon__search),
                contentDescription = "Search Icon",
                modifier = Modifier.size(24.dp)
            )
        },
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp)
            .background(Color(0xFFE0E0E0), shape = MaterialTheme.shapes.small)
            .padding(horizontal = 16.dp),
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = Color(0xFFE0E0E0),
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        )
    )
}

@Composable
fun QuickAccess() {
    Column(modifier = Modifier.padding(16.dp)) {
        Text(
            text = "Quick Access",
            fontSize = 20.sp,
            color = Color.Black,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            QuickAccessItem(R.drawable.hugeicons__location_04, "Location")
            QuickAccessItem(R.drawable.material_symbols__id_card_outline, "Member")
            QuickAccessItem(R.drawable.tabler__news, "News")
            QuickAccessItem(R.drawable.iconamoon__discount_thin, "Promotions")
        }
    }
}

@Composable
fun QuickAccessItem(iconRes: Int, label: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Icon(
            painter = painterResource(id = iconRes),
            contentDescription = label,
            modifier = Modifier.size(48.dp) // Increased size for better visibility
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(text = label, fontSize = 12.sp, color = Color.Black)
    }
}

@Composable
fun BottomNavigationBar() {
    BottomNavigation(
        backgroundColor = Color(0xFF008000),
        contentColor = Color.White
    ) {
        BottomNavigationItem(
            icon = { Icon(painterResource(id = R.drawable.ic__baseline_home), contentDescription = "Home", modifier = Modifier.size(24.dp)) },
            label = { Text("Home") },
            selected = true,
            onClick = {}
        )
        BottomNavigationItem(
            icon = { Icon(painterResource(id = R.drawable.ion__ticket), contentDescription = "Tickets", modifier = Modifier.size(24.dp)) },
            label = { Text("Tickets") },
            selected = false,
            onClick = {}
        )
        BottomNavigationItem(
            icon = { Icon(painterResource(id = R.drawable.mdi__food), contentDescription = "F&B", modifier = Modifier.size(24.dp)) },
            label = { Text("F&B") },
            selected = false,
            onClick = {}
        )
        BottomNavigationItem(
            icon = { Icon(painterResource(id = R.drawable.ic__sharp_person), contentDescription = "Profile", modifier = Modifier.size(24.dp)) },
            label = { Text("Profile") },
            selected = false,
            onClick = {}
        )
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    val navController = rememberNavController()
    TicketappTheme {
        MainScreen(navController)
    }
}
