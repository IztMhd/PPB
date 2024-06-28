package com.example.alfamind.page

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.alfamind.R

@Composable
fun BottomNavigationBar(
    onHomeClick: () -> Unit,
    onAccountClick: () -> Unit,
    onStoreClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp),  // Adjust the height as needed
            color = Color.White,
            elevation = 10.dp,
            shape = RoundedCornerShape(16.dp)
        ) {
            BottomNavigation(
                backgroundColor = Color.White,
                elevation = 0.dp
            ) {
                BottomNavigationItem(
                    icon = {
                        Icon(
                            Icons.Filled.Home,
                            contentDescription = "Beranda",
                            modifier = Modifier.size(30.dp)  // Increase icon size
                        )
                    },
                    label = {
                        Text(
                            "Beranda",
                            fontSize = 14.sp  // Increase text size
                        )
                    },
                    selected = false,
                    onClick = { onHomeClick() }
                )
                BottomNavigationItem(
                    icon = {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_store),
                            contentDescription = "Toko Saya",
                            modifier = Modifier.size(30.dp)  // Increase icon size
                        )
                    },
                    label = {
                        Text(
                            "Toko Saya",
                            fontSize = 14.sp  // Increase text size
                        )
                    },
                    selected = true,
                    onClick = { onStoreClick() }
                )
                BottomNavigationItem(
                    icon = {
                        Icon(
                            Icons.Filled.ShoppingCart,
                            contentDescription = "Transaksi",
                            modifier = Modifier.size(30.dp)  // Increase icon size
                        )
                    },
                    label = {
                        Text(
                            "Transaksi",
                            fontSize = 14.sp  // Increase text size
                        )
                    },
                    selected = false,
                    onClick = { /* Handle transaction click */ }
                )
                BottomNavigationItem(
                    icon = {
                        Icon(
                            Icons.Filled.Person,
                            contentDescription = "Akun Saya",
                            modifier = Modifier.size(30.dp)  // Increase icon size
                        )
                    },
                    label = {
                        Text(
                            "Akun Saya",
                            fontSize = 14.sp  // Increase text size
                        )
                    },
                    selected = false,
                    onClick = { onAccountClick() }
                )
            }
        }
    }
}
