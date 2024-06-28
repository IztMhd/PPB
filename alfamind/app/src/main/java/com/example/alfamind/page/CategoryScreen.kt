package com.example.alfamind.page

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.alfamind.R
import com.example.alfamind.ui.theme.AlfamindTheme

@Composable
fun CategoryScreen(onHomeClick: () -> Unit, onAccountClick: () -> Unit, onStoreClick: () -> Unit) {
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.White)
    ) {
        Image(
            painter = painterResource(id = R.drawable.background_image),
            contentDescription = "Background",
            contentScale = ContentScale.Fit,
            modifier = Modifier.fillMaxSize()
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 16.dp, bottom = 80.dp) // Adjust padding to account for the bottom navigation bar
        ) {
            // Your content here
            Spacer(modifier = Modifier.height(16.dp))
            // Add more content as needed
        }
        BottomNavigationBar(onHomeClick = onHomeClick, onAccountClick = onAccountClick, onStoreClick = onStoreClick)
    }
}

@Preview(showBackground = true)
@Composable
fun CategoryScreenPreview() {
    AlfamindTheme {
        CategoryScreen(onHomeClick = {}, onAccountClick = {}, onStoreClick = {})
    }
}
