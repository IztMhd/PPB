package com.example.alfamind.page

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.alfamind.R
import com.example.alfamind.ui.theme.AlfamindTheme

@Composable
fun StoreProfileScreen(
    onBackClicked: () -> Unit,
    onAccountClick: () -> Unit,
    onStoreClick: () -> Unit,
    onProfileClick: () -> Unit,
    onHomeClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Image(
            painter = painterResource(id = R.drawable.store_profile_background),
            contentDescription = "Store Profile Background",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Spacer(modifier = Modifier.height(166.dp))  // Adjust the height as needed
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp) // Base padding
            ) {
                Spacer(modifier = Modifier.width(12.dp)) // Move text more to the right by specific amount
                Text(
                    text = "Profil Toko",
                    fontSize = 17.sp,
                    color = Color.White,
                    modifier = Modifier
                        .clickable { onProfileClick() }
                        .padding(16.dp)
                )
            }
            // Add your other UI components here
        }
        BottomNavigationBar(onHomeClick = onHomeClick, onAccountClick = onAccountClick, onStoreClick = onStoreClick)
    }
}

@Preview(showBackground = true)
@Composable
fun StoreProfileScreenPreview() {
    AlfamindTheme {
        StoreProfileScreen({}, {}, {}, {}, {})
    }
}
